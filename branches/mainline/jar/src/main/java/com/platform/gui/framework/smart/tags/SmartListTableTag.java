package com.platform.gui.framework.smart.tags;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnablePreference;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.config.SmartTableConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartListTable;
import com.platform.gui.framework.smart.tags.model.SmartPreference;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;
import com.platform.gui.framework.smart.tags.util.SmartTableGridUtil;

public class SmartListTableTag extends SmartElementTag {

	private Logger logger = Logger.getLogger(SmartListTableTag.class);
	
	private static final long serialVersionUID = 1L;
	
	// Tag Attributes
	/* the action property */
	private String action;
	
	/* data record list */
	private IDataRecordList<?> dataRecords;

	/* data columns */
	private IDataColumn dataColumn;
	
	/* data column decorates */
	private IDataColumnDecorate dataColumnDecorate;
	
	/* Smart Filter object */
	private SmartFilter filter;

	/* Smart table grid object */
	private SmartTableGrid tableGrid;

	/* Smart Preference object */
	private SmartPreference preference;
	
	private SmartListTable list;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		try{
			context = this.getTableGridContext();
			pageContext.setAttribute("st_context", context);
			list = new SmartListTable();
			
			//print header
			this.printHeader();
			return EVAL_BODY_INCLUDE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}

	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try {
			// list table object
			list.setId(0);
			list.setName(name);
			list.setLabel(this.getText(label));
			
			list.setValue(value);
			list.setAction(action);
			
			list.setFilter(filter);
			list.setTableGrid(tableGrid);
			list.setPreference(preference);
			
			list.setContext(context);
			list.setTemplate(template);
			list.setTemplatePath(templatePath);
			
			// print the table header
			JspWriter writer = pageContext.getOut();
			writer.print(list.getHtml());
			
			// print footer
			this.printFooter();
			return EVAL_PAGE;
		} catch (Exception e) {
			logger.error(e.getMessage());
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
		
		//get data size
		Integer dataSize = SmartTableGridUtil.getSmartRowSize(pageContext, dataRecords);
		
		// get configure object
		PreferenceConfigure configure = this.getPreferenceConfigure();
		
		// get checked record set
		String url = request.getContextPath() + action;
		return new SmartTableContext(name , url , dataSize , configure , parameters , pageContext.getServletContext());
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
	
	private void printHeader() throws Exception{
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		//set table configure object
		root.put("context", this.context);
		
		//set table context and row action object
		root.put("self", this);
		
		String header = FreeMarkerUtil.getTemplateHtml(pageContext.getServletContext() , SmartConstants.TEMPLATE_PATH , SmartConstants.TEMPLATE_LIST_HEADER , root);
		pageContext.getOut().write(header);
	}

	public void printFooter() throws Exception{
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		//set table configure object
		root.put("context", this.context);
		
		//set table context and row action object
		root.put("self", this);
		
		String footer = FreeMarkerUtil.getTemplateHtml(pageContext.getServletContext() , SmartConstants.TEMPLATE_PATH , SmartConstants.TEMPLATE_LIST_FOOTER , root);
		pageContext.getOut().write(footer);
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
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

	public SmartListTable getList() {
		return list;
	}

	public void setList(SmartListTable list) {
		this.list = list;
	}
}
