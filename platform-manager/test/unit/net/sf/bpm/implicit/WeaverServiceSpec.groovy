/*package net.sf.bpm.implicit

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification


 See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions

@TestFor(WeaverService)
@Mock([Act,Behaviour,Weaver])
class WeaverServiceSpec extends Specification {

    def "prelude parsing variables"() {

        given:
        List parts = ["After", "\"Complete", "Purchase\"", "task"]

        when:
        Map result = service.parseVariable(parts,1)

        then:
        result.variable == "Complete Purchase"
        result.offset == 2

    }

    def "when weaver intercepts an action controller"() {

        given:
        def line = 'Instead of "process" action from Order, trigger "init" event;'

        when:
        def weaverInstance = service.parseWeaverEntry("petstore",line)
        weaverInstance.save flush: true

        then:
        weaverInstance != null
        weaverInstance.act != null
        weaverInstance.behaviours != null
        weaverInstance.behaviours.size() == 1
        weaverInstance.toString() == line

    }

    def "when weaver intercepts an task and render a view"() {

        given:
        def line = 'After "Save Purchase" task, render "success" view;'

        when:
        def weaverInstance = service.parseWeaverEntry("petstore",line)
        weaverInstance.save flush: true

        then:
        weaverInstance != null
        weaverInstance.act != null
        weaverInstance.behaviours != null
        weaverInstance.behaviours.size() == 1
        weaverInstance.toString() == line

    }

    def "when weaver intercepts an task and launch two behaviours"() {

        given:
        def line = 'Before "Book Balance" task, find "customer" domain by "nin" and sets in "exists" attribute;'

        when:
        def weaverInstance = service.parseWeaverEntry("accounting",line)
        weaverInstance.save flush: true

        then:
        weaverInstance != null
        weaverInstance.act != null
        weaverInstance.behaviours != null
        weaverInstance.behaviours.size() == 2
        weaverInstance.toString() == line

    }

    def "when weaver intercepts an task and executes an action controller"() {

        given:
        def line = 'After "Book Balance" task, perform "update" action from Book;'

        when:
        def weaverInstance = service.parseWeaverEntry("accounting",line)
        weaverInstance.save flush: true

        then:
        weaverInstance != null
        weaverInstance.act != null
        weaverInstance.behaviours != null
        weaverInstance.behaviours.size() == 1
        weaverInstance.toString() == line

    }

}
*/