package com.platform.gui.framework.smart.inter.impl;

import java.text.SimpleDateFormat;

import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;

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
	public DateColumnDecorate(String parameters){
		super(parameters);
	}
	
	/**
	 * Decorate column value
	 * @param columnValue
	 * @return
	 */
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat(parameters);

		Object columnValue = this.getColumnKeyValue(bean, column);
		return format.format(columnValue);
	}
}
