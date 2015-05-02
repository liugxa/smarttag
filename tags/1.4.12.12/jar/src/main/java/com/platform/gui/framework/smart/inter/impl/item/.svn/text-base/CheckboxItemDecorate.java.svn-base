package com.platform.gui.framework.smart.inter.impl.item;

import java.util.Iterator;

import net.sf.json.JSONObject;

import org.apache.ecs.html.Div;
import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.TableContext;

public class CheckboxItemDecorate extends SelectItemDecorate{

	public CheckboxItemDecorate() {}
	
	public CheckboxItemDecorate(String parameters) {
		super(parameters);
	}

	@SuppressWarnings("unchecked")
	public String decorate(TableContext context , Integer index , FilterData filterData , DataItem item) throws Exception{
		Div div = new Div();
		
		JSONObject obj = this.getJsonValues(parameters);
		if(obj != null){
			Iterator iterator  = obj.keys();
			while(iterator.hasNext()){
				Object key = iterator.next();
				Object value = obj.get(key);
				
				Input checkbox = new Input();
				checkbox.setName("filterData.items[" + index + "].value");
				checkbox.setType("checkbox");
				
				checkbox.setTagText(this.getText(context , value.toString()));
				checkbox.setValue(key.toString());
				
				checkbox.setChecked(this.isSelected(filterData, item, key));
				div.addElement(checkbox);
			}
		}
		return this.addHiddenValues(index, item) + div.toString();
	}
}