package net.sf.bpm.implicit


import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ActController {

    def show(Act actInstance) {
        respond actInstance
    }

}
