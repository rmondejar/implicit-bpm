package net.sf.bpm.implicit

class Behaviour {

    static def connectorEnum = ['perform', 'find', 'save', 'render', 'trigger', 'start', 'sets in']

    //behaviour = connector variable element [from controller ] [by variable ]
    int position
    String connector
    String variable
    String element
    String fromController
    String byVariable

    static belongsTo = [weaver:Weaver]

    String toString() {
        "$connector \"$variable\" $element${fromController?" from $fromController":''}${byVariable?" by \"$byVariable\"":''}"
    }

    static mapping = {
        table 'IBPM_BEHAVIOUR_ENTRY'
        version false
    }

    static constraints = {
        position blank: false, nullable:false
        connector inList : connectorEnum
        variable size: 3..30, blank: false, nullable:false
        element inList: Act.elementEnum
        fromController size: 3..30, blank: true, nullable:true
        byVariable size: 3..30, blank: true, nullable:true
    }
}
