package com.platform.gui.framework.smart.tags.model;

import java.util.List;

import com.platform.gui.framework.smart.SmartConstants;


public class SmartTableGrid extends SmartElement{
	
	/* Cell list of the table */
	private List<SmartCell> cells;

	/* Row list of the table */
	private List<SmartRow> rows;
	
	/* Table Pagination Object */
	private SmartPagination pagination;
	
	/**
	 * Default Constructed Function
	 */
	public SmartTableGrid(){
		this.dTemplate = SmartConstants.TEMPLATE_TABLE;
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

	public SmartPagination getPagination() {
		return pagination;
	}

	public void setPagination(SmartPagination pagination) {
		this.pagination = pagination;
	}
}
