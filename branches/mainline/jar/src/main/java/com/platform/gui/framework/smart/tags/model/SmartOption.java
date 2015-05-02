package com.platform.gui.framework.smart.tags.model;

import com.platform.gui.framework.smart.SmartConstants;

public class SmartOption extends SmartElement{
	
	private Boolean selected;
	
	public SmartOption(){
		this.dTemplate = SmartConstants.TEMPLATE_OPTION;
	}
	
	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
