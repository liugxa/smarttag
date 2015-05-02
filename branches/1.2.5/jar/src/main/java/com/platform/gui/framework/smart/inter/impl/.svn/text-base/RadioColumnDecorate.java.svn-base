package com.platform.gui.framework.smart.inter.impl;

import net.sf.json.JSONArray;
import net.sf.json.JSONSerializer;

import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataColumn;

public class RadioColumnDecorate extends DefaultColumnDecorate{

	public RadioColumnDecorate(){}
	
	public RadioColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		String columnName = column.getName();
		Object columnValue = this.getColumnKeyValue(bean, column);
		
		Input radio = new Input();
		radio.setType("radio");
		
		radio.setName(columnName);
		radio.setID("st_radio_" + index);
		radio.setValue(columnValue.toString());

		radio.setChecked(this.isChecked(columnValue.toString()));
		radio.setOnClick("st_radio_onClick(this , " + JSONSerializer.toJSON(bean) + ");st_radio_onClick_after(this," + JSONSerializer.toJSON(bean) + ");");
		return radio.toString();
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
