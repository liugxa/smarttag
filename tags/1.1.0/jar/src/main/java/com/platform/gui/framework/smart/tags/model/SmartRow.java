package com.platform.gui.framework.smart.tags.model;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.inter.IColumnDecorate;

public class SmartRow {
	
	private boolean isChecked;
	
	/* The object which be decorated by use table */
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

	public boolean getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public String getColumnValue(SmartCell cell) throws Exception{
		//get cell's decorate and decorate the value
		IColumnDecorate decorate = cell.getColumnDecorate();
		return decorate.decorate(obj , cell.getName());
	}
	
	public String getPrimaryValue(String primaryKey) throws Exception{
		return BeanUtils.getProperty(obj , primaryKey);
	}
}
