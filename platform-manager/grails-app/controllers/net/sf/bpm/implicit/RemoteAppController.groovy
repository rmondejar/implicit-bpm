package net.sf.bpm.implicit

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RemoteAppController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond RemoteApp.list(params), model:[remoteAppInstanceCount: RemoteApp.count()]
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

        def app = remoteAppInstance.save(flush: true)


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', 
                        args: [message(code: 'remoteApp.label', default: 'RemoteApp'), 
                               remoteAppInstance.id])
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

    //MORE REST METHOD

    def sync() {

        println "SYNC $params"
        def r = RemoteApp.findByName(params.name)
        if (!r) {
            r = new RemoteApp(params)
            r = r.save(flush: true)
            if (!r) r = [:]
        }
        render r as JSON
    }
}
