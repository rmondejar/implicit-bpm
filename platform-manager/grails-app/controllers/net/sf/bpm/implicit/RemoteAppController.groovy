package net.sf.bpm.implicit

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

@Transactional(readOnly = true)
class RemoteAppController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RemoteApp.list(params), model:[remoteAppInstanceCount: RemoteApp.count()]
    }

    def list(Integer max) {
        redirect(action: "index", params: [max: max])
    }

    def show(RemoteApp remoteAppInstance) {
        respond remoteAppInstance
    }

    def create() {
        respond new RemoteApp(params)
    }

    @Transactional
    def save(RemoteApp remoteAppInstance) {
        if (remoteAppInstance == null) {
            notFound()
            return
        }

        if (remoteAppInstance.hasErrors()) {
            respond remoteAppInstance.errors, view:'create'
            return
        }

        remoteAppInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'remoteApp.label', default: 'RemoteApp'), remoteAppInstance.id])
                redirect remoteAppInstance
            }
            '*' { respond remoteAppInstance, [status: CREATED] }
        }
    }

    def edit(RemoteApp remoteAppInstance) {
        respond remoteAppInstance
    }

    @Transactional
    def update(RemoteApp remoteAppInstance) {
        if (remoteAppInstance == null) {
            notFound()
            return
        }

        if (remoteAppInstance.hasErrors()) {
            respond remoteAppInstance.errors, view:'edit'
            return
        }

        remoteAppInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'RemoteApp.label', default: 'RemoteApp'), remoteAppInstance.id])
                redirect remoteAppInstance
            }
            '*'{ respond remoteAppInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(RemoteApp remoteAppInstance) {

        if (remoteAppInstance == null) {
            notFound()
            return
        }

        remoteAppInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'RemoteApp.label', default: 'RemoteApp'), remoteAppInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'remoteApp.label', default: 'RemoteApp'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    def sync() {

        println "SYNC $params"

        Map resp = [:]

        if (!params.name || !params.location) {
            resp.error = "params"
            render resp as JSON
            return
        }
        if (!params.metadata) params.metadata = "{}"

        RemoteApp app = RemoteApp.findByName(params.name)
        if (!app) {
            app = new RemoteApp(params)
            resp.isNew = true
        }
        else {
            app.location = params.location
            app.metadata = params.metadata
            resp.isUpdated = true
        }

        if (!app.save(flush: true)) {
            resp.error = "onSave"
            println app.errors
        }
        println resp
        render resp as JSON
    }

}
