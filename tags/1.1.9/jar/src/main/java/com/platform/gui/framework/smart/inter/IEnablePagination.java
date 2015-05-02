package com.platform.gui.framework.smart.inter;

import java.util.List;

import com.platform.gui.framework.smart.comparator.SortOrder;

public interface IEnablePagination<T> {
	
	/**
	 * Get the record size
	 * @return
	 * @throws Exception
	 */
	public Integer getAllRecordSize() throws Exception;
	
	/**
	 * Get all of the records
	 * @return
	 * @throws Exception
	 */
	public List<T> getAllRecords() throws Exception;
	
	/**
	 * Get all of the records and sort it
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
