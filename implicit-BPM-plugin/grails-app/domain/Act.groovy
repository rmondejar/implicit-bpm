package net.sf.bpm.implicit

class Act {

    static def elementEnum = ['action', 'view', 'event', 'task', 'domain', 'attribute', 'flow']
    static def whenEnum = ['Before', 'Instead of', 'After']

    String appName
    //act = when variable element [from controller ]
    String when
    String variable
    String element
    String fromController

    static belongsTo = [weaver:Weaver]

    String toString() {
        "$when \"$variable\" $element${fromController?" from $fromController":''}"
    }

    static mapping = {
        table 'IBPM_ACT_ENTRY'
        version false
    }

    static constraints = {
        appName size: 3..50, blank: false, nullable:false
        when isList: whenEnum
        variable size: 3..30, blank: false, nullable:false
        element inList: elementEnum
        fromController size: 3..30, blank: true, nullable:true
    }
}
