package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;

import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartHeader {
	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		//print the table header
		String templatePath = "/com/platform/gui/framework/smart/tags/template/";
		return FreeMarkerUtil.getTemplateHtml(templatePath , "header.ftl", root);
	}
}
