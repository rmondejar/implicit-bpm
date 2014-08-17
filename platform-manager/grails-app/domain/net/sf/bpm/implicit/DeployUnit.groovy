package net.sf.bpm.implicit

class DeployUnit {

    String processName
    Date deploymentTime
    Integer version
    Integer revision
    String weaverDsl

    boolean deployed
    boolean running

    static constraints = {

        processName size: 3..100, blank: false, unique: true
        deploymentTime nullable: true, blank: true
        version nullable: true, blank: true
        revision nullable: true, blank: true
        weaverDsl size:1..2000, nullable: true, blank: true
    }
}
