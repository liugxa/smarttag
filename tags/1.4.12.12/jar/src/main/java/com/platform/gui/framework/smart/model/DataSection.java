package com.platform.gui.framework.smart.model;


public class DataSection extends DataElement{
	
	private boolean isDefault;

	/* the button's label */
	private String buttonLabel;
	
	public DataSection(){}
	
	public DataSection(String label){
		this.setLabel(label);
	}
	
	public DataSection(String name , String label){
		this.setName(name);
		this.setLabel(label);
	}
	
	public boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public String getButtonLabel() {
		return buttonLabel;
	}

	public void setButtonLabel(String buttonLabel) {
		this.buttonLabel = buttonLabel;
	}
}
