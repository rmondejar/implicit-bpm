package net.sf.bpm.implicit

import groovy.transform.ToString

@ToString(includeNames=true, ignoreNulls = false)
class DSLAct {

    def when
    def varName
    def element
    def controller
    def behaviour = []

}
