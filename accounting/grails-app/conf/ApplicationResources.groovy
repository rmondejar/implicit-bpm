modules = {
	bootstrap {
		dependsOn: "jquery"
		resource url:'js/bootstrap.min.js'
		resource url:'css/bootstrap.min.css'
		resource url:'css/bootstrap-responsive.min.css'
	}
	application {
		dependsOn: "bootstrap"
		resource url:'js/application.js'
	}
}