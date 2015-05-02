package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;
import java.util.List;

import com.platform.gui.framework.smart.tags.inter.IEnableHtml;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartSelect implements IEnableHtml{

	private String id;
	
	private String name;
	
	private String value;
	
	private Boolean readonly;
	
	private String onclick;
	
	private String onchange;
	
	private String onblur;
	
	private String onkeydown;
	
	private List<SmartOption> options;
	
	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		//set the list table name
		root.put("select" , this);
		
		//print the table header
		return FreeMarkerUtil.getTemplateHtml("select.ftl", root);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public List<SmartOption> getOptions() {
		return options;
	}

	public void setOptions(List<SmartOption> options) {
		this.options = options;
	}

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public String getOnblur() {
		return onblur;
	}

	public void setOnblur(String onblur) {
		this.onblur = onblur;
	}

	public String getOnkeydown() {
		return onkeydown;
	}

	public void setOnkeydown(String onkeydown) {
		this.onkeydown = onkeydown;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}
}
