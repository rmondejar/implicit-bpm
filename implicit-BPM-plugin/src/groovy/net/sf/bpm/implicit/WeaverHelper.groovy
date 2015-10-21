package net.sf.bpm.implicit

import org.codehaus.groovy.grails.web.context.ServletContextHolder
import org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes

class WeaverHelper {


    private static WeaverHelper weaverHelper = null

    static def whenActions = [:].withDefault { [] }

    def actualWeavers
    def modelInfo
    def controllerInfo
    def viewInfo

    private WeaverHelper(){
        actualWeavers = getActualWeavers()
        println "Proxy weavers : $actualWeavers"
        /*if(actualWeavers.isEmpty())
            return false
        */

        modelInfo = reflectionService.modelClassNames
        /* modelInfo.each{k, Class v->
             def domainClass = grailsApplication.classLoader.loadClass(v.name)
             def domainObj = domainClass.newInstance()
         }*/
        controllerInfo = reflectionService.controllerInfo
        /*controllerInfo.each {controllerName, methods ->
            println "controller name :" + controllerName
            methods.each {
                println "method: " + it
            }
        }*/
        viewInfo = reflectionService.viewInfo
        /*viewInfo.each { k, v ->
            v.each{ viewName ->
                println viewName
            }
        }*/
    }

    public static def createInstance(){
        if(!weaverHelper)
            weaverHelper = new WeaverHelper()
        weaverHelper
    }

    private ReflectionService getReflectionService() {
        def ctx = ServletContextHolder.servletContext.getAttribute(GrailsApplicationAttributes.APPLICATION_CONTEXT)
        ctx.reflectionService
    }

    def getActualWeavers(){
        if(!actualWeavers){
            refreshWeavers()
        }
        actualWeavers
    }

    def refreshWeavers(){
        List weavers = Weaver.actives.list()
        actualWeavers = weavers.findAll{
            it.appName?.equalsIgnoreCase(getReflectionService().getAppInstanceData().name)
        }
        whenActions = [:].withDefault { [] }
        println "Refresh: $actualWeavers"
    }

   def getActsForJoinpont(actualMethod, actualController ){
        def acts = []
        for(Weaver w : actualWeavers){
            for(Act a : w.acts){
                if(a.variable == actualMethod && (a.fromController ? (a.fromController == actualController) : true)){
                    acts << a
                }
            }
        }
        acts
    }

    def getActsForJointPointFromAll(acts, actualMethod, actualController){
        def newActs = acts.findAll{a ->
            a.variable == actualMethod && (a.fromController ? (a.fromController == actualController) : true)
        }
        newActs
    }

    def getWhenActions(actualMethod, actualController, theWhen){
        if(!whenActions){
            for(Weaver w : actualWeavers){
                for(Act a : w.acts){
                    whenActions[a.when] << a
                }
            }
        }
        def acts = []
        whenActions.each {k,v->
            if(k == theWhen){
                v.each { a ->
                    if(a.variable == actualMethod && (a.fromController ? (a.fromController == actualController) : true))
                        acts << a
                }
            }
        }
        println "acts" + acts
        acts
    }


}
