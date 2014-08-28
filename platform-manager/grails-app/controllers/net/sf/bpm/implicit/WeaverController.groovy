package net.sf.bpm.implicit


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WeaverController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def weaverService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Weaver.list(params), model: [weaverInstanceCount: Weaver.count()]
    }

    def show(Weaver weaverInstance) {
        respond weaverInstance
    }

    def create() {
        respond new Weaver(params)
    }

    @Transactional
    def save(Weaver weaverInstance) {

        if (weaverInstance == null) {
            notFound()
            return
        }

        weaverInstance = weaverService.parseWeaverEntry(params.appName, params.line.trim())
        println weaverInstance.dump()

        if (weaverInstance.hasErrors()) {
            respond weaverInstance.errors, view: 'create'
            return
        }
        weaverInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'weaver.label', default: 'Weaver'), weaverInstance.id])
                redirect weaverInstance
            }
            '*' { respond weaverInstance, [status: CREATED] }
        }
    }

    def edit(Weaver weaverInstance) {
        respond weaverInstance
    }

    @Transactional
    def update(Weaver weaverInstance) {
        if (weaverInstance == null) {
            notFound()
            return
        }

        if (weaverInstance.hasErrors()) {
            respond weaverInstance.errors, view: 'edit'
            return
        }

        Weaver weaverData = weaverService.parseWeaverEntry(params.appName, params.line.trim())
        weaverInstance.properties = weaverData.properties
        weaverInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'weaver.label', default: 'Weaver'), weaverInstance.id])
                redirect weaverInstance
            }
            '*' { respond weaverInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Weaver weaverInstance) {

        if (weaverInstance == null) {
            notFound()
            return
        }

        weaverInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'weaver.label', default: 'Weaver'), weaverInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'weaver.label', default: 'Weaver'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
