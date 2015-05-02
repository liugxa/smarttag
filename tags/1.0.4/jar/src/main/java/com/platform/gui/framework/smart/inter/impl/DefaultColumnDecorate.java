package com.platform.gui.framework.smart.inter.impl;

import org.apache.commons.beanutils.PropertyUtils;

import com.platform.gui.framework.smart.inter.IColumnDecorate;

public class DefaultColumnDecorate implements IColumnDecorate{
	
	public String decorate(Object bean , String columnName) throws Exception {
		return this.getColumnValue(bean, columnName).toString();
	}
	
	public Object getColumnValue(Object bean , String columnName) throws Exception{
		return PropertyUtils.getProperty(bean, columnName);
	}
}
