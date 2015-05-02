package com.platform.gui.framework.smart.tags.model;

import java.util.Map;


public class SmartFilterResult{

	private Map<String , String> elements;
	
	public SmartFilterResult(){}
	
	public SmartFilterResult(Map<String , String> elements){
		this.elements = elements;
	}
	
	public Map<String , String> getElements() {
		return elements;
	}

	public void setElements(Map<String , String> elements) {
		this.elements = elements;
	}
}
