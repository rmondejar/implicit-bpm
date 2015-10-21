import org.apache.log4j.ConsoleAppender
import org.apache.log4j.PatternLayout

/*log4j = {
	error 'org.codehaus.groovy.grails',
	      'org.springframework',
	      'org.hibernate',
	      'net.sf.ehcache.hibernate'
}
*/

log4j = {

    PatternLayout patternLayout = new PatternLayout("%d [%t] %-5p %c %x - %m%n")

    appenders {
        appender new ConsoleAppender(name: "console",
                threshold: org.apache.log4j.Level.DEBUG,
                layout: patternLayout
        )
        appender new org.apache.log4j.ConsoleAppender(name: "errors",
                threshold: org.apache.log4j.Level.ERROR,
                layout: patternLayout
        )
    }

    debug console:  ['grails.app.controllers',
            'grails.app.controller',
            'grails.app.domain',
            'grails.app.services',
            'grails.app.filters',
            //'net.sf.bpm.implicit'
//            'org.springframework.security'
//            'org.hibernate.SQL'
            ]
            additivity = false

    error errors: ['org.codehaus.groovy.grails.web.servlet',  // controllers
            'org.codehaus.groovy.grails.web.pages',          // GSP
            'org.codehaus.groovy.grails.web.sitemesh',       // layouts
            'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
            'org.codehaus.groovy.grails.web.mapping',        // URL mapping
            'org.codehaus.groovy.grails.commons',            // core / classloading

            'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
            'org.springframework',
            'org.hibernate',
            'net.sf.ehcache.hibernate']
            additivity = false


    root {
        error 'errors'
    }
}

grails.views.default.codec="none" // none, html, base64
grails.views.gsp.encoding="UTF-8"
