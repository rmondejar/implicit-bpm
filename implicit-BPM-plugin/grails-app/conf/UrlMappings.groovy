class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')

//        "/rest/ping"(controller:'proxy', action: [GET: 'ping'])
//        "/rest/inject"(controller:'proxy', action: [PUT: 'inject'])
//        "/rest/disable"(controller:'proxy', action: [REMOVE: 'disable'])
	}
}
