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

import groovy.util.ConfigObject

class ImplicitBpmConfig {

	private ConfigObject config
	private ImplicitBpm proxy

	public ImplicitBpmConfig(ConfigObject config, ImplicitBpm proxy) {
		this.config = config
		this.proxy = proxy
	}

	public ConfigObject getConfig() {
		config
	}

	public ConfigObject getImplicitBpmConfig() {
		config.rules."${ImplicitBpm.name}"
	}

	public boolean isEnabled() {
		getConfigProperty('enabled')
	}

	public Object getConfigProperty(String propertyName) {
		config.implicitBpm.global."$propertyName"
	}

}