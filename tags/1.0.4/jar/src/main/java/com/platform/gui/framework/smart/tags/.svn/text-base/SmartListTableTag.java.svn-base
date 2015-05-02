package com.platform.gui.framework.smart.tags;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartListTable;
import com.platform.gui.framework.smart.tags.model.SmartPreference;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class SmartListTableTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	private String action;
	
	private SmartTableGridContext context;
	
	/**
	 * Smart Filter object
	 */
	private SmartFilter filter;

	/**
	 * Smart table grid object
	 */
	private SmartTableGrid tableGrid;

	/**
	 * Smart Preference object
	 */
	private SmartPreference preference;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		context = this.getTableGridContext();
		return EVAL_BODY_INCLUDE;
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
	protected SmartTableGridContext getTableGridContext() {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpSession session = pageContext.getSession();
		
		// add the context path before the "action" parameter
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("page", request.getParameter("page"));
		parameters.put("sortBy", request.getParameter("sortBy"));
		parameters.put("sortOrder", request.getParameter("sortOrder"));

		//URL parameter
		String url = request.getContextPath() + action;
		
		//data size
		Object dataSize = request.getAttribute("dataSize");
		Integer ds = -1;
		if(dataSize != null) ds = (Integer)dataSize;
		
		// get preference object
		PreferenceConfigure configure = (PreferenceConfigure)request.getAttribute("configure");
		
		// get checked record set
		Set<String> checkedRecords = (Set<String>)session.getAttribute("checkedRecords");
		return new SmartTableGridContext(request.getContextPath() , url , ds , parameters , configure , checkedRecords);
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
