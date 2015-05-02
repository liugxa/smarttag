package com.platform.gui.framework.smart.tags;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataRecordList;
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

	@SuppressWarnings("unchecked")
	protected SmartTableGridContext getTableGridContext() throws Exception{
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpSession session = pageContext.getSession();
		
		// add the context path before the "action" parameter
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put(SmartConstants.PAGE, request.getParameter(SmartConstants.PAGE));
		parameters.put(SmartConstants.SORTBY, request.getParameter(SmartConstants.SORTBY));
		parameters.put(SmartConstants.SORTORDER, request.getParameter(SmartConstants.SORTORDER));

		// URL parameter
		String url = request.getContextPath() + action;
		
		// get data size and preference object
		Integer dataSize = 0;
		PreferenceConfigure configure = new SmartTableGridConfigure();
		Object data = request.getAttribute(SmartConstants.DATA); 
		if(data != null){
			IDataRecordList recordList = (IDataRecordList)data;
			Object filter = session.getAttribute(SmartConstants.FILTER_DATA);
			if(filter != null){
				dataSize = recordList.getFilterRecordSize((FilterData)filter);
			}else{
				dataSize = recordList.getAllRecordSize();
			}
			
			// get preference object
			PreferenceConfigure cf = recordList.getPreferenceConfigure();
			if(cf != null) configure = cf;
		}
		
		// get checked record set
		Set<String> checkedRecords = (Set<String>)session.getAttribute(SmartConstants.CHECKED_RECORDS);
		return new SmartTableGridContext(request.getContextPath() , url , dataSize , parameters , configure , checkedRecords);
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
