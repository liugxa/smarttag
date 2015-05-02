package com.platform.gui.framework.smart.inter;

import java.util.List;

import com.platform.gui.framework.smart.model.FilterData;

public interface IEnableFilter<T> {
	/**
	 * Filter the data
	 * @param filterData
	 * @return
	 * @throws Exception
	 */
	public List<T> filterRecords(FilterData filterData) throws Exception;
}
