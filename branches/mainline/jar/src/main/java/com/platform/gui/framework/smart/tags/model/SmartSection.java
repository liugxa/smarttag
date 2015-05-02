package com.platform.gui.framework.smart.tags.model;

import java.util.List;

import com.platform.gui.framework.smart.SmartConstants;

public class SmartSection extends SmartElement{
	
	private boolean isDefault;
	
	private List<SmartElement> elements;

	private SmartButton button;

	public SmartSection(){
		this.dTemplate = SmartConstants.TEMPLATE_SECTION;
	}

	public List<SmartElement> getElements() {
		return elements;
	}

	public void setElements(List<SmartElement> elements) {
		this.elements = elements;
	}

	public SmartButton getButton() {
		return button;
	}

	public void setButton(SmartButton button) {
		this.button = button;
	}

	public boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
}
