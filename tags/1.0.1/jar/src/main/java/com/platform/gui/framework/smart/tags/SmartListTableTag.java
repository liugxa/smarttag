package com.platform.gui.framework.smart.tags;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;
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

	protected SmartTableGridContext getTableGridContext() {
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		
		// add the context path before the "action" parameter
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("page", request.getParameter("page"));
		parameters.put("sortBy", request.getParameter("sortBy"));
		parameters.put("sortOrder", request.getParameter("sortOrder"));

		String dataSize = request.getAttribute("dataSize") + "";
		parameters.put("dataSize", dataSize);
		
		SmartTableGridConfigure configure = (SmartTableGridConfigure)request.getAttribute("configure");
		return new SmartTableGridContext(request.getContextPath() + action , parameters , configure);
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
