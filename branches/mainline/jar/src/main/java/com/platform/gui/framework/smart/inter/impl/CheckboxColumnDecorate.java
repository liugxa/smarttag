package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.Input;

public class CheckboxColumnDecorate extends DefaultColumnDecorate{

	public CheckboxColumnDecorate(){}
	
	public String decorate(Integer index , Object bean , String columnName) throws Exception {
		Object columnValue = this.getColumnValue(bean, columnName);
		Input checkbox = new Input();
		checkbox.setType("checkbox");
		
		checkbox.setName(columnName + "[" + index + "]");
		checkbox.setID("st_check_" + index);
		checkbox.setValue(columnValue.toString());
		
		checkbox.setOnClick("st_check_onClick(this , " + index + ")");
		return checkbox.toString();
	}
}
