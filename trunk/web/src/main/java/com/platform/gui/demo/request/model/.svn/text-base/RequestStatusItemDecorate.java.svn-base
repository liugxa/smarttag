package com.platform.gui.demo.request.model;

import org.apache.ecs.html.Div;
import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.inter.impl.item.DefaultItemDecorate;
import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.TableContext;

public class RequestStatusItemDecorate extends DefaultItemDecorate{

	public String decorate(TableContext context , Integer index , FilterData filterData , DataItem item) throws Exception{
		/*
		Div div = new Div();
		Input radio0 = new Input();
		radio0.setName("filterData.items[" + index + "].value");
		radio0.setType("radio");
		radio0.setTagText("Active");
		radio0.setValue("active");
		div.addElement(radio0);
		
		Input radio1 = new Input();
		radio1.setName("filterData.items[" + index + "].value");
		radio1.setType("radio");
		radio1.setTagText("Suspend");
		radio1.setValue("suspend");
		div.addElement(radio1);
		*/
		
		Div div = new Div();
		Input radio0 = new Input();
		radio0.setName("filterData.items[" + index + "].value");
		radio0.setType("checkbox");
		radio0.setTagText("Active");
		radio0.setValue("active");
		div.addElement(radio0);
		
		Input radio1 = new Input();
		radio1.setName("filterData.items[" + index + "].value");
		radio1.setType("checkbox");
		radio1.setTagText("Suspend");
		radio1.setValue("suspend");
		div.addElement(radio1);
		
		return this.addHiddenValues(index, item) + div.toString();
	}
	
}
