package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;
import java.util.List;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.inter.IEnableHtml;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;


public class SmartTableGrid implements IEnableHtml{
	
	/* Smart table context object */
	private SmartTableContext context;
	
	/* Cell list of the table */
	private List<SmartCell> cells;

	/* Row list of the table */
	private List<SmartRow> rows;
	
	/* Table Pagination Object */
	private SmartPagination pagination;
	
	/**
	 * Default Constructed Function
	 */
	public SmartTableGrid(){}

	/**
	 * Constructed Function
	 * @param context
	 */
	public SmartTableGrid(SmartTableContext context , List<SmartRow> rows , List<SmartCell> cells){
		this.context = context;
		
		this.rows = rows;
		this.cells = cells;

		this.pagination = new SmartPagination(context);
	}

	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();

		root.put("context", this.context);
		
		//set table context and row action object
		root.put("tableGrid", this);
		
		//print the table header
		return FreeMarkerUtil.getTemplateHtml("tableGrid.ftl", root);
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

	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
	}

	public SmartPagination getPagination() {
		return pagination;
	}

	public void setPagination(SmartPagination pagination) {
		this.pagination = pagination;
	}
}
