package com.platform.gui.framework.tags.inter;

import java.util.List;

import com.platform.gui.framework.comparator.SortOrder;
import com.platform.gui.framework.util.Sorter;

public class DefaultDataRecordList<T> implements IDataRecordList<T>{

	private static final long serialVersionUID = 1L;
	
	private Sorter<T> sort = new Sorter<T>();
	
	private List<T> records;

	/**
	 * Default Constructed Function
	 */
	public DefaultDataRecordList(){}

	
	/**
	 * Constructed Function
	 * @param records
	 */
	public DefaultDataRecordList(List<T> records){
		this.records = records;
	}
	
	/**
	 * Get record size
	 */
	public Integer getRecordSize() throws Exception{
		return records.size();
	}
	
	/**
	 * Filter data
	 * TODO:
	 */
	public List<T> filterRecords(FilterData filterData) throws Exception{
		return records;
	}
	
	/**
	 * Get all of the records
	 */
	public List<T> getAllRecords(String sortBy , SortOrder sortOrder) throws Exception{
		sort.sort(records, sortBy , sortOrder);
		return records;
	}

	/**
	 * Get the records one of page
	 */
	public List<T> getRecords(Integer fromIndex, Integer toIndex ,String sortBy , SortOrder sortOrder) throws Exception{
		List<T> subList = records.subList(fromIndex, toIndex);
		sort.sort(subList, sortBy, sortOrder);
		return subList;
	}

	public Sorter<T> getSort() {
		return sort;
	}

	public void setSort(Sorter<T> sort) {
		this.sort = sort;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
}
