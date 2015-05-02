package com.platform.gui.framework.smart.tags;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnableFilter;
import com.platform.gui.framework.smart.inter.IEnablePreference;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartListTable;
import com.platform.gui.framework.smart.tags.model.SmartPreference;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class SmartListTableTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	/* the action property */
	private String action;
	
	/* Smart context object */
	private SmartTableGridContext context;
	
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
			SmartListTable list = new SmartListTable(context , filter , tableGrid , preference);
			
			// print the table header
			JspWriter writer = pageContext.getOut();
			writer.print(list.getHtml());

			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
	}

	protected SmartTableGridContext getTableGridContext() throws Exception{
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		
		// add the context path before the "action" parameter
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(SmartConstants.PAGE, request.getParameter(SmartConstants.PAGE));
		parameters.put(SmartConstants.SORTBY, request.getParameter(SmartConstants.SORTBY));
		parameters.put(SmartConstants.SORTORDER, request.getParameter(SmartConstants.SORTORDER));

		// URL parameter
		String url = request.getContextPath() + action;
		
		// get data size
		Integer dataSize = this.getRecordDataSize(this.pageContext);
		
		// get the preference object
		PreferenceConfigure configure = this.getPreferenceConfigure(this.pageContext);
		
		// get checked record set
		return new SmartTableGridContext(request.getContextPath() , url , dataSize , parameters , configure);
	}
	
	@SuppressWarnings("unchecked")
	private Integer getRecordDataSize(PageContext pageContext) throws Exception{
		Integer dataSize = 0;
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpSession session = pageContext.getSession();
		
		Object data = request.getAttribute(SmartConstants.DATA); 
		if(data != null){
			IDataRecordList recordList = (IDataRecordList)data;
			Object filter = session.getAttribute(SmartConstants.FILTER_DATA);
			if(filter != null){
				//if the object implement the IEnableFilter interface. then get the data size
				//from the "getFilterRecordSize" method.
				if(recordList instanceof IEnableFilter){
					//change to IEnableFilter object
					IEnableFilter filterList = (IEnableFilter)recordList;
					dataSize = filterList.getFilterRecordSize((FilterData)filter);
				}
			}else{
				dataSize = recordList.getAllRecordSize();
			}
		}
		return dataSize;
	}
	
	private PreferenceConfigure getPreferenceConfigure(PageContext pageContext) throws Exception{
		PreferenceConfigure configure = new SmartTableGridConfigure();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		
		Object data = request.getAttribute(SmartConstants.DATA); 
		if(data != null && data instanceof IEnablePreference){
				PreferenceConfigure cf = ((IEnablePreference)data).getPreferenceConfigure();
				if(cf != null) configure = cf;
		}
		return configure;
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

	public SmartTableGridContext getContext() {
		return context;
	}

	public void setContext(SmartTableGridContext context) {
		this.context = context;
	}

	public SmartPreference getPreference() {
		return preference;
	}

	public void setPreference(SmartPreference preference) {
		this.preference = preference;
	}
}
