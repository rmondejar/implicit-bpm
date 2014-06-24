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
package net.sf.bpm.implicit.util

import net.sf.bpm.implicit.ImplicitBpm;
import net.sf.bpm.implicit.ImplicitBpmConfig;
import groovy.util.ConfigObject

class ImplicitBpmConfigFactory {

	static ConfigObject implicitBpmConfig

	static ImplicitBpmConfig getConfig(ImplicitBpm proxy) {
	    new ImplicitBpmConfig(implicitBpmConfig, proxy)
	}

}