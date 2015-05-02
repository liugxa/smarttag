package com.platform.gui.framework.smart.inter.impl.item;

import org.apache.ecs.html.Div;
import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;

public class TimeItemDecorate extends DefaultItemDecorate{
	
	private String parameters;
	
	public TimeItemDecorate(String parameters){
		this.parameters = parameters;
	}
	
	public String decorate(Integer index, FilterData filterData, DataItem item) throws Exception {
		Div div = new Div();
		Input input = new Input();
		input.setID("st_time_" + index);
		input.setName("filterData.items[" + index + "].value");
		input.setReadOnly(true);
		input.setClass("timeInput");
		input.setType("text");
		div.addElement(input);
		
		Div img = new Div();
		img.setID("st_time_" + index + "_i");
		img.setClass("timeImage");
		img.setOnClick("return showCalendar('" + "st_time_" + index + "' , '" + this.parameters + "' , true , true , 'BR')");
		div.addElement(img);
		
		return this.addHiddenValues(index, item) + div.toString();
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
