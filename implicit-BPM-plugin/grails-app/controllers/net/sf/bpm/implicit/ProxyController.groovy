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

  //      println "INJECT $params"
        if (!params.weaver) {
            resp.error = "params"
            render resp as JSON
            return
        }

        Weaver weaver = weaverService.createWeaver(params.weaver)
        if (!weaver.save(flush: true)) {
            resp.error = "onAdd"
            println weaver.errors
        }
        println resp
        render resp as JSON
    }

    def disable() {

        Map resp = [:]

//        println "DISABLE $params"
        if (!params.weaver) {
            resp.error = "params"
            render resp as JSON
            return
        }

        Weaver weaver = weaverService.getWeaver(params.weaver)

       if (!weaver.delete(flush: true)) {
            resp.error = "onDelete"
            println weaver.errors
        }
//        println resp
        render resp as JSON
    }

    def sync() {

        def resp = platformService.sync()

        render resp as JSON
    }
}
