import net.sf.bpm.implicit.Act
import net.sf.bpm.implicit.Behaviour
import net.sf.bpm.implicit.WeaverHelper

class ImplicitBpmFilters {

    def proxyService

    def filters = {
        all(controller:'*', action:'*', actionExclude:'inject') {
            before = {
                println "before filter: $actionName -> $controllerName"

                def weaverHelper = WeaverHelper.createInstance()
                def temp = weaverHelper.getWhenActions(actionName, controllerName, "replace")
                def acts = weaverHelper.getActsForJointPointFromAll(temp, actionName, controllerName)
                for(Act a in acts){
                    for(Behaviour b in a.behaviours){
                        b.fromController = weaverHelper.controllerInfo.containsKey(b.fromController) ? b.fromController : controllerName
                        if(b.element == "view") {
                            redirect(action: b.variable, controller: b.fromController)
                        }
                        else if(b.element == "action"){
                            b.fromController = weaverHelper.controllerInfo.containsKey(b.fromController) ? b.fromController : controllerName
                            def controller = applicationContext.getBean(grailsApplication.getArtefactByLogicalPropertyName("Controller", b.fromController).fullName)
                            controller."$b.variable"()

                        }
                        else if(b.element == "element"){
                            proxyService.element(b)
                        }
                        else if(b.element == "attribute"){
                            proxyService.attribute(b)
                        }
                    }

                }
                return acts.isEmpty()
            }

            after = { Map model ->

            }
            afterView = { Exception e ->

            }
        }
    }
}
