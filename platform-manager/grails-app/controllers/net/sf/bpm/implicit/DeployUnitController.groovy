package net.sf.bpm.implicit


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DeployUnitController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond DeployUnit.list(params), model: [deployUnitInstanceCount: DeployUnit.count()]
    }

    def show(DeployUnit deployUnitInstance) {
        respond deployUnitInstance
    }

    def create() {
        respond new DeployUnit(params)
    }

    @Transactional
    def save(DeployUnit deployUnitInstance) {
        if (deployUnitInstance == null) {
            notFound()
            return
        }

        if (deployUnitInstance.hasErrors()) {
            respond deployUnitInstance.errors, view: 'create'
            return
        }

        deployUnitInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'deployUnit.label', default: 'DeployUnit'), deployUnitInstance.id])
                redirect deployUnitInstance
            }
            '*' { respond deployUnitInstance, [status: CREATED] }
        }
    }

    def edit(DeployUnit deployUnitInstance) {
        respond deployUnitInstance
    }

    @Transactional
    def update(DeployUnit deployUnitInstance) {
        if (deployUnitInstance == null) {
            notFound()
            return
        }

        if (deployUnitInstance.hasErrors()) {
            respond deployUnitInstance.errors, view: 'edit'
            return
        }

        deployUnitInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'DeployUnit.label', default: 'DeployUnit'), deployUnitInstance.id])
                redirect deployUnitInstance
            }
            '*' { respond deployUnitInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(DeployUnit deployUnitInstance) {

        if (deployUnitInstance == null) {
            notFound()
            return
        }

        deployUnitInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'DeployUnit.label', default: 'DeployUnit'), deployUnitInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'deployUnit.label', default: 'DeployUnit'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
