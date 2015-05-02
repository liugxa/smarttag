package com.platform.gui.framework.smart.tags.model;

import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;


public class SmartPreference {

	private String label;
	
	private SmartTableGridContext context;

	public SmartPreference(){}
	
	public SmartPreference(SmartTableGridContext context){
		this.context = context;
	}

	public String getLabel() {
		return label;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public SmartTableGridContext getContext() {
		return context;
	}

	public void setContext(SmartTableGridContext context) {
		this.context = context;
	}
}
