package com.platform.gui.framework.smart.tags;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnablePreference;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.config.SmartTableConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartListTable;
import com.platform.gui.framework.smart.tags.model.SmartPreference;
import com.platform.gui.framework.smart.tags.model.SmartResourceBundle;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class SmartListTableTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	// Tag Attributes
	/* the name property */
	private String name;
	
	/* the action property */
	private String action;
	
	/* the resource property */
	private String resource;
	
	/* data record list */
	private IDataRecordList<?> dataRecords;

	/* data columns */
	private IDataColumn dataColumn;
	
	/* data column decorates */
	private IDataColumnDecorate dataColumnDecorate;

	/* data filter */
    private FilterData filterData;
    
	/* Smart context object */
	private SmartTableContext context;
	
	/* Smart Filter object */
	private SmartFilter filter;

	/* Smart table grid object */
	private SmartTableGrid tableGrid;

	/* Smart Preference object */
	private SmartPreference preference;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		try{
			context = this.getTableGridContext();
			
			// print the form heading
			JspWriter writer = pageContext.getOut();
			
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			String url = request.getContextPath() + action;
			writer.print(SmartListTable.getForm(name , url));
			
			return EVAL_BODY_INCLUDE;
		}catch(Exception e){
			e.printStackTrace();
			throw new JspException(e);
		}
	}

	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try {
			// list table object
			SmartListTable list = new SmartListTable(name , context , filter , tableGrid , preference);
			
			// print the table header
			JspWriter writer = pageContext.getOut();
			writer.print(list.getHtml());
			
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	protected SmartTableContext getTableGridContext() throws Exception{
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpSession session = pageContext.getSession();
		
		//get parameters map
		Map<String ,String> parameters = new HashMap<String , String>();
		Object obj = session.getAttribute(name);
		if(obj != null) parameters = (Map<String,String>)obj;
		
		String listName = request.getParameter(SmartConstants.PARAM_NAME);
		if(listName != null && listName.endsWith(name)){
			parameters.put(SmartConstants.PARAM_NAME , request.getParameter(SmartConstants.PARAM_NAME));
			parameters.put(SmartConstants.PARAMS_PAGE , request.getParameter(SmartConstants.PARAMS_PAGE));
			parameters.put(SmartConstants.PARAMS_SORT_BY , request.getParameter(SmartConstants.PARAMS_SORT_BY));
			parameters.put(SmartConstants.PARAMS_SORT_ORDER , request.getParameter(SmartConstants.PARAMS_SORT_ORDER));

			// save the preference into session
			session.setAttribute(name , parameters);
		}
		
		// URL parameter
		String url = request.getContextPath() + action;
		
		// get resource bundle object
        Locale locale = this.pageContext.getRequest().getLocale();
        SmartResourceBundle bundle = new SmartResourceBundle(resource , locale);
		
		// get configure object
		PreferenceConfigure configure = this.getPreferenceConfigure();
		
		// get checked record set
		return new SmartTableContext(name , url , configure , parameters , bundle);
	}
	
	private PreferenceConfigure getPreferenceConfigure() throws Exception{
		PreferenceConfigure configure = null;
		
		if(dataRecords != null && dataRecords instanceof IEnablePreference){
			configure = ((IEnablePreference)dataRecords).getPreferenceConfigure();
		}else{
			//get configure from the request
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			Object data = request.getAttribute(SmartConstants.DATA); 
			
			if(data != null && data instanceof IEnablePreference){
				configure = ((IEnablePreference)data).getPreferenceConfigure();
			}
		}
		
		if(configure == null) configure = new SmartTableConfigure();
		return configure;
	}
	
	public IDataRecordList<?> getDataRecords() {
		return dataRecords;
	}

	public void setDataRecords(IDataRecordList<?> dataRecords) {
		this.dataRecords = dataRecords;
	}

	public IDataColumn getDataColumn() {
		return dataColumn;
	}

	public void setDataColumn(IDataColumn dataColumn) {
		this.dataColumn = dataColumn;
	}

	public IDataColumnDecorate getDataColumnDecorate() {
		return dataColumnDecorate;
	}

	public void setDataColumnDecorate(IDataColumnDecorate dataColumnDecorate) {
		this.dataColumnDecorate = dataColumnDecorate;
	}

	public FilterData getFilterData() {
		return filterData;
	}

	public void setFilterData(FilterData filterData) {
		this.filterData = filterData;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public SmartFilter getFilter() {
		return filter;
	}

	public void setFilter(SmartFilter filter) {
		this.filter = filter;
	}

	public SmartTableGrid getTableGrid() {
		return tableGrid;
	}

	public void setTableGrid(SmartTableGrid tableGrid) {
		this.tableGrid = tableGrid;
	}

	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
	}

	public SmartPreference getPreference() {
		return preference;
	}

	public void setPreference(SmartPreference preference) {
		this.preference = preference;
	}
}
