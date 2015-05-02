package com.platform.gui.framework.smart.tags.model;

import java.util.List;

public class SmartRowAction {

	private String name;
	
	private List<SmartOption> options;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SmartOption> getOptions() {
		return options;
	}

	public void setOptions(List<SmartOption> options) {
		this.options = options;
	}
}
