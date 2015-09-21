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

import grails.gsp.PageRenderer
import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
import org.codehaus.groovy.grails.commons.GrailsDomainClass
import org.springframework.web.context.request.RequestContextHolder
import org.codehaus.groovy.grails.web.util.WebUtils

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

class ProxyService {

    ReflectionService reflectionService
    PageRenderer groovyPageRenderer



    def invoke(aspect,joinPoint) {
        //aspect -> when, controller

        println "Proxy invoke "+aspect+" -> "+joinPoint;

        List weavers = Weaver.actives.list()
        println "Proxy weavers : $weavers"

        def modelInfo = reflectionService.modelClassNames
        modelInfo.each{k, Class v->
            println k
            println v
            /*def newDomainObject = v.newInstance()
            println newDomainObject*/
        }

        weavers.each { Weaver weaver ->
            //println weaver
            weaver.behaviours.each {
                //println it
                if(it.connector == "render"){
                    reflectionService.viewInfo.each { k, v ->
                        v.each{ viewName ->
                            if (viewName == it.variable){

                                /*String html = groovyPageRenderer.render(view: viewName, model: k)
                                HttpServletResponse response = WebUtils.retrieveGrailsWebRequest().getCurrentResponse()
                                response.setStatus(200)
                                response.setContentType('text/html')
                                response.writer.write(html)
                                response.sendRedirect(html)*/


                            }
                        }
                    }
                }
            }
        }


    }

    def actionAct() {

    }

    def taskAct() {

    }


}
