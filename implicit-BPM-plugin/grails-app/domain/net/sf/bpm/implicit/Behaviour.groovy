/*****************************************************************************************
 * Implicit BPM : a Workflow Weaving Platform
 * Copyright (C) 2014 Ruben Mondejar
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *****************************************************************************************/
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
