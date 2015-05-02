package com.platform.gui.framework.smart.inter.impl.item;

import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.TableContext;

public class InputItemDecorate extends DefaultItemDecorate{
	
	public InputItemDecorate(){}
	
	public InputItemDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(TableContext context , Integer index , FilterData filterData , DataItem item) throws Exception {
		Input input = new Input();
		input.setType("text");
		input.setName("filterData.items[" + index + "].value");
		input.setSize("15");
		input.setMaxlength("120");
		
		//set input's value
		Object value = this.getItemKeyValue(filterData, item);
		if(value != null) input.setValue(value.toString());
		
		return this.addHiddenValues(index, item) + input.toString();
	}

}
