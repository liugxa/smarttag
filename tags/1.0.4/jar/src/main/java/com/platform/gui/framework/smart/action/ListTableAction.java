package com.platform.gui.framework.smart.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;
import com.platform.gui.framework.smart.util.SortOrderUtil;

public abstract class ListTableAction<T> extends AbstractAction{

	private static final long serialVersionUID = 1L;

	private String sortBy;
	
	private String sortOrder;

	private String page;
	
	private Boolean removeRecords;
	;
	private FilterData filterData;
	
	/**
	* Return the list date name. And it should be same with the name which be
	* Define in the JSP file. In the JSP, you has define the list name by use “pf:table”.
	*/
	public abstract String registRecordDataName() throws Exception;
	
	/**
	* Return the data record list object which implements the IDataRecordList interface. 
	* In the tag jar file, it has define a DefaultDataRecordList object, You can simply
	* return this object by use new DefaultDataRecordList(list);
	*/
	public abstract IDataRecordList<T> registRecordDataList() throws Exception;
	
	
	@Before
	public void removeCheckedRecords(){
		//if can not find the parameters of "page/sortBy/sortOrder"
		//or the "removeRecords" is set to true(filter function)
		//then remove the attribute "checkedRecords" from session
		if((removeRecords != null && removeRecords == true) 
				|| (page == null && sortBy == null && sortOrder == null)){
			this.getSession().removeAttribute("checkedRecords");
		}
	}
	
	/**
	 * Get the list data and sub/sort it.
	 */
	@BeforeResult
	public void displayData() throws Exception{
		IDataRecordList<T> recordList = this.registRecordDataList();
		if(recordList != null){
			List<T> data = new ArrayList<T>();
			PreferenceConfigure configure = this.getConfigure(recordList);
			
			if(this.filterData != null){
				data = this.getFileterRecords(configure, recordList);
			}else{
				if(this.getSession().getAttribute("filterData") != null){
					data = this.getFilterRecordsFromSession(configure, recordList);
				}else{
					data = this.getRecordsFromBean(configure, recordList);
				}
			}
			
			// set the data into attribute
			String recordName = this.registRecordDataName();
			this.getServletRequest().setAttribute(recordName, data);
			this.getServletRequest().setAttribute("configure", configure);
		}
	}
	
	/**
	 * get filter records
	 * @param configure
	 * @param recordList
	 * @return
	 * @throws Exception
	 */
	private List<T> getFileterRecords(PreferenceConfigure configure , IDataRecordList<T> recordList) throws Exception{
		Integer dataSize = recordList.getFilterRecordSize(filterData);
		
		Integer beginIndex = this.getBeginIndex(dataSize , configure);
		Integer endIndex = this.getEndIndex(dataSize , configure);				
		List<T> data = recordList.getFilterRecords(filterData , beginIndex , endIndex , sortBy, SortOrderUtil.transfer(sortOrder));
		
		this.getSession().setAttribute("filterData", filterData);
		this.getServletRequest().setAttribute("dataSize", dataSize);
		return data;
		
	}
	
	/**
	 * get filter records from session
	 * @param configure
	 * @param recordList
	 * @return
	 * @throws Exception
	 */
	private List<T> getFilterRecordsFromSession(PreferenceConfigure configure , IDataRecordList<T> recordList) throws Exception{
		FilterData fd = (FilterData)this.getSession().getAttribute("filterData");
		Integer dataSize = recordList.getFilterRecordSize(fd);
		Integer beginIndex = this.getBeginIndex(dataSize , configure);
		Integer endIndex = this.getEndIndex(dataSize , configure);				
		
		this.getServletRequest().setAttribute("dataSize", dataSize);
		return recordList.getFilterRecords(fd , beginIndex , endIndex , sortBy, SortOrderUtil.transfer(sortOrder));
	}
	
	/**
	 * get record list from bean
	 * @param configure
	 * @param recordList
	 * @return
	 * @throws Exception
	 */
	private List<T> getRecordsFromBean(PreferenceConfigure configure , IDataRecordList<T> recordList) throws Exception{
		Integer dataSize = recordList.getAllRecordSize();
		Integer beginIndex = this.getBeginIndex(dataSize , configure);
		Integer endIndex = this.getEndIndex(dataSize , configure);
		
		this.getServletRequest().setAttribute("dataSize", dataSize);
		return recordList.getRecords(beginIndex , endIndex , sortBy , SortOrderUtil.transfer(sortOrder));
	}
	
	/**
	 * get preference object
	 * @param recordList
	 * @return
	 * @throws Exception
	 */
	private PreferenceConfigure getConfigure(IDataRecordList<T> recordList) throws Exception{
		PreferenceConfigure configure = recordList.getPreferenceConfigure();
		if(configure == null) configure = new SmartTableGridConfigure();
		return configure;
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

	public Boolean getRemoveRecords() {
		return removeRecords;
	}

	public void setRemoveRecords(Boolean removeRecords) {
		this.removeRecords = removeRecords;
	}
}
