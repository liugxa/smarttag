package com.platform.gui.framework.smart.inter.impl;

import java.util.List;

import com.platform.gui.framework.smart.comparator.SortOrder;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.util.Sorter;

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
	 * Get all of the records
	 */
	public List<T> getAllRecords(String sortBy , SortOrder sortOrder) throws Exception{
		sort.sort(records, sortBy , sortOrder);
		return records;
	}


	public Integer getAllRecordSize() throws Exception {
		return records.size();
	}


	public List<T> getAllRecords() throws Exception {
		return records;
	}


	public List<T> getRecords(Integer startIndex, Integer endIndex,String sortBy, SortOrder sortOrder) throws Exception {
		List<T> rs = records.subList(startIndex , endIndex);
		sort.sort(rs, sortBy , sortOrder);
		return rs;
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
