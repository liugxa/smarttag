package com.platform.gui.framework.smart.inter.impl.item;

import java.util.Iterator;

import net.sf.json.JSONObject;

import org.apache.ecs.html.Div;
import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;

public class RadioItemDecorate extends SelectItemDecorate{

	public RadioItemDecorate(String parameters) {
		super(parameters);
	}

	@SuppressWarnings("unchecked")
	public String decorate(Integer index , FilterData filterData , DataItem item) throws Exception{
		Div div = new Div();
		
		JSONObject obj = this.getJsonValues(parameters);
		if(obj != null){
			Iterator iterator  = obj.keys();
			while(iterator.hasNext()){
				Object key = iterator.next();
				Object value = obj.get(key);
				
				Input radio = new Input();
				radio.setName("filterData.items[" + index + "].value");
				radio.setType("radio");
				radio.setTagText(value.toString());
				radio.setValue(key.toString());
				radio.setChecked(this.isSelected(filterData, item, key));
				div.addElement(radio);
			}
		}
		return this.addHiddenValues(index, item) + div.toString();
	}
}
