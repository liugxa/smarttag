package com.platform.gui.framework.smart.tags;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataItem;
import com.platform.gui.framework.smart.inter.IDataItemDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnablePreference;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.config.SmartTableConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartListTable;
import com.platform.gui.framework.smart.tags.model.SmartPreference;
import com.platform.gui.framework.smart.tags.model.SmartResourceBundle;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;
import com.platform.gui.framework.smart.tags.util.SmartFilterUtil;
import com.platform.gui.framework.smart.tags.util.SmartTableGridUtil;
import com.platform.gui.framework.smart.util.FilterDataUtil;

public class SmartListTableTag extends  TagSupport {

	private static Logger logger = Logger.getLogger(SmartListTableTag.class);
	
	private static final long serialVersionUID = 1L;
	
	// Tag Attributes
	/* the name property */
	private String name;
	
	/* the action property */
	private String action;
	
	/* the resource property */
	private String resource;
	
	/* the form property: GET/POST/NONE*/
	private String form;
	
	/* data record list */
	private IDataRecordList<?> dataRecords;

	/* data columns */
	private IDataColumn dataColumn;
	
	/* data column decorate */
	private IDataColumnDecorate dataColumnDecorate;
	
	/* data items */
	private IDataItem dataItem;
	
	/* data item decorate */
	private IDataItemDecorate dataItemDecorate;
	
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
			//initialize table context
			this.filter = null;
			this.tableGrid = null;
			
			context = this.getTableGridContext();
			return EVAL_BODY_INCLUDE;
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new SmartTagException(e);
		}
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try {
			
			// list table object
			// if do not define the <pf:table/> in JSP file, instance it
			if(tableGrid == null) tableGrid = SmartTableGridUtil.getSmartTable(context, dataRecords, dataColumn, dataColumnDecorate);
			
			if(filter == null) filter = SmartFilterUtil.getSmartFilter(context, dataItem, dataItemDecorate);
			SmartListTable list = new SmartListTable(name , form , context , filter , tableGrid , preference);
			
			// print the table header
			JspWriter writer = pageContext.getOut();
			writer.print(list.getHtml());
			
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			throw new SmartTagException(e);
		}
	}
	
	/**
	 * Get the smart tag context object
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected SmartTableContext getTableGridContext() throws Exception{
		SmartTableContext context = new SmartTableContext();
		context.setName(name);
		context.setAction(action);
		context.setPageContext(pageContext);
		
		//get context path
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		context.setContextPath(request.getContextPath());
		
		//get parameters map
		Map<String ,String> parameters = new HashMap<String , String>();

		//after execute the filter, all of the data should be reset.
		String formName = request.getParameter(SmartConstants.PARAM_NAME);
		String page = request.getParameter(SmartConstants.PARAMS_PAGE);
		String sortBy = request.getParameter(SmartConstants.PARAMS_SORT_BY);
		String sortOrder = request.getParameter(SmartConstants.PARAMS_SORT_ORDER);
		
		//if can not find the parameters in request, reset it.
		HttpSession session = pageContext.getSession();
		if(formName != null || page != null || sortBy != null || sortOrder != null){
			Object obj = session.getAttribute(name);
			if(obj != null) parameters = (Map<String,String>)obj;
			
			String listName = request.getParameter(SmartConstants.PARAM_NAME);
			if(listName != null && listName.equals(name)){
				if(formName != null) parameters.put(SmartConstants.PARAM_NAME , formName);
				if(page != null) parameters.put(SmartConstants.PARAMS_PAGE , page);
				if(sortBy != null) parameters.put(SmartConstants.PARAMS_SORT_BY , sortBy);
				if(sortOrder != null) parameters.put(SmartConstants.PARAMS_SORT_ORDER , sortOrder);
	
				// save the preference into session
				session.setAttribute(name , parameters);
			}
		}
		context.setParameters(parameters);
		
		// get configure object
		PreferenceConfigure configure = this.getPreferenceConfigure();
		context.setConfigure(configure);
		
		// get location
		// get it from the configure at first. if can not find it, get it from the page context
		Locale locale = configure.getLocale();
		if(locale == null) locale = this.pageContext.getRequest().getLocale();
		
		// get resource bundle object
		SmartResourceBundle bundle = new SmartResourceBundle(resource , locale);
		context.setResource(bundle);
		
		// get data size
		Integer dataSize = SmartTableGridUtil.getSmartDataSize(this.pageContext , parameters , dataRecords);
		context.setDataSize(dataSize);
		
		// get filter data;
		String filterName = parameters.get(SmartConstants.PARAM_NAME);
		FilterData filterData = FilterDataUtil.getFilterData(pageContext , filterName);
		context.setFilterData(filterData);
		
		return context;
	}
	
	/**
	 * Get preference object
	 * @return
	 * @throws Exception
	 */
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

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public IDataItem getDataItem() {
		return dataItem;
	}

	public void setDataItem(IDataItem dataItem) {
		this.dataItem = dataItem;
	}

	public IDataItemDecorate getDataItemDecorate() {
		return dataItemDecorate;
	}

	public void setDataItemDecorate(IDataItemDecorate dataItemDecorate) {
		this.dataItemDecorate = dataItemDecorate;
	}
}
