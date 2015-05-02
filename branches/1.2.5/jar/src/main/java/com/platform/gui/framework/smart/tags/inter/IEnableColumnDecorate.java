package com.platform.gui.framework.smart.tags.inter;

import com.platform.gui.framework.smart.inter.*;


public interface IEnableColumnDecorate {

	/**
	 * Get the column decorate object
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public IColumnDecorate getColumnDecorate(String columnName) throws Exception;
}
