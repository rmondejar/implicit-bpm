/*****************************************************************************************
 * Implicit BPM : a Workflow Weaving Platform
 * Copyright (C) 2014 Ruben Mondejar
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *****************************************************************************************/
package net.sf.bpm.implicit

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON

@Transactional(readOnly = true)
class ApplicationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "POST"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Application.list(params), model:[applicationInstanceCount: Application.count()]
    }

    def list(Integer max) {
        redirect(action: "index", params: [max: max])
    }

    def show(Application applicationInstance) {
        respond applicationInstance
    }

    def create() {
        respond new Application(params)
    }

    @Transactional
    def save(Application applicationInstance) {
        if (applicationInstance == null) {
            notFound()
            return
        }

        if (applicationInstance.hasErrors()) {
            respond applicationInstance.errors, view:'create'
            return
        }

        applicationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'application.label', default: 'Application'), applicationInstance.id])
                redirect applicationInstance
            }
            '*' { respond applicationInstance, [status: CREATED] }
        }
    }

    def edit(Application applicationInstance) {
        respond applicationInstance
    }

    @Transactional
    def update(Application applicationInstance) {
        if (applicationInstance == null) {
            notFound()
            return
        }

        if (applicationInstance.hasErrors()) {
            respond applicationInstance.errors, view:'edit'
            return
        }

        applicationInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Application.label', default: 'Application'), applicationInstance.id])
                redirect applicationInstance
            }
            '*'{ respond applicationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Application applicationInstance) {

        if (applicationInstance == null) {
            notFound()
            return
        }

        applicationInstance.delete flush:true

        /*request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'application.label', default: 'application'), applicationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
        */

        redirect action: "index"
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'application.label', default: 'application'), params.id])
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

        Application app = Application.findByName(params.name)
        if (!app) {
            app = new Application(params)
            resp.isNew = true
        }
        else {
            app.location = params.location
            app.isWar = params.isWar
            app.verNum = params.verNum
            app.framework = params.framework
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
