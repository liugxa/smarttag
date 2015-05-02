package com.platform.gui.framework.smart.inter.impl;

import org.apache.commons.beanutils.PropertyUtils;

import com.platform.gui.framework.smart.inter.IColumnDecorate;

public class DefaultColumnDecorate implements IColumnDecorate{
	
	public String decorate(Integer index , Object bean , String columnName) throws Exception {
		String value = "-";
		Object obj = this.getColumnValue(bean, columnName);
		if(obj != null) value = obj.toString();
		return value;
	}
	
	public Object getColumnValue(Object bean , String columnName) throws Exception{
		return PropertyUtils.getProperty(bean, columnName);
	}
}
