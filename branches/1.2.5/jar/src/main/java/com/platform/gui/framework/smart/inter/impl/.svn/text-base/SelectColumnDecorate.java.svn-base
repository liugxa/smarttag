package com.platform.gui.framework.smart.inter.impl;

import java.util.Iterator;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.ecs.html.Option;
import org.apache.ecs.html.Select;

import com.platform.gui.framework.smart.model.DataColumn;

public class SelectColumnDecorate extends DefaultColumnDecorate{
	
	public SelectColumnDecorate(String parameters){
		super(parameters);
	}
	
	@SuppressWarnings("unchecked")
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		Select select = new Select();
		select.setOnChange("st_select_onChange(this," + JSONSerializer.toJSON(bean) + ")");
		
		JSONObject obj = this.getJsonValues(parameters);
		if(obj != null){
			Iterator iterator  = obj.keys();
			while(iterator.hasNext()){
				Object key = iterator.next();
				Object value = obj.get(key);
				
				Option option = new Option();
				option.setValue(key.toString());
				option.setTagText(value.toString());

				select.addElement(option);
			}
        }
		return select.toString();
	}
		
	public JSONObject getJsonValues(String parameters){
		JSONObject obj = null;
		if(parameters != null) obj = JSONObject.fromObject(parameters);
		
		return obj;
	}
}
