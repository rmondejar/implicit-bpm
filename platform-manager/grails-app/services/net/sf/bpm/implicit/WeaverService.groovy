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

import grails.transaction.Transactional

@Transactional
class WeaverService {

    def interpreterService
    Weaver weaver

    def parseDSL(String dslInput) {
        def binding = new Binding([
                dsl : interpreterService,
                //*   : When.values().collectEntries{[(it.name()) : it]},
                *   : DSLElementEnum.values().collectEntries{[(it.name()) : it]},
                *   : DSLConnectorEnum.values().collectEntries{[(it.name()) : it]},
                //*   : DSLControllerEnum.values().collectEntries{[(it.name()) : it]},
        ])

        def shell = new GroovyShell( binding )
        shell.evaluate("dsl." + dslInput)

        weaver = interpreterService.workflow?.weavers?.getAt(0)
        weaver.inputDSL = dslInput
        println weaver
        weaver
    }
}
