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

import grails.converters.JSON

class ProxyController {

    static allowedMethods = [ping: "GET", inject: "PUT", disable: "DELETE"]

    def weaverService
    def platformService
    def reflectionService

    def ping() {

        def resp = [:]
        resp = reflectionService.appInstanceData
        render resp as JSON
    }

    def inject() {

        Map resp = [:]

        println "INJECT $params"
        if (!params.weaver) {
            resp.error = "params"
            render resp as JSON
            return
        }

        Weaver weaver = weaverService.parseWeaverEntry(params.weaver)
        weaver.active = true

        if (!weaver.save(flush: true)) {
            resp.error = "onInject"
            println weaver.errors
        }
        resp.inject = "ok"
        println resp
        render resp as JSON
    }

    def disable() {

        Map resp = [:]

       println "DISABLE $params"
        if (!params.weaver) {
            resp.error = "params"
            render resp as JSON
            return
        }

        Weaver weaver = Weaver.findByLine(params.weaver)
        weaver.active = false

        if (!weaver.save(flush: true)) {
            resp.error = "onDisable"
            println weaver.errors
        }
        resp.disable = "ok"
        println resp
        render resp as JSON
    }

    def sync() {

        def resp = platformService.sync()

        render resp as JSON
    }
}
