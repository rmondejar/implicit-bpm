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

class WeaverService {

    def reflectionService
    def interpreterService
    Weaver weaver

    def parseWeaverEntry(String dslInput) {
        println dslInput
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
        if(interpreterService == null)
            parseError("Weaver is null '$interpreterService'", interpreterService)
        weaver.inputDSL = dslInput
        weaver
    }
        /* def parseWeaverEntry(String line) {

            String appName = reflectionService.appInstanceData.name
            List weaverLine = line.split(',')

            String actLine = weaverLine.first()
            Act act = parseActEntry(actLine)

            String bhsLine = weaverLine.last()
            if (bhsLine.endsWith(';')) bhsLine = bhsLine[0..-2]
            List bhLines = bhsLine.split(" and ")
            List bhs = parseBehaviourEntries(bhLines)

            Weaver weaver = new Weaver(appName:appName)
            weaver.inputDSL = inp
            //weaver.line = line
            weaver.act = act
            //weaver.behaviours = bhs
            bhs.eachWithIndex { Behaviour bh, i ->
                bh.position = i
                weaver.addToBehaviours(bh)
            }

            weaver

        }

        def parseActEntry(actLine) {

            Act act = new Act()

            //act = when variable element [from controller ]
            List actParts = actLine.split(" ")
            int pos = 0

            //when
            if (actParts[pos] == "Instead") {
                pos++
                if (actParts[pos] != "of") parseError("Syntax error, expected keyword 'of' instead of '${actParts[pos]}' in position $pos", actLine)
                act.when = "Instead of"
            }
            else act.when = actParts[pos]
            pos++

            //variable
            if (actParts.size()<=pos) parseError("Syntax error, expected 'variable' value in position '$pos'", actLine)
            else {
                Map res = parseVariable(actParts,pos)
                act.variable = res.variable
                pos+= res.offset
            }

            //element
            if (actParts.size()<=pos) parseError("Syntax error, expected 'element' value in position '$pos'", actLine)
            else if (!actParts[pos] in Act.elementEnum) parseError("Syntax error, wrong element '${actParts[pos]}' in position '$pos': not in list ${Act.elementEnum}", actLine)
            else {
                act.element = actParts[pos]
                pos++
            }

            //fromController
            if (actParts.size()>(pos+1)) {
                if (actParts[pos] != "from") parseError("Syntax error, expected keyword 'from' instead of '${actParts[pos]}' in position '$pos'", actLine)
                act.fromController = actParts[pos+1]
                pos++
            }

            act

        }

        def parseBehaviourEntries(bhLines) {

            List bhs = []
            bhLines.each { bhLine ->

                Behaviour bh = new Behaviour()
                //behaviour = connector variable element [from controller ] [by variable ]
                List bhParts = bhLine.split(" ").grep{ it.size()>1 }
                int pos = 0

                //connector
                if (bhParts.size() <= pos) parseError("Syntax error, expected connector value in position '$pos'", bhParts)
                if (bhParts[pos] == "sets") {
                    pos++
                    if (bhParts[pos] != "in") parseError("Syntax error, expected keyword 'in' instead of '${bhParts[pos]}' in position $pos", bhLine)
                    bh.connector = "sets in"
                }
                else bh.connector = bhParts[pos]
                pos++

                //variable
                if (bhParts.size() <= pos) parseError("Syntax error, expected 'variable' value in position '$pos'", bhParts)
                else {
                    Map res = parseVariable(bhParts,pos)
                    bh.variable = res.variable
                    pos+= res.offset
                }

                //element
                if (bhParts.size() <= pos) parseError("Syntax error, expected 'element' value in position '$pos'", bhLine)
                else if (!bhParts[pos] in Act.elementEnum) parseError("Syntax error, wrong element '${bhParts[pos]}' in position '$pos': not in list ${Act.elementEnum}", bhLine)
                else {
                    bh.element = bhParts[pos]
                    pos++
                }

                //fromController
                if (bhParts.size() > (pos + 1) && bhParts[pos] == "from") {
                    bh.fromController = bhParts[pos + 1]
                    pos+= 2
                }

                //byVariable
                if (bhParts.size() > (pos + 1) && bhParts[pos] == "by") {
                    Map res = parseVariable(bhParts,pos+1)
                    bh.byVariable = res.variable
                }

                bhs << bh
            }
            bhs
        }

        def parseVariable(List parts, int pos) {

            String var = ""
            int offset = 0

            if (!parts[pos].startsWith('"')) parseError("Syntax error, expected variable starting with \" in position '$pos'", parts)

            while((pos+offset)<parts.size() && !parts[pos+offset].endsWith('"')) offset++

            if (parts.size()<=pos+offset) parseError("Syntax error, expected variable ending with \" in position '${pos+offset}'", parts)

            for(i in 0..offset) var+=parts[pos+i]+" "

            [variable: var[1..-3], offset:offset+1]
        }
*/
        def parseError(String msg, def line) {
            throw new Exception("$msg :\n $line")
        }


}
