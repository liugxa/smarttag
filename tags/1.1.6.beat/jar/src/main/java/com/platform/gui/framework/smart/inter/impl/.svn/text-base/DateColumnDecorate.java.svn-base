package com.platform.gui.framework.smart.inter.impl;

import java.text.SimpleDateFormat;

public class DateColumnDecorate extends DefaultColumnDecorate{

	private String pattern = "MM/dd/yyyy";
	
	/**
	 * Default constructed Function
	 * @param pattern
	 */
	public DateColumnDecorate(){}
	
	/**
	 * Default constructed Function
	 * @param pattern
	 */
	public DateColumnDecorate(String pattern){
		this.pattern = pattern;
	}
	
	/**
	 * Decorate column value
	 * @param columnValue
	 * @return
	 */
	public String decorate(Integer index , Object bean , String columnName) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat(this.pattern);
		Object columnValue = this.getColumnValue(bean, columnName);
		return format.format(columnValue);
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
