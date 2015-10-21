package net.sf.bpm.implicit

import groovy.transform.ToString

@ToString(includeNames=true, ignoreNulls = false)
class DSLBehaviour {
    def connector
    def varName
    def element
    def controller
    def byVar
}
