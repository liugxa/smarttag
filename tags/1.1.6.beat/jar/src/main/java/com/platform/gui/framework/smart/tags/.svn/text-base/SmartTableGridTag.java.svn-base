package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartRowAction;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;
import com.platform.gui.framework.smart.tags.util.SmartTableGridUtil;

public class SmartTableGridTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	// Tag Attributes
	/* the name of the list bean */
	private String list;

	/* the default sort by column */
	private String sortBy;

	// Tag's Private objects
	/* Cell list of the table */
	private List<SmartCell> cells;

	/* Row list of the table */
	private List<SmartRow> rows;
	
	/* Row actions */
	private SmartRowAction rowAction;

	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		// new instance the cells and rows object, because the object of the tag
		// will be shared in every time.
		cells = new ArrayList<SmartCell>();
		rows = new ArrayList<SmartRow>();
		
		rowAction = new SmartRowAction();
		return EVAL_BODY_INCLUDE;
	}

	/**
	 * doEndTag() method!
	 */

	public int doEndTag() throws JspException {
		try{
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			SmartTableGridContext context = parent.getContext();
			
			// if can not get the cells from the JSP, get it from the bean
			if(cells.size() == 0) cells = SmartTableGridUtil.getSmartCellList(this.pageContext);
			
			// get the row data from the context
			rows = SmartTableGridUtil.getSmartRowList(this.pageContext , context);
			
			// list table object
			SmartTableGrid tableGrid = new SmartTableGrid(context , rows , cells);

			// transfer the parameters to its parent
			parent.setTableGrid(tableGrid);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public List<SmartCell> getCells() {
		return cells;
	}

	public void setCells(List<SmartCell> cells) {
		this.cells = cells;
	}

	public List<SmartRow> getRows() {
		return rows;
	}

	public void setRows(List<SmartRow> rows) {
		this.rows = rows;
	}

	public SmartRowAction getRowAction() {
		return rowAction;
	}

	public void setRowAction(SmartRowAction rowAction) {
		this.rowAction = rowAction;
	}
}
