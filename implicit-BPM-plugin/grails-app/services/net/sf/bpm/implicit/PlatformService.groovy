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

import net.sf.bpm.implicit.util.ImplicitBpmUtils
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.PATCH
import static groovyx.net.http.ContentType.JSON

class PlatformService {

    ReflectionService reflectionService

    def sync() {

        def conf = ImplicitBpmUtils.implicitBpmConfig
        def syncUrl = conf.implicitBpm.platform.rest.sync.url

        def info = reflectionService.appInstanceData
        println "Connecting to $syncUrl ..."

        def http = new HTTPBuilder(syncUrl)

        http.request(PATCH,JSON) { req ->
            uri.query = info
            response.success = { resp, json ->
                return json
            }
        }
    }




}
