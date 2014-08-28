package net.sf.bpm.implicit

class Weaver {

    String line
    static hasOne = [act:Act]
    static hasMany = [behaviours:Behaviour]

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
