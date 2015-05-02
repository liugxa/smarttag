package com.platform.gui.framework.smart.inter.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.comparator.SortOrder;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnableFilter;
import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.util.Sorter;

public class DefaultDataRecordList<T> implements IDataRecordList<T> , IEnableFilter<T>{

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
		sort.sort(records, sortBy , sortOrder);
		List<T> rs = records.subList(startIndex , endIndex);
		return rs;
	}

	public List<T> getAllFilterRecords(FilterData filterData) throws Exception {
		List<T> list = new ArrayList<T>();
		
		List<DataItem> items = filterData.getItems();
		//find all of the request list which name is same with the condition's value
		for(T record:records){
			boolean isRight = true;
			for(DataItem item:items){
				String name = item.getName();
				String value = item.getValue();
				
				String beanValue = BeanUtils.getProperty(record, name);
				if(beanValue.indexOf(value) == -1){
					isRight = false;
					break;
				}
			}
			if(isRight) list.add(record);
		}
		return list;
	}

	public List<T> getAllFilterRecords(FilterData filterData, String sortBy,
			SortOrder sortOrder) throws Exception {
		List<T> list = this.getAllFilterRecords(filterData);
		sort.sort(list, sortBy , sortOrder);
		return list;
	}

	public Integer getFilterRecordSize(FilterData filterData) throws Exception {
		return this.getAllFilterRecords(filterData).size();
	}

	public List<T> getFilterRecords(FilterData filterData, Integer startIndex,
			Integer endIndex, String sortBy, SortOrder sortOrder)
			throws Exception {
		List<T> list = this.getAllFilterRecords(filterData, sortBy, sortOrder);
		return list.subList(startIndex , endIndex);
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
