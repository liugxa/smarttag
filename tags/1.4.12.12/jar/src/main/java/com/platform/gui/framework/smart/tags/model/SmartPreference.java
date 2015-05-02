package com.platform.gui.framework.smart.tags.model;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;


public class SmartPreference {

	private String label;
	
	private SmartTableContext context;

	public SmartPreference(){}
	
	public SmartPreference(SmartTableContext context){
		this.context = context;
	}

	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public SmartTableContext getContext() {
		return context;
	}

	public void setContext(SmartTableContext context) {
		this.context = context;
	}
}
