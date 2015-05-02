package com.platform.gui.framework.smart.inter.impl.item;

import java.util.Iterator;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.ecs.html.Option;
import org.apache.ecs.html.Select;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.TableContext;

public class SelectItemDecorate extends DefaultItemDecorate{
	
	public SelectItemDecorate(){}
	
	public SelectItemDecorate(String parameters){
		super(parameters);
	}
	
	@SuppressWarnings("unchecked")
	public String decorate(TableContext context , Integer index , FilterData filterData , DataItem item) throws Exception {
		String formName = context.getName();
		Select select = new Select();
		select.setName("filterData.items[" + index + "].value");
		
		//change parameters to hash map
		//transfer the parameters to List<JSONObject>
		JSONObject obj = this.getJsonValues(parameters);
		if(obj != null){
			Iterator iterator  = obj.keys();
			while(iterator.hasNext()){
				Object key = iterator.next();
				Object value = obj.get(key);
	
				Option option = new Option();
				option.setValue(key.toString());
				
				option.setTagText(this.getText(context , value.toString()));
				option.setSelected(this.isSelected(filterData, item , key));
				
				select.addElement(option);
			}
		}
		
		//set select onChange event
		select.setOnChange("st_filter_select_onChange('" + formName + "' , this , " + JSONSerializer.toJSON(item) +")");
		return this.addHiddenValues(index, item) + select.toString();
	}

	public boolean isSelected(FilterData filterData , DataItem item , Object key) throws Exception{
		boolean r = false;
		Object value = this.getItemKeyValue(filterData, item);
		
		if(value != null && value.toString().equals(key.toString())) r = true;
		return r;
	}
	
	public JSONObject getJsonValues(String parameters){
		JSONObject obj = null;
		if(parameters != null) obj = JSONObject.fromObject(parameters);
		
		return obj;
	}
}
