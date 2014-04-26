class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"remoteApp", action:"index")
        "/rest/sync"(controller:"remoteApp", action:"sync")
        "/rest/apps"(controller:"remoteApp", action:"index")
        "500"(view:'/error')
	}
}
