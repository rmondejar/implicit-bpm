package net.sf.bpm.implicit

class Act {

    //act = when variable element [from controller ]
    String when
    String variable
    String element
    String fromController

    static belongsTo = [weaver:Weaver]

    static mapping = {
        table 'IBPM_ACT_ENTRY'
        version false
    }

    static constraints = {
        when isList: ['Before', 'Instead of', 'After']
        variable size: 3..30, blank: false, nullable:false
        element inList: ['action', 'view', 'event', 'task', 'attribute', 'flow']
        fromController size: 3..30, blank: true, nullable:true
    }
}
