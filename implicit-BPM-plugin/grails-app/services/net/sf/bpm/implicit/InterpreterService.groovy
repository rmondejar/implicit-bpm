package net.sf.bpm.implicit

import groovy.transform.ToString

@ToString(includeNames=true, ignoreNulls = true)
class InterpreterService {

    Workflow workflow
    List<DSLApplication> appList = [];
    def whenList =  DSLWhenEnum.values().collectEntries{[(it.name()) : it]}

    def firstRow = true

    def on(Map m) {
        m.entrySet().each {
            firstRow = false
            appList << new DSLApplication(name: it.key)
            this.defineWhen(it.value.toString())
        }
        return this
    }

    /* from Order, trigger */
    def from(theFrom, theConnector){
        def newBehave = new DSLBehaviour(connector: theConnector)
        appList[-1].act[-1].behaviour << newBehave
        //from(theFrom)
        appList[-1].act[-1].controller = theFrom
        this

    }

    /* in Behaviour the from clause */
    def from(theFrom){
        appList[-1].act[-1].behaviour[-1].controller = theFrom
        this
    }

    /* in Behavior the by clause */
    def by(theBy){
        appList[-1].act[-1].behaviour[-1].byVar = theBy
        this
    }

    /* adding another behaviour */
    def and(connector){
        def newBehave = new DSLBehaviour(connector: connector)
        appList[-1].act[-1].behaviour << newBehave
        this
    }

    def defineWhen(theWhen){
        def newAct = new DSLAct(when : theWhen)
        appList[-1].act << newAct
        this
    }

    /* Accessing the whens */
    def propertyMissing(String name){
        /* the first row of an Application has to be handled differently */
        if ( whenList.containsKey(name)) {
            return name
        }
        return this
    }


    def methodMissing(String name, args){
        if(args.length == 0 && whenList.containsKey(name)){
            defineWhen(name)
        }

        if ( name == DSLWhenEnum.Instead.toString() ){
            defineWhen(DSLWhenEnum.Instead)
        }

        /* starting with the first line of DSL:
            PurchaseWorkflow {
                ..
             }
         */
        if (args.length == 1 && args[0] instanceof Closure){
            workflow = new Workflow(name: name)
            Closure c = args[0]
            c.delegate = this
            c.call()
            printClasses()
            assignValues()
        }

        /* the case when a String is followed by some DSL-keywords:
            "Save Purchase" task
         */
        else
        if (args.length >= 1){

            /* "Save Purchase" task from Order -> Save Purchase has only one arg */
            if ( DSLElementEnum.values().contains(args[0])){
                /* the first time we get a String, thus it has to be an Act */
                if( !appList[-1].act[-1].varName){
                    appList[-1].act[-1].varName = name
                    appList[-1].act[-1].element = DSLElementEnum.valueOf(args[0].toString())
                } /* otherwise it has been called before, thus it is a Behaviour */
                else {
                    appList[-1].act[-1].behaviour[-1].varName = name
                    appList[-1].act[-1].behaviour[-1].element = DSLElementEnum.valueOf(args[0].toString())
                }

            }

            /* "Save Purchase" task, render
             * - here we only store the render (connector) value as the task (element) has been stored before */

            if ( args.length == 2 && DSLConnectorEnum.values().contains(args[1])){
                def newBehave = new DSLBehaviour(connector: DSLConnectorEnum.valueOf(args[1].toString()))
                appList[-1].act[-1].behaviour << newBehave

            }

        }
        return this
    }

    def printClasses(){
        println workflow
        println ""
        appList.each {
            println "Application: ${it.name}"
            it.act.each {
                println it
            }
            println ""
        }
    }

    def assignValues(){
        for(def app : appList){
            def weaver = new Weaver()
            weaver.appName = app.name
            for(DSLAct newAct : app.act){
                Act act = new Act()
                act.when = newAct.when
                act.element = newAct.element
                act.fromController = newAct.controller
                act.variable = newAct.varName
                act.weaver = weaver
                for(DSLBehaviour behaviour : newAct.behaviour){
                    Behaviour b = new Behaviour()
                    b.fromController = behaviour.controller
                    b.element = behaviour.element
                    b.byVariable = behaviour.byVar
                    b.connector = behaviour.connector
                    b.variable = behaviour.varName
                    b.weaver = weaver
                    weaver.addToBehaviours(b)
                }
                weaver.addToActs(act)
            }
            workflow.addToWeavers(weaver)


        }
    }

}
