package net.sf.bpm.implicit

class Application {
	
	String name
	String location
    boolean isWar
    String verNum
    String framework
	String metadata //JSON
	
	static mapping = {
		version false

	}

    static constraints = {
		
		name size: 3..100, blank: false, unique: true
        location url: "localhost(:(\\d{1,5}))?", blank: false
        verNum size: 1..15, blank: true, nullable: true
        framework size: 1..30, blank: true, nullable: true
        metadata size:1..3000, nullable: true, blank: true
    }
}
