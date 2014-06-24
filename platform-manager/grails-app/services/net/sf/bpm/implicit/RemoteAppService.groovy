package net.sf.bpm.implicit

import grails.converters.JSON
import grails.transaction.Transactional

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT


@Transactional
class RemoteAppService {

    def ping(RemoteApp remoteApp) {
        remoteCall(remoteApp,"ping")
    }

    def addWeaver(RemoteApp remoteApp, String weaverJson) {
        remoteCall(remoteApp,"addWeaver",[weaver:weaverJson])
    }

    def removeWeaver(RemoteApp remoteApp, String weaverJson) {
        remoteCall(remoteApp,"removeWeaver",[weaver:weaverJson])
    }

    private def synchronized remoteCall(RemoteApp remoteApp, String method, Map params = [:]) {
        def http = new HTTPBuilder( remoteApp.location + "\rest\$method")
        http.request(GET,TEXT) { req ->
            uri.query = params
            response.success = { resp, reader ->
                def jsn = reader.text
                return  JSON.parse(jsn)
            }
        }

    }
}
