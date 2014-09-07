grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.server.port.http=8090

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()
    }

    dependencies {
		// AspectJ dependencies
		build("org.aspectj:aspectjtools:1.7.4") {
			exclude 'org.aspectj:aspectjrt'
		}
		runtime("org.aspectj:aspectjrt:1.7.4")
        compile "commons-codec:commons-codec:1.6"
    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.3"
        runtime ":resources:1.1.6"
        build ":tomcat:$grailsVersion"
        compile ':cache:1.0.1'
		compile ':implicit-bpm:0.5-SNAPSHOT'
    }
}
