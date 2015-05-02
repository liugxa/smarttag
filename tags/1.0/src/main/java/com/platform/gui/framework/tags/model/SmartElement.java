package com.platform.gui.framework.tags.model;

public class SmartElement {

	private String type;
	
	private String name;

	private String value;
	
	private String label;
	
	public SmartElement(){}
	
	public SmartElement(String type , String name , String label , String value){
		this.type = type;
		this.name = name;
		
		this.label = label;
		this.value = value;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
