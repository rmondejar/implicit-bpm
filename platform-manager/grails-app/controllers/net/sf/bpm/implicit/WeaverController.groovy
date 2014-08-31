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

@Transactional(readOnly = true)
class WeaverController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def weaverService
    def proxyService

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


        if (weaverInstance.hasErrors()) {
            respond weaverInstance.errors, view: 'create'
            return
        }
        weaverInstance.save flush: true
        println weaverInstance.dump()

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

    def activate(Weaver weaverInstance) {

        println "ACTIVATE ${weaverInstance.dump()}"
        Application app = Application.findByName(weaverInstance.appName)
        def resp = proxyService.inject(app, weaverInstance)
        println resp

        weaverInstance.active = true
        weaverInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'weaver.label', default: 'Weaver'), weaverInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { respond weaverInstance, [status: OK] }
        }

    }

    def disable(Weaver weaverInstance) {

        Application app = Application.findByName(weaverInstance.appName)
        def resp = proxyService.disable(app, weaverInstance)
        println resp

        weaverInstance.active = false
        weaverInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'weaver.label', default: 'Weaver'), weaverInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { respond weaverInstance, [status: OK] }
        }

    }
}
