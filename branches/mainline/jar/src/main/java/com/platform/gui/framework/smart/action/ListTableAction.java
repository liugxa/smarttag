package com.platform.gui.framework.smart.action;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.model.FilterData;

/**
 * List Table Action
 * @author root
 * please define the IDataRecordList/IDataColumn/IDataColumnDecorate in your action.
 * and set them into the request or session.
 * this class will be deleted in the version 1.1.8
 * @param <T>
 */
public abstract class ListTableAction<T> extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	/* the clear session parameter */
	private Boolean clearSession;
	
	/* the filter object */
	private FilterData filterData;
		
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
    public IDataColumn registDataColumn() throws Exception {
        return null;
    }

    /**
     * Register the data column decorate
     * @return
     * @throws Exception
     */
    public IDataColumnDecorate registDataColumnDecorate() throws Exception{
        return null;
    }
	
	/**
	 * Get the list data and sub/sort it.
	 */
	@BeforeResult
	public void displayData() throws Exception{
		try{
			IDataRecordList<T> recordList = this.registRecordDataList();
			if(recordList != null){
				HttpServletRequest request = this.getServletRequest();
				
				if(this.filterData != null){
					request.getSession().setAttribute(SmartConstants.FILTER_DATA, filterData);
				}
				
				// set the data column into request
				request.setAttribute(SmartConstants.DATA_COLUMN, this.registDataColumn());
	
	            // set the column decorate into request
	            request.setAttribute(SmartConstants.DATA_COLUMN_DECORATE , this.registDataColumnDecorate());
	            
				// set the data into request
				//request.setAttribute(SmartConstants.DATA, data);
				request.setAttribute(SmartConstants.DATA, recordList);
			}
		}catch(Exception e){
			this.addActionError(e.getMessage());
		}
	}

	public FilterData getFilterData() {
		return filterData;
	}

	public void setFilterData(FilterData filterData) {
		this.filterData = filterData;
	}

	public Boolean getClearSession() {
		return clearSession;
	}

	public void setClearSession(Boolean clearSession) {
		this.clearSession = clearSession;
	}
}
