package com.platform.gui.framework.tags.model;

import java.util.HashMap;

import com.platform.gui.framework.tags.context.SmartTableGridContext;
import com.platform.gui.framework.tags.inter.IEnableHtml;
import com.platform.gui.framework.tags.util.FreeMarkerUtil;


public class SmartTableGrid implements IEnableHtml{
	
	private SmartTableGridContext context;
	
	/**
	 * Table Pagination Object
	 */
	private SmartPagination pagination;
	
	/**
	 * Table Preference Object
	 */
	private SmartPreference preference;
	
	/**
	 * Row actions	
	 */
	private SmartRowAction rowAction;
	
	/**
	 * Default Constructed Function
	 */
	public SmartTableGrid(){}
	
	/**
	 * Constructed Function
	 * @param context
	 */
	public SmartTableGrid(SmartTableGridContext context , SmartRowAction rowAction){
		this.context = context;
		this.rowAction = rowAction;
		
		this.pagination = new SmartPagination(context);
		this.preference = new SmartPreference(context);
	}

	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();

		//set table context and row action object
		root.put("context", this.context);
		root.put("rowAction", this.rowAction);
		
		//set pagination and preference object
		root.put("pagination", this.pagination);
		root.put("preference", this.preference);
		
		//print the table header
		String templatePath = "/com/platform/gui/framework/tags/template/";
		return FreeMarkerUtil.getTemplateHtml(templatePath , "tableGrid.ftl", root);
	}
	
	public SmartTableGridContext getContext() {
		return context;
	}

	public void setContext(SmartTableGridContext context) {
		this.context = context;
	}

	public SmartPagination getPagination() {
		return pagination;
	}

	public void setPagination(SmartPagination pagination) {
		this.pagination = pagination;
	}

	public SmartPreference getPreference() {
		return preference;
	}

	public void setPreference(SmartPreference preference) {
		this.preference = preference;
	}
	
	public SmartRowAction getRowAction() {
		return rowAction;
	}
	
	public void setRowAction(SmartRowAction rowAction) {
		this.rowAction = rowAction;
	}
}
