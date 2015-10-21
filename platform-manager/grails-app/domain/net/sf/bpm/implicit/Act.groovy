/*****************************************************************************************
 * Implicit BPM : a Workflow Weaving Platform
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

import groovy.transform.ToString

@ToString(includeNames=true, ignoreNulls = false)
class Act {

    static def elementEnum = ['action', 'view', 'event', 'task', 'domain', 'attribute', 'flow', 'element']
    static def whenEnum = ['Before', 'Instead of', 'After', 'Replace']

    //act = when variable element [from controller ]
    String when
    String variable
    String element
    String fromController

    static belongsTo = [weaver:Weaver]
    static hasMany = [behaviours:Behaviour]

    String toString() {
        "$when \"$variable\" $element${fromController?" from $fromController":''}"
    }

    static mapping = {
        table 'IBPM_ACT_ENTRY'
        version false
    }

    static constraints = {
        when isList: whenEnum
        variable size: 3..30, blank: false, nullable:false
        element inList: elementEnum
        fromController size: 3..30, blank: true, nullable:true
        behaviours lazy: false
    }
}
