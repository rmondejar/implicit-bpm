import net.sf.bpm.implicit.util.ImplicitBpmUtils

class ImplicitBpmBootStrap {

    def platformService

    def init = { servletContext ->
        try {
            println "Synchronizing application against the platform manager..."
            platformService.sync()
            println "Application successful synchronized"
        } catch(e) {
            println "ERROR: platform manager is not available"
            //e.printStackTrace()
        }
    }
    def destroy = {
    }
}
