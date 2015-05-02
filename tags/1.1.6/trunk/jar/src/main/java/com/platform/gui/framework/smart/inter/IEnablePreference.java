package com.platform.gui.framework.smart.inter;

import com.platform.gui.framework.smart.model.PreferenceConfigure;

public interface IEnablePreference {

	/**
	 * Get preference object from the data file
	 * @return
	 * @throws Exception
	 */
	public PreferenceConfigure getPreferenceConfigure() throws Exception;
	
	/**
	 * Save the preference into the data file
	 * @return
	 * @throws Exception
	 */
	public PreferenceConfigure savePreferenceConfigure() throws Exception;
}
