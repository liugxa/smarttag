package com.platform.gui.framework.smart.inter.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONSerializer;

import org.apache.ecs.html.Option;
import org.apache.ecs.html.Select;

public class SelectColumnDecorate extends DefaultColumnDecorate{

    private Map<String , String> options;

	public SelectColumnDecorate(){}
	
	public SelectColumnDecorate(Map<String , String> options){
        this.options = options;
	}
	
	public String decorate(Integer index , Object bean , String columnName) throws Exception {
		Select select = new Select();
		select.setOnChange("st_select_onChange(this," + JSONSerializer.toJSON(bean) + ")");
		
        Set<String> keys = options.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String key = iter.next();
            String value = options.get(key);

            Option option = new Option();
            option.setValue(key);
            option.setTagText(value);

            select.addElement(option);
        }
		return select.toString();
	}

}
