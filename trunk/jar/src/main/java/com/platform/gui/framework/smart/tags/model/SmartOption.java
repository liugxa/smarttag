package com.platform.gui.framework.smart.tags.model;

public class SmartOption {

	private String key;
	
	private Object value;

	public SmartOption(){}
	
	public SmartOption(String key , Object value){
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
