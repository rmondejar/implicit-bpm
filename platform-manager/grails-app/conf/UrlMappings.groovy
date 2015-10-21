class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:'main')
        "500"(view:'/error')

        "/rest/sync"(controller:'application', action: [PATCH: 'sync'])
	}
}
