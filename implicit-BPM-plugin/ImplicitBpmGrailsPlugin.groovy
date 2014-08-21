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

import net.sf.bpm.implicit.ImplicitBpmListener
import net.sf.bpm.implicit.util.ImplicitBpmConfigFactory
import net.sf.bpm.implicit.util.ImplicitBpmUtils

class ImplicitBpmGrailsPlugin {

    def version = "0.4-SNAPSHOT"
    def grailsVersion = "2.2 > *"
    def author = 'Ruben Mondejar'
    def authorEmail = 'ruben.mondejar@urv.cat'
    def title = 'Grails Implicit BPM Plugin'
    def description = 'Implicit BPM Front-End Add-on'
    def documentation = 'http://grails.org/plugin/implicit-bpm'

    def license = 'LGPL'
    def organization = [ name: "URV", url: "http://www.urv.cat" ]
    def developers = [ [ name: "Ruben Mondejar" ]]
    def scm = [url: "https://implicit-bpm.sf.net"]
    def issueManagement = [
        system: "SourceForge", 
        url: "https://implicit-bpm.sf.net"
    ]

	def doWithSpring = {
		
		def conf = ImplicitBpmUtils.implicitBpmConfig
		//println "conf $conf"
		if (!conf || !conf.implicitBpm.global.enabled) {
			println '\n\nGrails Implicit BPM is disabled, not loading.\n\n'
			return
		}
		println 'Configuring Grails Implicit BPM...'		

		implicitBpmConfigFactory(ImplicitBpmConfigFactory) {
			implicitBpmConfig = conf
		}

		implicitBpmListener(ImplicitBpmListener) {
			configFactory = ref('implicitBpmConfigFactory')
		}

	}

}
