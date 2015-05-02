package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;
import java.util.List;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.inter.IEnableHtml;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartFilter  extends SmartElement implements IEnableHtml{
	
	private SmartTableContext context;
	
	private List<SmartSection> sections;

	/**
	 * Default Constructed Function
	 */
	public SmartFilter(){}
	
	/**
	 * Constructed Function
	 * @param context
	 */
	public SmartFilter(SmartTableContext context , List<SmartSection> sections){
		this.context = context;
		this.sections = sections;
	}
	
	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		//set table configure object
		root.put("context", this.context);
		
		//set pagination and preference object
		root.put("filter", this);
		
		//print the table header
		return FreeMarkerUtil.getTemplateHtml("filter.ftl", root);
	}
	
	public List<SmartSection> getSections() {
		return sections;
	}

	public void setSections(List<SmartSection> sections) {
		this.sections = sections;
	}

	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
	}
}
