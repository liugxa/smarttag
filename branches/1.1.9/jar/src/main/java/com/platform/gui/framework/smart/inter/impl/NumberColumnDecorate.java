package com.platform.gui.framework.smart.inter.impl;

import java.text.NumberFormat;

import com.platform.gui.framework.smart.model.DataColumn;

public class NumberColumnDecorate extends DefaultColumnDecorate{

	private String pattern;
	
	public NumberColumnDecorate(){}
	
	public NumberColumnDecorate(String pattern){
		this.pattern = pattern;
	}
	
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		Object columnValue = this.getColumnKeyValue(bean, column);
		return NumberFormat.getInstance().format(columnValue);
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
