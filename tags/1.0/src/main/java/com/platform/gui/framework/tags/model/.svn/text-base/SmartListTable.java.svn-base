package com.platform.gui.framework.tags.model;

import com.platform.gui.framework.tags.inter.IEnableHtml;

public class SmartListTable implements IEnableHtml{
	
	/**
	 * Smart Filter object
	 */
	private SmartFilter filter;

	/**
	 * Smart table grid object
	 */
	private SmartTableGrid tableGrid;

	/**
	 * Default Constructed Function
	 */
	public SmartListTable(){}
	
	/**
	 * Constructed Function
	 * @param filter
	 * @param tableGrid
	 */
	public SmartListTable(SmartFilter filter , SmartTableGrid tableGrid){
		//the filter's context came from the table grid object
		this.filter = filter;
		filter.setContext(tableGrid.getContext());
		
		this.tableGrid = tableGrid;
	}

	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		StringBuffer buffer = new StringBuffer();
		buffer.append(filter.getHtml());
		buffer.append(tableGrid.getHtml());
		return buffer.toString();
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
