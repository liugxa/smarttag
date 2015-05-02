package com.platform.gui.framework.tags.inter;

import java.util.List;

public interface IEnableFilter<T> {
	/**
	 * Filter the data
	 * @param filterData
	 * @return
	 * @throws Exception
	 */
	public List<T> filterRecords(FilterData filterData) throws Exception;
}
