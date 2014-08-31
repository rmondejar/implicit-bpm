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

import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class ProxyService {

    def ping(Application a) {

        String url = a.location + "/proxy/ping"
        RestBuilder rest = new RestBuilder()
        def resp = rest.get(url){
            contentType "application/x-www-form-urlencoded"
        }

        rest.json
    }

    def inject(Application a, Weaver w) {

        String url = a.location + "/proxy/inject?weaver=" + w.line
        RestBuilder rest = new RestBuilder()
        def resp = rest.put(url){
            contentType "application/x-www-form-urlencoded"
        }
        println "REST ${resp.dump()}"
        resp.json
    }

    def disable(Application a, Weaver w) {

        String url = a.location + "/proxy/disable?weaver=" + w.line
        RestBuilder rest = new RestBuilder()
        def resp = rest.delete(url){
            contentType "application/x-www-form-urlencoded"
        }
        resp.json
    }
}
