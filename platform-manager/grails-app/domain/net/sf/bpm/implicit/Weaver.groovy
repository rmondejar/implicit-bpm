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

import groovy.transform.ToString

@ToString(includeNames=true, ignoreNulls = false)
class Weaver {

    String appName
    String inputDSL
    boolean active

    static hasMany = [acts: Act]

    static namedQueries = {
        actives {
            eq 'active', true
        }
    }

   /* List getSortedBehaviours() {
        behaviours?.sort {it.position}
    }*/

    /*tring toString() {
        "$act, ${behaviours*.toString().join(" and ")};"
    }*/

    static mapping = {
        table 'IBPM_WEAVER_ENTRY'
        version false
        acts lazy: false

    }

    static constraints = {

        /*appName size: 3..50, blank: false, nullable:false
        line size: 10..300, blank: false, nullable:false*/
        inputDSL size: 10..1000, blank: false
    }
}
