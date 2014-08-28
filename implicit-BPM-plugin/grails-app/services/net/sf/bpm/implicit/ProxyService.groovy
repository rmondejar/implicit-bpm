package net.sf.bpm.implicit

import grails.transaction.Transactional

@Transactional
class ProxyService {

    def hijacking(proxy,joinPoint) {
        println "Proxy "+proxy+" -> "+joinPoint
    }

}
