package com.platform.gui.framework.smart.inter.impl;

import java.text.SimpleDateFormat;

public class DateColumnDecorate extends DefaultColumnDecorate{

	/**
	 * Default constructed Function
	 * @param pattern
	 */
	public DateColumnDecorate(){
		super("MM/dd/yyyy");
	}
	
	/**
	 * Default constructed Function
	 * @param pattern
	 */
	public DateColumnDecorate(String pattern){
		super(pattern);
	}
	
	/**
	 * Decorate column value
	 * @param columnValue
	 * @return
	 */
	public String decorate(Object column){
		SimpleDateFormat format = new SimpleDateFormat(this.getPattern());
		return format.format(column);
	}
}
