package com.platform.gui.framework.tags.inter;

import java.util.List;

import com.platform.gui.framework.comparator.SortOrder;

public interface IEnablePagination<T> {
	
	/**
	 * Get the record size
	 * @return
	 * @throws Exception
	 */
	public Integer getRecordSize() throws Exception;
	
	/**
	 * Get all of the records
	 * @return
	 * @throws Exception
	 */
	public List<T> getAllRecords(String sortBy , SortOrder sortOrder) throws Exception;
	
	/**
	 * Get the records from startIndex to endIndex
	 * @param startIndex
	 * @param endIndex
	 * @return
	 * @throws Exception
	 */
	public List<T> getRecords(Integer startIndex , Integer endIndex , String sortBy , SortOrder sortOrder) throws Exception;
}
