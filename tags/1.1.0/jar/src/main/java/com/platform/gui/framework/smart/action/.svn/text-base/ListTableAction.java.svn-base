package com.platform.gui.framework.smart.action;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.model.FilterData;

public abstract class ListTableAction<T> extends AbstractAction{

	private static final long serialVersionUID = 1L;

	/* the sort by parameter */
	private String sortBy;
	
	/* the sort order parameter */
	private String sortOrder;

	/* the page parameter */
	private String page;
	
	/* the clear session parameter */
	private Boolean clearSession;
	
	/* the filter object */
	private FilterData filterData;
	
	/**
	* Return the list date name. And it should be same with the name which be
	* Define in the JSP file. In the JSP, you has define the list name by use “pf:table”.
	*/
	//public abstract String registRecordDataName() throws Exception;
	
	/**
	* Return the data record list object which implements the IDataRecordList interface. 
	* In the tag jar file, it has define a DefaultDataRecordList object, You can simply
	* return this object by use new DefaultDataRecordList(list);
	* 
	* NOTE:
	* user can choice to define data into the JSP file or implement thE IDataRecordList interface.
	* 
	* PRIORITY:
	* JSP file > interface
	*/
	public abstract IDataRecordList<T> registRecordDataList() throws Exception;
	
	
	/**
	 * Return the data column which implement the IDataColumn interface.
	 * 
	 * NOTE
	 * user can choice to define the column information in JSP file,implement the interface 
	 * or define it into the preference file.
	 * 
	 * PRIORITY
	 * Preference > JSP file > interface.
	 */
	public IDataColumn registDataColumn() throws Exception{
		return null;
	}
	
	@Before
	public void removeSessionData(){
		//if can not find the parameters of "page/sortBy/sortOrder"
		//or the "clearSession" is set to true(filter function)
		//then remove the attribute "checkedRecords" from session
		if((clearSession != null && clearSession == true) 
				|| (page == null && sortBy == null && sortOrder == null)){
			
			//remove check records
			this.getSession().removeAttribute(SmartConstants.CHECKED_RECORDS);
			
			//remove filter data
			this.getSession().removeAttribute(SmartConstants.FILTER_DATA);
		}
	}
	
	/**
	 * Get the list data and sub/sort it.
	 */
	@BeforeResult
	public void displayData() throws Exception{
		IDataRecordList<T> recordList = this.registRecordDataList();
		if(recordList != null){
			HttpServletRequest request = this.getServletRequest();
			
			if(this.filterData != null){
				request.getSession().setAttribute(SmartConstants.FILTER_DATA, filterData);
			}
			
			// set the data column into request
			request.setAttribute(SmartConstants.DATA_COLUMN, this.registDataColumn());
			
			// set the data into request
			//request.setAttribute(SmartConstants.DATA, data);
			request.setAttribute(SmartConstants.DATA, recordList);
		}
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

	public Boolean getClearSession() {
		return clearSession;
	}

	public void setClearSession(Boolean clearSession) {
		this.clearSession = clearSession;
	}
}
