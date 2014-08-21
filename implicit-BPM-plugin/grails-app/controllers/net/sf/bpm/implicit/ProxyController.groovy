package net.sf.bpm.implicit

import grails.converters.JSON

class ProxyController {

    static allowedMethods = [ping: "GET", inject: "PUT", disable: "DELETE"]

    def platformService

    def ping() {

        Map resp = [:]
        resp.isAlive = true
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
//        if (!weaver.save(flush: true)) {
//            resp.error = "onAdd"
//            println weaver.errors
//        }
//        println resp
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
//        if (!weaver.save(flush: true)) {
//            resp.error = "onAdd"
//            println weaver.errors
//        }
//        println resp
        render resp as JSON
    }

    def sync() {

        platformService.sync()
    }
}
