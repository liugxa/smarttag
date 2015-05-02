package com.platform.gui.framework.tags.model;

import com.platform.gui.framework.tags.decorate.IColumnDecorate;

public class SmartCell {

	private String name;
	
	private String value;

	private String url;
	
	private String format;
	
	private String decorate;
	
	private IColumnDecorate columnDecorate;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDecorate() {
		return decorate;
	}

	public void setDecorate(String decorate) {
		this.decorate = decorate;
	}

	public IColumnDecorate getColumnDecorate() {
		return columnDecorate;
	}

	public void setColumnDecorate(IColumnDecorate columnDecorate) {
		this.columnDecorate = columnDecorate;
	}
}
