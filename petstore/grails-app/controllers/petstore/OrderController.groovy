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
package petstore

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.servlet.ModelAndView

class OrderController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [orderInstanceList: Order.list(params), orderInstanceTotal: Order.count()]
    }

    def create() {
        [orderInstance: new Order(params)]
    }



    def save() {
        def orderInstance = new Order(params)
        if (!orderInstance.save(flush: true)) {
            render(view: "create", model: [orderInstance: orderInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'order.label', default: 'Order'), orderInstance.id])
        redirect(action: "show", id: orderInstance.id)
    }

    def show(Long id) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        [orderInstance: orderInstance]
    }

    def edit(Long id) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        [orderInstance: orderInstance]
    }

    def update(Long id, Long version) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        orderInstance.properties = params

        if (!orderInstance.save(flush: true)) {
            render(view: "edit", model: [orderInstance: orderInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'order.label', default: 'Order'), orderInstance.id])
        redirect(action: "show", id: orderInstance.id)
    }

    def process(Long id) {

        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        if (orderInstance.processed) {
            flash.message = message(code: 'default.current.done.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "show", id: orderInstance.id)
            return
        }

        orderInstance.properties = params
        orderInstance.processed = true

        if (!orderInstance.save(flush: true)) {
            redirect(action: "show", id: orderInstance.id)
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'order.label', default: 'Order'), orderInstance.id])
        redirect(action: "show", id: orderInstance.id)

    }

    def delete(Long id) {
        def orderInstance = Order.get(id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
            return
        }

        try {
            orderInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'order.label', default: 'Order'), id])
            redirect(action: "show", id: id)
        }
    }

    def newAction(){
        println "newAction - Order"
    }

}
