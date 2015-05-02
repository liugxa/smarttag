package com.platform.gui.framework.tags.context;

import java.util.List;
import java.util.Map;

import com.platform.gui.framework.tags.config.SmartTableGridConfigure;
import com.platform.gui.framework.tags.model.SmartCell;
import com.platform.gui.framework.tags.model.SmartRow;

public class SmartTableGridContext {
	
	/**
	 * The smart tag configure object
	 */
	private SmartTableGridConfigure configure;
	
	/**
	 * All of the parameters in the request
	 */
	private Map<String, String> parameters;
	
	/**
	 * Cell list of the table
	 */
	private List<SmartCell> cells;

	/**
	 * Row list of the table
	 */
	private List<SmartRow> rows;

	/**
	 * SmartTableGridContext
	 */
	public SmartTableGridContext(){}
	
	/**
	 * SmartTableGridContext
	 * @param cells
	 * @param rows
	 * @param parameters
	 * @param action
	 */
	public SmartTableGridContext(List<SmartCell> cells, List<SmartRow> rows, 
			Map<String , String> parameters , SmartTableGridConfigure configure) {
		this.cells = cells;
		this.rows = rows;		
		this.parameters = parameters;
		
		this.configure = configure;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
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

	public SmartTableGridConfigure getConfigure() {
		return configure;
	}

	public void setConfigure(SmartTableGridConfigure configure) {
		this.configure = configure;
	}
}
