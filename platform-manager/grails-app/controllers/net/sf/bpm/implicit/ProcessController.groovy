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
class ProcessController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    WorkflowService workflowService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Process.list(params), model: [processInstanceCount: Process.count()]
    }

    def show(Process processInstance) {
        respond processInstance
    }

    def create() {
        respond new Process(params)
    }

    @Transactional
    def save(Process processInstance) {
        if (processInstance == null) {
            notFound()
            return
        }

        if (processInstance.hasErrors()) {
            respond processInstance.errors, view: 'create'
            return
        }

        processInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'process.label', default: 'Process'), processInstance.id])
                redirect processInstance
            }
            '*' { respond processInstance, [status: CREATED] }
        }
    }

    def edit(Process processInstance) {
        respond processInstance
    }

    @Transactional
    def update(Process processInstance) {
        if (processInstance == null) {
            notFound()
            return
        }

        if (processInstance.hasErrors()) {
            respond processInstance.errors, view: 'edit'
            return
        }

        processInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'process.label', default: 'Process'), processInstance.id])
                redirect processInstance
            }
            '*' { respond processInstance, [status: OK] }
        }
    }

    def deploy(Process processInstance) {
        respond processInstance
    }

    def upload(Process processInstance) {

        if (processInstance == null) {
            notFound()
            return
        }

        def f = request.getFile('bpmn20.xml')

        if (!f?:f.empty) {
            request.withFormat {
                form multipartForm {
                    flash.message = 'BPMN XML file cannot be empty'
                    redirect processInstance
                }
                '*' { render status: NOT_FOUND }
            }
            return
        }
        print f.originalFilename
        print f.name
        print f.size
        print f.contentType
        print f.getClass()
        //String fileContent = f.getInputStream().getText()
        def fileStream = f.getInputStream()

        def deployResult = workflowService.deployProcess(fileStream, f.originalFilename)
        println deployResult
        if (!deployResult.object) {
            request.withFormat {
                form multipartForm {
                    flash.message = 'Invalid BPMN XML file'
                    redirect processInstance
                }
                '*' { render status: NOT_FOUND }
            }
            return
        }

        processInstance.name = deployResult.name
        processInstance.deployTime = deployResult.object.deploymentTime
        processInstance.version = deployResult.version
        processInstance.revision = deployResult.revision
        processInstance.deployed = true
        processInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'process.label', default: 'Process'), processInstance.id])
                redirect processInstance
            }
            '*' { respond processInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Process processInstance) {

        if (processInstance == null) {
            notFound()
            return
        }

        processInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'process.label', default: 'Process'), processInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'process.label', default: 'Process'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }


}
