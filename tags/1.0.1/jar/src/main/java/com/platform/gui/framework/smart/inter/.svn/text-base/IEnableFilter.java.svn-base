package com.platform.gui.framework.smart.inter;

import java.util.List;

import com.platform.gui.framework.smart.comparator.SortOrder;
import com.platform.gui.framework.smart.model.FilterData;

public interface IEnableFilter<T> {
	
	/**
	 * Get the filter record size
	 * @return
	 * @throws Exception
	 */
	public Integer getFilterRecordSize(FilterData filterData) throws Exception;

	/**
	 * Filter the data
	 * @param filterData
	 * @return
	 * @throws Exception
	 */
	public List<T> getAllFilterRecords(FilterData filterData) throws Exception;
	
	/**
	 * Filter the data and sort it
	 * @param filterData
	 * @return
	 * @throws Exception
	 */
	public List<T> getAllFilterRecords(FilterData filterData , String sortBy , SortOrder sortOrder) throws Exception;
	
	/**
	 * Filter the data
	 * @param filterData
	 * @return
	 * @throws Exception
	 */
	public List<T> getFilterRecords(FilterData filterData , Integer startIndex , Integer endIndex , String sortBy , SortOrder sortOrder) throws Exception;
	
}
