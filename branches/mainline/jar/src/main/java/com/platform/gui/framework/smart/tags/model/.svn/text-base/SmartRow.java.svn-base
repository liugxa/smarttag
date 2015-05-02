package com.platform.gui.framework.smart.tags.model;

import net.sf.json.JSONSerializer;

import com.platform.gui.framework.smart.inter.IColumnDecorate;

public class SmartRow{
	
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

	public String getColumnValue(Integer index , SmartCell cell) throws Exception{
		//get cell's decorate and decorate the value
		IColumnDecorate decorate = cell.getColumnDecorate();
		return decorate.decorate(index , obj , cell.getName());
	}
	
	public String toJson() throws Exception{
		return JSONSerializer.toJSON(obj).toString();
	}	
}
