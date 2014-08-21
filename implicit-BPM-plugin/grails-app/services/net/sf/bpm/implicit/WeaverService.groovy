package net.sf.bpm.implicit

class WeaverService {

    def createWeaver(String line) {

        Weaver weaver = new Weaver(line:line)

        //create ACT


        //create BEHAVIOURS

        weaver
    }

    def getWeaver(String line) {

        Weaver.findByLine(line)
    }

}
