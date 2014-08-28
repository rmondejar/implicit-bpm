package net.sf.bpm.implicit

class MainController {

    def index() {

        def procs = Process.list()
        def np = Process.count()

        def apps = Application.list()
        int na = Application.count()

        [processInstanceList: procs, processInstanceCount: np,
         applicationInstanceList: apps, applicationInstanceCount: na]
	}

}
