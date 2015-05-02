package com.platform.gui.demo.components.model;

public class Option {

	private String name;
	
	private String value;

	public Option(){}
	
	public Option(String name , String value){
		this.name = name;
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
}
