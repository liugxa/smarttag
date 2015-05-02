package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.Input;

public class RadioColumnDecorate extends DefaultColumnDecorate{

	public RadioColumnDecorate(){}
	
	public String decorate(Integer index , Object bean , String columnName) throws Exception {
		Object columnValue = this.getColumnValue(bean, columnName);
		Input radio = new Input();
		radio.setType("radio");
		
		radio.setName("st_radios");
		radio.setID("st_radio_" + index);
		radio.setValue(columnValue.toString());

		radio.setOnClick("st_radio_onclick(this , " + index + ")");
		return radio.toString();
	}
}
