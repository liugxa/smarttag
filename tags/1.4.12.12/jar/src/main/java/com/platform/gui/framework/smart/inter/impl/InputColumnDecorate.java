package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;

public class InputColumnDecorate extends DefaultColumnDecorate{
	
	public InputColumnDecorate(){}
	
	public InputColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception {
		String columnName = column.getName();
		Object columnValue = this.getColumnKeyValue(bean, column);
		
		Input input = new Input();
		input.setType("text");
		
		input.setName(this.eval(columnName, index));
		input.setID("st_input_" + index);
		input.setValue(columnValue.toString());

		return input.toString();
	}

}
