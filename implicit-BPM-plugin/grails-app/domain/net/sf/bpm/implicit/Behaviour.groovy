package net.sf.bpm.implicit

class Behaviour {

    //behaviour = connector variable element [from controller ] [by variable ]
    String connector
    String variable
    String element
    String fromController
    String byVariable

    static belongsTo = [weaver:Weaver]

    static mapping = {
        table 'IBPM_BEHAVIOUR_ENTRY'
        version false
    }

    static constraints = {
        connector inList : ['perform', 'find', 'save', 'render', 'trigger', 'start', 'sets in']
        variable size: 3..30, blank: false, nullable:false
        element inList: ['action', 'view', 'event', 'task', 'attribute', 'flow']
        fromController size: 3..30, blank: true, nullable:true
        byVariable size: 3..30, blank: true, nullable:true
    }
}
