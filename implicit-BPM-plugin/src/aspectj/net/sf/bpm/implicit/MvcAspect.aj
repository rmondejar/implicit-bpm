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
	        intercept("BEFORE CONTROLLER ACTION", thisJoinPoint);
	        Object res = proceed();
            intercept("AFTER CONTROLLER ACTION", thisJoinPoint);
	        return res;
	    }
	    
	    Object around() : readMethod() {
            intercept("BEFORE READ METHOD", thisJoinPoint);
	        Object res = proceed();
            intercept("AFTER READ METHOD", thisJoinPoint);
	        return res;
	    }
	    
	    before() : saveMethod() {
            intercept("BEFORE SAVE METHOD", thisJoinPoint);
	    }
	    
	    after() : saveMethod() {
            intercept("AFTER SAVE METHOD", thisJoinPoint);
	    }
	    
	/////////

    protected void intercept(String desc, JoinPoint joinPoint) {
        setDescription(desc);
        def listener = ImplicitBpmListener.createInstance()
        listener.onEvent(this, joinPoint)
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

    public String toString() {
    	return getName()+" "+getDescription();
    }

}
