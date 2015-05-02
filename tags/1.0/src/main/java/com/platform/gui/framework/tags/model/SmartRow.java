package com.platform.gui.framework.tags.model;

import org.apache.commons.beanutils.PropertyUtils;

import com.platform.gui.framework.tags.decorate.IColumnDecorate;

public class SmartRow {

	/**
	 * The object which be decorated by use table
	 */
	private Object obj;
	
	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	public boolean isEnableDecorate(){
		return (obj instanceof IColumnDecorate);
	}
	
	public String getColumnValue(SmartCell cell) throws Exception{
		String cellName = cell.getName();
		Object property = PropertyUtils.getProperty(obj , cellName);
		
		//get cell's decorate and decorate the value
		IColumnDecorate decorate = cell.getColumnDecorate();
		return decorate.decorate(property);
	}
}
