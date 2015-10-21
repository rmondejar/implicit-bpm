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
