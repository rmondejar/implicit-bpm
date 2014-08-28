package net.sf.bpm.implicit

class Weaver {

    String line
    boolean active

    static hasOne = [act:Act]
    static hasMany = [behaviours:Behaviour]

    static namedQueries = {
        actives {
            eq 'active', true
        }
    }

    String toString() {
        "$act, ${behaviours*.toString().join(" and ")};"
    }

    static mapping = {
        table 'IBPM_WEAVER_ENTRY'
        version false
    }

    static constraints = {
        line size: 10..150, blank: false, nullable:false
    }
}
