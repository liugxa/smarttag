package com.platform.gui.framework.smart.inter.impl.item;

import org.apache.ecs.html.Div;
import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.TableContext;

public class TimeItemDecorate extends DefaultItemDecorate{
	
	public TimeItemDecorate(){}
	
	public TimeItemDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(TableContext context , Integer index, FilterData filterData, DataItem item) throws Exception {
		String formName = context.getName();
		
		Div div = new Div();
		Input input = new Input();
		input.setID("st_time_" + index + "_" + formName);
		input.setName("filterData.items[" + index + "].value");
		input.setReadOnly(true);
		input.setClass("timeInput");
		input.setType("text");
		div.addElement(input);
		
		Div img = new Div();
		img.setID("st_time_" + index + "_" + formName + "_i");
		img.setClass("timeImage");
		img.setOnClick("return showCalendar('" + "st_time_" + index + "_" + formName + "' , '" + this.parameters + "' , '24' , true)");
		div.addElement(img);
		
		return this.addHiddenValues(index, item) + div.toString();
	}
}
