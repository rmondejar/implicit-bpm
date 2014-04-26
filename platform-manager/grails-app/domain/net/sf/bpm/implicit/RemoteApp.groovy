package net.sf.bpm.implicit

class RemoteApp {
	
	String name
	String location
	String metadata //JSON
	
	static mapping = {
		version false

	}

    static constraints = {
		
		name size: 3..100, blank: false, unique: true
        location url: "localhost(:(\\d{1,5}))?", blank: false
        metadata size:1..2000, blank: false
    }
}
