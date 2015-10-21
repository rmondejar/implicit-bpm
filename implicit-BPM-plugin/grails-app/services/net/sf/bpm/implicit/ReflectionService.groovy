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

import grails.web.Action
import org.codehaus.groovy.grails.commons.DefaultGrailsControllerClass
import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass

import java.lang.reflect.Method

class ReflectionService {

    def grailsApplication
    def grailsLinkGenerator
    def groovyPageLocator

    def getAppInstanceData() {

        def data = [:]

        data.name = grailsApplication.metadata."app.name"
        data.location = grailsLinkGenerator.serverBaseURL + "/" + data.name
        data.isWar = grailsApplication.warDeployed
        data.verNum = grailsApplication.metadata."app.version"
        data.framework = "Grails "+grailsApplication.metadata."app.grails.version"

        data.metadata = [:]
        data.metadata.model = modelInfo
        data.metadata.controller = controllerInfo
        data.metadata.view = viewInfo

        data
    }

    def getModelClassNames(){
        def modelClassNames = [:]

        grailsApplication.domainClasses.each{ DefaultGrailsDomainClass domain ->

            Class domainClass = domain.clazz
            String logicalDomainName = domain.logicalPropertyName
            modelClassNames[logicalDomainName] = domainClass
        }

        modelClassNames
    }

    def getModelInfo() {

        def modelAttributesNames = [:]

        grailsApplication.domainClasses.each{ DefaultGrailsDomainClass domain ->

            Class domainClass = domain.clazz
            String logicalDomainName = domain.logicalPropertyName
            modelAttributesNames[logicalDomainName] = domain.properties*.name
        }

        modelAttributesNames
    }

    def getControllerInfo() {

        def controllerActionNames = [:]

        def bannedControllerNames = ["assets"]

        grailsApplication.controllerClasses.each { DefaultGrailsControllerClass controller ->

            Class controllerClass = controller.clazz

            String logicalControllerName = controller.logicalPropertyName
            if (!bannedControllerNames.contains(logicalControllerName)) {

                controllerClass.methods.each { Method method ->

                    if (method.getAnnotation(Action)) {
                        def actions = controllerActionNames[logicalControllerName] ?: []
                        actions << method.name
                        //println "controller: $logicalControllerName - ${method.name}"
                        controllerActionNames[logicalControllerName] = actions
                    }
                }

            }
        }
        controllerActionNames
    }

    def getViewInfo() {

        def viewPagesNames = [:]

        controllerInfo.each { c ->

            String name = c.key
            List actions = c.value

            viewPagesNames[name] = []
            actions.each { a ->
                String path = "/${name}/${a}"
                def view = groovyPageLocator.findViewByPath(path)
                if (view) {
                    //println "$path -> ${view.uri}"
                    viewPagesNames[name] += a
                }
            }
        }

       viewPagesNames
    }

}
