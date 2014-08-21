package net.sf.bpm.implicit

class Weaver {

    String line
    static hasOne = [act:Act]
    static hasMany = [beviours:Behaviour]

    static mapping = {
        table 'IBPM_WEAVER_ENTRY'
        version false
    }

    static constraints = {
        line size: 10..150, blank: false, nullable:false
    }
}
