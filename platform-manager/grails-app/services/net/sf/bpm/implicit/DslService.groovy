package net.sf.bpm.implicit

import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class DslService {

    def getApplications(String dsl, String weaverDsl) {

        def apps = []
        //TODO: IMPLEMENT
        apps
    }

    def getWeaverByApp(String dsl, String appName) {

        def weaver = ""
        //TODO: IMPLEMENT
        weaver
    }

    def getWeavers(String dsl) {
        def weavers = [:]
        //TODO: IMPLEMENT
        //EX -> [petstore:"...", accounting:"..."]
        weavers
    }
}
