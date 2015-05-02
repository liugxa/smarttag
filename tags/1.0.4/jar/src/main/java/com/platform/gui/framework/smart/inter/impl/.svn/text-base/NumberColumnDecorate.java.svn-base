package com.platform.gui.framework.smart.inter.impl;

import java.text.NumberFormat;

public class NumberColumnDecorate extends DefaultColumnDecorate{

	private String pattern;
	
	public NumberColumnDecorate(){}
	
	public NumberColumnDecorate(String pattern){
		this.pattern = pattern;
	}
	
	public String decorate(Object bean , String columnName) throws Exception {
		Object columnValue = this.getColumnValue(bean, columnName);
		return NumberFormat.getInstance().format(columnValue);
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
