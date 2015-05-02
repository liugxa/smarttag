package com.platform.gui.framework.smart.inter.impl;

import java.util.Iterator;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.apache.ecs.html.Option;
import org.apache.ecs.html.Select;

import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;

public class SelectColumnDecorate extends DefaultColumnDecorate{
	
	public SelectColumnDecorate(){}
	
	public SelectColumnDecorate(String parameters){
		super(parameters);
	}
	
	@SuppressWarnings("unchecked")
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception {
		String formName = context.getName();
		Select select = new Select();
		
		select.setName(this.eval(column.getName() , index));
		select.setOnChange("st_select_onChange('" + formName + "' , this," + JSONSerializer.toJSON(bean) + ")");
		
		JSONObject obj = this.getJsonValues(parameters);
		if(obj != null){
			Iterator iterator  = obj.keys();
			while(iterator.hasNext()){
				Object key = iterator.next();
				Object value = obj.get(key);
				
				Option option = new Option();
				option.setValue(key.toString());
				option.setTagText(this.getText(context , value.toString()));

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
