package com.platform.gui.framework.smart.inter.impl;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringEscapeUtils;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;

public class DefaultColumnDecorate implements IColumnDecorate{
	
	protected String parameters;

	public DefaultColumnDecorate(){}
	
	public DefaultColumnDecorate(String parameters){
		this.parameters = parameters;
	}
	
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		String value = "-";
		
		Object obj = this.getColumnKeyValue(bean, column);
		if(obj != null) value = obj.toString();
		
		Boolean escape = column.getEscape();
		if(escape != null && escape == true) value = StringEscapeUtils.escapeHtml(value);
		return value;
	}
	
	public Object getColumnKeyValue(Object bean , DataColumn column) throws Exception{
		String key = column.getKey();
		String name = column.getName();
		
		Object obj = null;
		if(key != null){
			obj = this.getColumnValue(bean, key);
		}else{
			obj = this.getColumnValue(bean, name);
		}
		return obj;
	}

	public Object getColumnValue(Object bean , String columnName) throws Exception{
		return PropertyUtils.getProperty(bean, columnName);
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
