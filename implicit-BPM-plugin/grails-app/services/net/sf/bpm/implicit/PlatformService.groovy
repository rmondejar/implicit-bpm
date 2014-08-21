package net.sf.bpm.implicit


import net.sf.bpm.implicit.util.ImplicitBpmUtils
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.PATCH
import static groovyx.net.http.ContentType.JSON

class PlatformService {

    def reflectionService

    def sync() {

        def conf = ImplicitBpmUtils.implicitBpmConfig
        def syncUrl = conf.implicitBpm.platform.rest.sync.url

        def info = reflectionService.appInstanceData
        println "Connecting to $syncUrl \nInfo: $info"

        def http = new HTTPBuilder(syncUrl)

        http.request(PATCH,JSON) { req ->
            uri.query = info
            response.success = { resp, json ->
                return json
            }
        }
    }




}
