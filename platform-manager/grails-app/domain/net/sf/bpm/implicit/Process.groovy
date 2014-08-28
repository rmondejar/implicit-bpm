package net.sf.bpm.implicit

class Process {

    String name
    Date deployTime
    Integer version
    Integer revision

    boolean deployed
    boolean running

    static constraints = {

        name size: 3..100, blank: false, unique: true
        deployTime nullable: true, blank: true
        version nullable: true, blank: true
        revision nullable: true, blank: true
    }
}
