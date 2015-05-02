package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.inter.IEnableHtml;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartListTable implements IEnableHtml{
	
	/* the list table name */
	private String name;
	
	private String form;
	
	/* the context object */
	private SmartTableContext context;
	
	/* Smart Filter object */
	private SmartFilter filter;

	/* Smart table grid object */
	private SmartTableGrid tableGrid;

	/* Smart preference object */
	private SmartPreference preference;
	
	/* Default Constructed Function */
	public SmartListTable(){}
	
	/**
	 * Constructed Function
	 * @param filter
	 * @param tableGrid
	 */
	public SmartListTable(String name , String form , SmartTableContext context , SmartFilter filter , 
			SmartTableGrid tableGrid , SmartPreference preference){
		this.name = name;
		this.form = form;
		
		//the filter's context came from the table grid object
		this.context = context;
		this.filter = filter;
		
		this.tableGrid = tableGrid;
		this.preference = preference;
	}

	public static String getForm(String name , String form , SmartTableContext context) throws Exception{
		HashMap<String, Object> root = new HashMap<String, Object>();

		root.put("name", name);
		root.put("form" , form);
		
		//set context object
		root.put("context", context);
			
		//print the table header
		return FreeMarkerUtil.getTemplateHtml("form.ftl", root);		
	}
	
	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		//set the list table name
		root.put("name", name);
		root.put("form" , form);
		
		//set context object
		root.put("context", this.context);
		
		//set filter object
		root.put("filter", this.filter);
		
		//set table grid object
		root.put("tableGrid", this.tableGrid);
		
		//set preference object
		root.put("preference", this.preference);
		
		//print the table header
		return FreeMarkerUtil.getTemplateHtml("listTable.ftl", root);		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
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

	public SmartPreference getPreference() {
		return preference;
	}

	public void setPreference(SmartPreference preference) {
		this.preference = preference;
	}
}
