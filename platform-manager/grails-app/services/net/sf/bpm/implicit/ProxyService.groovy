package net.sf.bpm.implicit

import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class ProxyService {

    def ping(RemoteApp remoteApp) {
        RestBuilder rest = new RestBuilder()
        def resp = rest.get(remoteApp.location + "/proxy/ping"){
            contentType "application/json"
        }
        rest.json
    }

    def inject(RemoteApp remoteApp, String weaverJson) {
        RestBuilder rest = new RestBuilder()
        def resp = rest.put(remoteApp.location + "/proxy/inject"){
            contentType "application/json"
            json { weaverJson }
        }
        resp.json
    }

    def disable(RemoteApp remoteApp, String weaverJson) {
        RestBuilder rest = new RestBuilder()
        def resp = rest.delete(remoteApp.location + "/proxy/disable"){
            contentType "application/json"
            json { weaverJson }
        }
        resp.json
    }
}