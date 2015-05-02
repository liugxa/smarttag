package com.platform.gui.framework.smart.action;

import java.util.List;

import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.framework.smart.comparator.SortOrder;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;

public abstract class ListTableAction<T> extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	private SmartTableGridConfigure configure = new SmartTableGridConfigure();
	
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
		IDataRecordList<T> recordList = this.registRecordDataList();
		String recordName = this.registRecordDataName();
		if(recordList != null){
			this.getServletRequest().setAttribute("dataSize", recordList.getRecordSize());
			this.getServletRequest().setAttribute("configure", configure);
			
			// sub list
			Integer beginIndex = this.getBeginIndex(recordList);
			Integer endIndex = this.getEndIndex(recordList);
			List<T> data = recordList.getRecords(beginIndex , endIndex , this.getSortBy(), this.getSortOrder());
			
			// set the data into attribute
			this.getServletRequest().setAttribute(recordName, data);
		}
	}

	/**
	 * Get sort by value
	 * @return
	 */
	private String getSortBy(){
		return this.getParamterValue("sortBy"); 
	}
	
	/**
	 * Get sort order value
	 * @return
	 */
	private SortOrder getSortOrder(){
		SortOrder sortOrder = SortOrder.ASC;
		String so = this.getParamterValue("sortOrder"); 
		
		if(so != null && so.equals("desc")) sortOrder = SortOrder.DESC;
		return sortOrder;
	}
	
	/**
	 * Get the begin index point
	 * @return
	 */
	public Integer getBeginIndex(IDataRecordList<T> recordList) throws Exception{
		String page = this.getParamterValue("page");
		int dataSize = recordList.getRecordSize();
		
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
	public Integer getEndIndex(IDataRecordList<T> recordList) throws Exception{
		int dataSize = recordList.getRecordSize();
		Integer toIndex = this.getBeginIndex(recordList) + configure.getPageSize();
		return (toIndex >= dataSize)?dataSize:toIndex;
	}
	
	private String getParamterValue(String name){
		return this.getServletRequest().getParameter(name);
	}

	public SmartTableGridConfigure getConfigure() {
		return configure;
	}

	public void setConfigure(SmartTableGridConfigure configure) {
		this.configure = configure;
	}
}
