package com.platform.gui.framework.smart.tags.model;

import net.sf.json.JSONSerializer;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;

public class SmartRow {
	
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
		DataColumn column = new DataColumn();
		BeanUtils.copyProperties(column , cell);
		
		IColumnDecorate decorate = cell.getColumnDecorate();
		return decorate.decorate(index , obj , column);
	}
	
	public String toJson() throws Exception{
		return JSONSerializer.toJSON(obj).toString();
	}	
}
