package net.sf.bpm.implicit

import groovy.transform.ToString

@ToString(includeNames=true, ignoreNulls = true)
class Workflow {

    def name
    static hasMany = [weavers:Weaver]

    static constraints = {
    }
}
