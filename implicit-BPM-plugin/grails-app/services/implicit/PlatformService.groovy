package implicit

import static groovyx.net.http.ContentType.JSON
import groovyx.net.http.HTTPBuilder
import net.sf.bpm.implicit.util.ImplicitBpmUtils

import static groovyx.net.http.Method.PATCH
import static groovyx.net.http.ContentType.TEXT
import org.codehaus.groovy.grails.web.mapping.LinkGenerator

class PlatformService {

    def grailsApplication
    LinkGenerator grailsLinkGenerator

    def sync() {

        String name = grailsApplication.metadata."app.name"
        String location = grailsLinkGenerator.serverBaseURL

        def conf = ImplicitBpmUtils.implicitBpmConfig
        def syncUrl = conf.implicitBpm.platform.rest.sync.url
        println "Connecting to $syncUrl"


        def http = new HTTPBuilder(syncUrl)

        http.request(PATCH,JSON) { req ->
            uri.query = [name:name,location:location]
            response.success = { resp, json ->
                return json
            }
        }
    }




}
