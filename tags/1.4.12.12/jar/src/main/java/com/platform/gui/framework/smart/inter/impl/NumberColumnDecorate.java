package com.platform.gui.framework.smart.inter.impl;

import java.text.NumberFormat;

import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;

public class NumberColumnDecorate extends DefaultColumnDecorate{
	
	public NumberColumnDecorate(){}
	
	public NumberColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception {
		Object columnValue = this.getColumnKeyValue(bean, column);
		return NumberFormat.getInstance().format(columnValue);
	}
}
