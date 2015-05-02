package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;

import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartHeader {
	
	private String contextPath;
	
	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		root.put("contextPath", this.contextPath);
		
		//print the table header
		return FreeMarkerUtil.getTemplateHtml("header.ftl", root);
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
}
