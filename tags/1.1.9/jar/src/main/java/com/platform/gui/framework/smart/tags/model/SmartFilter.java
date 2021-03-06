package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;
import java.util.List;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.inter.IEnableHtml;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartFilter  implements IEnableHtml{
	
	private String label;
	
	private SmartTableContext context;
	
	private List<SmartSection> sections;

	private SmartFilterResult result;

	/**
	 * Default Constructed Function
	 */
	public SmartFilter(){}
	
	/**
	 * Constructed Function
	 * @param context
	 */
	public SmartFilter(SmartTableContext context){
		this.context = context;
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
		String templatePath = "/com/platform/gui/framework/smart/tags/template/";
		return FreeMarkerUtil.getTemplateHtml(templatePath , "filter.ftl", root);
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<SmartSection> getSections() {
		return sections;
	}

	public void setSections(List<SmartSection> sections) {
		this.sections = sections;
	}

	public SmartFilterResult getResult() {
		return result;
	}

	public void setResult(SmartFilterResult result) {
		this.result = result;
	}

	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
	}
}
