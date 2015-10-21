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

import org.apache.commons.logging.LogFactory
import org.aspectj.lang.reflect.MethodSignature
import org.codehaus.groovy.grails.web.util.WebUtils

import javax.servlet.http.HttpServletResponse

class ProxyService {

    def grailsApplication
    ReflectionService reflectionService

    def packageName
    def actualMethod
    def actualController

    WeaverHelper weaverHelper

    static final connectorsForElements = [
                                            "action"   : ["perform", "trigger", "start"],
                                            "view"     : ["render"],
                                            "attribute": ["sets in", "sets", "set"],
                                            "element"  : ["find", "save"],
                                            "event"    : ["trigger", "start"],
                                            "task"     : ["trigger", "start"]

    ]

    def attributes = [:]
    def isReturned

    static final SLASH = "/"
    static final log = LogFactory.getLog(this)

    def invoke(aspect, joinPoint) {
        //aspect -> when, controller
        println "Proxy invoke " + aspect + " -> " + joinPoint;

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        actualMethod = signature.method.name
        String className = joinPoint.getTarget().getClass().getName();
        String actualClass = joinPoint.getTarget().getClass().getName();
        packageName = actualClass.substring(0, actualClass.lastIndexOf("."))

        String[] actualControllerNameArray = actualClass.split("\\.")
        actualController = actualControllerNameArray?.getAt(-1).substring(0, actualControllerNameArray[-1].lastIndexOf("Controller")).toLowerCase()

        weaverHelper = WeaverHelper.createInstance()

        def actsForJoinPoint = weaverHelper.getActsForJointPointFromAll(weaverHelper.getWhenActions(actualMethod, actualController, aspect.getDescription()),
                actualMethod, actualController)

        println "actsForJoinPoint: $actsForJoinPoint"


        actsForJoinPoint.each { a ->
            isReturned = false
            a.behaviours.each { b ->
                assert b.connector in ProxyService.connectorsForElements[b.element]
                b.fromController = weaverHelper.controllerInfo.containsKey(b.fromController) ? b.fromController : actualController
                this."$b.element"(b)
                if (b.connector in ProxyService.connectorsForElements["view"]) {
                    return
                }
            }
        }
    }

    def action(behaviour) {
        def ctx = grailsApplication.mainContext
        def controllerObject = (GroovyObject) ctx.getBean(packageName + "." +
                behaviour.fromController.capitalize() + "Controller"); //controller.getFullName()
        //if (controllerObject.metaClass.respondsTo(controllerObject, behaviour.variable)){

        if (behaviour.fromController == actualController && behaviour.variable == actualMethod)
            return
        if (behaviour.variable in weaverHelper.controllerInfo[behaviour.fromController]) {
            controllerObject."$behaviour.variable"()
            return
        }
        log.error("Controller doesn't have the specified action. \nController: ${behaviour.fromController}\nAction: ${behaviour.variable} ")
    }

    def view(behaviour) {
        if (behaviour.act.when == "replace")
            return
        def controller = behaviour.fromController
        def view = behaviour.variable
        HttpServletResponse response = WebUtils.retrieveGrailsWebRequest().getCurrentResponse()
        //RequestContextHolder.currentRequestAttributes().response
        //HttpServletRequest currentReq = webUtils.getCurrentRequest()
        def webUtils = WebUtils.retrieveGrailsWebRequest()

        def actualControllerName = webUtils.controllerName.toLowerCase()
        webUtils.controllerName = controller
        // webUtils.actionName = behaviour.element

        def redirectPath
        if (actualControllerName == controller) {
            if (view == actualMethod) {
                return
            }
            redirectPath = view
        } else {
            redirectPath = ".." + ProxyService.SLASH + controller + ProxyService.SLASH + view
        }

        if (view in weaverHelper.viewInfo[behaviour.fromController]) {
            response.sendRedirect(redirectPath)
            return
        }
        log.error("No such view in controller. \nController: ${behaviour.fromController}\nAction: ${view} ")

    }

    def element(behaviour) {

        attributes["name"] = "Gold Fish" // for initialization
        weaverHelper = WeaverHelper.createInstance()
        def domainClass = grailsApplication.classLoader.loadClass(weaverHelper.modelInfo[behaviour.variable]?.name)
        def element
        if(behaviour.connector == "find"){
            def findBy = "findBy" + behaviour.byVariable?.capitalize()
            element = domainClass."$findBy"(attributes[behaviour.byVariable] ?: "")
            println "element found: $element"
            isReturned = true
        } else { // "save"
            element = domainClass.newInstance()
            element.save()
            println "element saved: $element"
        }

        element

    }

    def attribute(behaviour){
        attributes["exist"] = false // for initialization
        if(isReturned){
            attributes[behaviour.variable] = true;
            println "is Returned: $isReturned"
        }
    }

    def event(Behaviour behaviour){
        //TODO
    }

    def task(Behaviour behaviour){
        //TODO
    }

    def flow(Behaviour behaviour){
        //TODO
    }

//    def methodMissing(String name, args){
//        println "method is missing: $name, $args"
//    }

}