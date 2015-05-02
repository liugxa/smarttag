package com.platform.gui.framework.smart.tags.model;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IColumnDecorate;

public class SmartCell extends SmartElement{

	private Boolean disable;
	
	private String parameters;
	
	private String decorate;
	
	private IColumnDecorate columnDecorate;
	
	public SmartCell(){
		this.dTemplate = SmartConstants.TEMPLATE_COLUMN;
	}
	
	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public String getDecorate() {
		return decorate;
	}

	public void setDecorate(String decorate) {
		this.decorate = decorate;
	}

	public IColumnDecorate getColumnDecorate() {
		return columnDecorate;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public void setColumnDecorate(IColumnDecorate columnDecorate) {
		this.columnDecorate = columnDecorate;
	}
}
