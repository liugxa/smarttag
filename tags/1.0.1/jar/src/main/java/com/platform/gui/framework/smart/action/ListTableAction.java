package com.platform.gui.framework.smart.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.framework.smart.comparator.SortOrder;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;

public abstract class ListTableAction<T> extends AbstractAction{

	private static final long serialVersionUID = 1L;

	private String sortBy;
	
	private String sortOrder;

	private String page;
	
	private FilterData filterData;
	
	/**
	 * Every action which extends the ListTableAction should invoke this method!
	 * @param dataName
	 * @param data
	 */
	public abstract String registRecordDataName() throws Exception;
	
	public abstract IDataRecordList<T> registRecordDataList() throws Exception;
	
	
	/**
	 * Get the list data and sub/sort it.
	 */
	@BeforeResult
	public void sortData() throws Exception{
		HttpServletRequest request = this.getServletRequest();
		Integer dataSize = 0;
		
		IDataRecordList<T> recordList = this.registRecordDataList();
		String recordName = this.registRecordDataName();
		
		if(recordList != null){
			List<T> data = new ArrayList<T>();
			PreferenceConfigure configure = this.getConfigure();
			
			SortOrder order = SortOrder.ASC;
			if(sortOrder != null && sortOrder.equals(SortOrder.DESC.getName())) order = SortOrder.DESC;
			
			if(this.filterData != null){
				// sub list
				dataSize = recordList.getFilterRecordSize(filterData);
				Integer beginIndex = this.getBeginIndex(dataSize , configure);
				Integer endIndex = this.getEndIndex(dataSize , configure);				
				data = recordList.getFilterRecords(filterData , beginIndex , endIndex , this.getSortBy(), order);
				this.getSession().setAttribute("filterData", filterData);
			}else{
				if(this.getSession().getAttribute("filterData") != null){
					// sub list
					FilterData fd = (FilterData)this.getSession().getAttribute("filterData");
					dataSize = recordList.getFilterRecordSize(fd);
					Integer beginIndex = this.getBeginIndex(dataSize , configure);
					Integer endIndex = this.getEndIndex(dataSize , configure);				
					data = recordList.getFilterRecords(fd , beginIndex , endIndex , this.getSortBy(), order);
				}else{
					dataSize = recordList.getAllRecordSize();
					Integer beginIndex = this.getBeginIndex(dataSize , configure);
					Integer endIndex = this.getEndIndex(dataSize , configure);	
					data = recordList.getRecords(beginIndex , endIndex , this.getSortBy(), order);
				}
			}
			
			// set the data into attribute
			request.setAttribute(recordName, data);
			request.setAttribute("dataSize", dataSize);
			request.setAttribute("configure", configure);
		}
	}

	private PreferenceConfigure getConfigure() throws Exception{
		return new SmartTableGridConfigure();
	}
	/**
	 * Get the begin index point
	 * @return
	 */
	public Integer getBeginIndex(Integer dataSize , PreferenceConfigure configure) throws Exception{
		Integer pageIndex = (page != null)?Integer.parseInt(page):0;
		Integer beginIndex = pageIndex * configure.getPageSize();
		
		if(pageIndex <= 0) return 0;
		if(beginIndex >= dataSize) return dataSize;
		return beginIndex;
	}
	
	/**
	 * Get the end index point
	 * @return
	 */
	public Integer getEndIndex(Integer dataSize , PreferenceConfigure configure) throws Exception{
		Integer toIndex = this.getBeginIndex(dataSize , configure) + configure.getPageSize();
		return (toIndex >= dataSize)?dataSize:toIndex;
	}

	public FilterData getFilterData() {
		return filterData;
	}

	public void setFilterData(FilterData filterData) {
		this.filterData = filterData;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
}
