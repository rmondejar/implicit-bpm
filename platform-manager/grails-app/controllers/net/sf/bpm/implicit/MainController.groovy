package net.sf.bpm.implicit

import grails.converters.JSON
import org.codehaus.groovy.grails.commons.GrailsClass

class MainController {


    def index() {

        def units = DeployUnit.list()
        def numUnits = DeployUnit.count()

        def apps = RemoteApp.list()
        int numApps = RemoteApp.count()

        [deployUnitInstanceList: units, deployUnitInstanceCount: numUnits,
         remoteAppInstanceList: apps, remoteAppInstanceCount: numApps]
	}

}
