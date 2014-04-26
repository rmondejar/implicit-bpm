includeTargets << grailsScript("_GrailsEvents")

def implicitBpmConfig

target('weaveImplicitBpm': "Weave Implicit BPM aspects") {
	depends(configureImplicitBpm)
    if (isImplicitBpmEnabled()) {
        doWeaving()
    } else {
        event("StatusFinal", ["Weaving aspects...Disabled!"])
    }
}

/*
 * Avoid the weaving error caused when aspects are applied to already weaved classes.
 *
 * The root cause is eventCompileEnd event is fired more than once while running 
 * integration tests (GRAILS-9741).
 */
target('preCompileImplicitBpm': "Clean compiled classes to avoid double-weaving") {
	depends(configureImplicitBpm)
    if (isImplicitBpmEnabled()) {
        cleanImplicitBpm()
    }
}

target('doWeaving': "Compile-time weaving from aspect sources") {
    event("StatusUpdate", ["Weaving aspects..."])
    ant.taskdef(name: 'iajc', classname: 'org.aspectj.tools.ant.taskdefs.AjcTask')
    ant.path(id: "iajc.classpath", runtimeClasspath)
	// TODO: Use implicitBpmConfig options
    ant.iajc(classpathref: "iajc.classpath", 
			destdir: grailsSettings.classesDir, 
            source: '1.5', 
	        showWeaveInfo: true) {
    	inpath() {
    	    pathelement(path: grailsSettings.classesDir)
    	}
    	sourceRoots() {
    	    pathelement(path: "${implicitBpmPluginDir}/src/aspectj")
    	}
    }
    event("StatusFinal", ["Weaving aspects...OK!"])
}

target('configureImplicitBpm': 'Parse Implicit BPM configuration') {
	/*
    if ((isImplicitBpmEnabled()) && (!implicitBpmConfig)) {
		event('StatusFinal', ['Configuring Implicit BPM plugin...'])
		// TODO: Merge DefaultImplicitBpmConfig with custom ImplicitBpmConfig
		def configPath = "${grailsSettings.baseDir}/grails-app/conf/ImplicitBpmConfig.groovy"
		implicitBpmConfig = new ConfigSlurper().parse(new URL("file://${configPath}"))
    }
	*/
}

isImplicitBpmEnabled = {
	// TODO: Use implicitBpmConfig.enableImplicitBpmClosure
    !isPluginProject() && !isImplicitBpmDisabledByProperty()
}

isImplicitBpmDisabledByProperty = {
    Boolean.valueOf(System.getProperty('DISABLE_IMPLICIT_BPM', 'false'))
}

isPluginProject = {
	grailsSettings.isPluginProject()
}

cleanImplicitBpm = {
    event("StatusUpdate", ["Cleaning classes before Implicit BPM"])
    clean()
    ant.delete(failonerror: false, includeemptydirs: false) {
        fileset(dir: grailsSettings.projectTargetDir, includes: "**/*") 
    }
    event("StatusFinal", ["Cleaned up target dir before Implicit BPM"])
}