import net.sf.bpm.implicit.Application

class BootStrap {

    def weaverService

    def init = { servletContext ->

        def app = new Application(location: "http://localhost:8080/petstore", name: "petstore")
        app.save()

        def inputDSL = '''
            PurchaseWorkflow {
                on PetStore :
                         After "Save Purchase" task, render "list" view;
                         Instead of "Process" action from "Order", trigger "init" event;
            }
        '''

        def weaver = weaverService.parseDSL(inputDSL)
        println weaver
        weaver.save(flush: true, failOnError: true)

    }
    def destroy = {
    }
}
