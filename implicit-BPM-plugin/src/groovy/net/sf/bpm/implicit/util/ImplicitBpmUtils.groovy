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

import grails.util.Environment

class ImplicitBpmUtils {

	private static ConfigObject implicitBpmConfig

	public static synchronized ConfigObject getImplicitBpmConfig() {
		if (implicitBpmConfig== null) {
			loadImplicitBpmConfig()
		}
		implicitBpmConfig
	}

	public static void loadImplicitBpmConfig() {
		implicitBpmConfig = mergeConfig("DefaultImplicitBpmConfig", "ImplicitBpmConfig")
	}


    public static ConfigObject mergeConfig(String defaultConfigClassName, String appConfigClassName) {
		mergeConfig(loadConfig(defaultConfigClassName), loadConfig(appConfigClassName, true))
	}

	public static ConfigObject mergeConfig(ConfigObject currentConfig, ConfigObject overridenConfig) {
		ConfigObject config = new ConfigObject();
		if (overridenConfig == null) {
			config.putAll(currentConfig);
		} else {
			config.putAll(currentConfig.merge(overridenConfig));
		}
		config
	}

	public static ConfigObject loadConfig(String configClassName, boolean optional = false) {
		ConfigObject config
		GroovyClassLoader classLoader = new GroovyClassLoader(ImplicitBpmUtils.class.getClassLoader())
		ConfigSlurper slurper = new ConfigSlurper(Environment.getCurrent().getName())
		try {
			config = slurper.parse(classLoader.loadClass(configClassName))
		} catch (ClassNotFoundException e) {
			if (optional) config = [:]
			else throw new RuntimeException(e);
		}
		config
	}

}