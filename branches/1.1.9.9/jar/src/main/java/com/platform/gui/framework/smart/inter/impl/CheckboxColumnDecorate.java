package com.platform.gui.framework.smart.inter.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataColumn;

public class CheckboxColumnDecorate extends DefaultColumnDecorate{

	public CheckboxColumnDecorate(){}
	
	public CheckboxColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		String columnName = column.getName();
		Object columnValue = this.getColumnKeyValue(bean, column);
		Input checkbox = new Input();
		checkbox.setType("checkbox");
		
		checkbox.setName(columnName);
		checkbox.setID("st_checkbox_" + index);
		checkbox.setValue(columnValue.toString());
		
		checkbox.setChecked(this.isChecked(columnValue.toString()));
		checkbox.setOnClick("st_checkbox_onClick(this," + JSONSerializer.toJSON(bean) + ");st_checkbox_onClick_after(this," + JSONSerializer.toJSON(bean) + ");");
		
		return checkbox.toString();
	}
	
	private boolean isChecked(String columnValue){
		boolean checked = false;
		if(parameters != null && !parameters.trim().equals("")){
			//transfer the parameters to List<String>
			JSONArray array = JSONArray.fromObject(parameters);
			if(array.contains(columnValue)) checked = true;
		}
		return checked;
	}
}
