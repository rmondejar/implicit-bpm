import net.sf.bpm.implicit.Application

class BootStrap {

    def weaverService

    def init = { servletContext ->

        def app = new Application(location: "http://localhost:8080/petstore", name: "petstore")
        app.save()

        def inputDSL = '''
            PurchaseWorkflow {
                on PetStore :
                 After "list" view from "Item", find "Item" element by "name" and set "exist" attribute and render "list" view from "Order";
                 And replace "create" view from "Item", start "newAction" action from "Order" and render "create" view from "Order";
                 And after "list" view from "Order", save "Item" element;
            }
        '''

        def weaver = weaverService.parseDSL(inputDSL)
       weaver.save(flush: true, failOnError: true)
       println weaver

    }
    def destroy = {
    }
}
