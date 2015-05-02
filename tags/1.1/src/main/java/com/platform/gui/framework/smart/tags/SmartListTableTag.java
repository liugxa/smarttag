package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartListTable;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class SmartListTableTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Smart Filter object
	 */
	private SmartFilter filter;

	/**
	 * Smart table grid object
	 */
	private SmartTableGrid tableGrid;

	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		
		// new instance the cells and rows object, because the object of the tag
		// will be shared in every time.
		filter = new SmartFilter();
		tableGrid = new SmartTableGrid();
		
		return EVAL_BODY_INCLUDE;
	}

	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try {
			// list table object
			SmartListTable list = new SmartListTable(filter , tableGrid);
			
			// print the table header
			JspWriter writer = pageContext.getOut();
			writer.print(list.getHtml());

			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
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
}
