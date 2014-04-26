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
package net.sf.bpm.implicit;

import org.aspectj.lang.JoinPoint;

public aspect MvcAspect extends MvcXpi implements ImplicitBpm {
	
//	  before() : controllerAction() {
//	        trigger("BEFORE CONTROLLER ACTION", thisJoinPoint);
//	    }
	    
//	    after() : controllerAction() {
//	    	
//	        trigger("AFTER CONTROLLER ACTION", thisJoinPoint);
//	    }
	    
	    Object around() : controllerAction() {
	        trigger("BEFORE CONTROLLER ACTION", thisJoinPoint);
	        Object res = proceed();
	        trigger("AFTER CONTROLLER ACTION", thisJoinPoint);	
	        return res;
	    }
	    
	    Object around() : readMethod() {
	        trigger("BEFORE READ METHOD", thisJoinPoint);
	        Object res = proceed();
	        trigger("AFTER READ METHOD", thisJoinPoint);	  
	        return res;
	    }
	    
	    before() : saveMethod() {
	        trigger("BEFORE SAVE METHOD", thisJoinPoint);
	    }
	    
	    after() : saveMethod() {
	        trigger("AFTER SAVE METHOD", thisJoinPoint);
	    }
	    
	/////////

	private String description;
	
    public String getName() {
        return getClass().getSimpleName();
    }
    
	public void setDescription(String description) {
		this.description = description;
	}
	
    public String getDescription() {
    	return description;
    }
    
    protected void trigger(String desc, JoinPoint joinPoint) {
    	setDescription(desc);
        ImplicitBpmListener.onEvent(this, joinPoint);
    }
    
    public String toString() {
    	return getName()+" "+getDescription();
    }

}
