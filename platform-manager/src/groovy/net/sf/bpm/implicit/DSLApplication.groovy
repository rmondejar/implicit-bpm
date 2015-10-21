package net.sf.bpm.implicit

import groovy.transform.ToString

@ToString(includeNames=true, ignoreNulls = true)
class DSLApplication {
    def name
    def act = []
}
