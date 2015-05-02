package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataColumn;

public class RadioColumnDecorate extends DefaultColumnDecorate{

	public RadioColumnDecorate(){}
	
	public RadioColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		Object columnValue = this.getColumnKeyValue(bean, column);
		
		Input radio = new Input();
		radio.setType("radio");
		
		radio.setName("st_radios");
		radio.setID("st_radio_" + index);
		radio.setValue(columnValue.toString());

		radio.setOnClick("st_radio_onclick(this , " + index + ")");
		return radio.toString();
	}
}
