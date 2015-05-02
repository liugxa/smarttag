package com.platform.gui.framework.smart.inter.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONSerializer;

import org.apache.ecs.html.Option;
import org.apache.ecs.html.Select;

public class SelectColumnDecorate extends DefaultColumnDecorate{

	private String value;
	
    private Map<String , String> options;

	public SelectColumnDecorate(){}
	
	public SelectColumnDecorate(String value , Map<String , String> options){
		this.value = value;
        this.options = options;
	}
	
	public String decorate(Integer index , Object bean , String columnName) throws Exception {
		Select select = new Select();
		select.setOnChange("st_select_onChange(this," + JSONSerializer.toJSON(bean) + ")");
		
        Set<String> keys = options.keySet();
        Iterator<String> iter = keys.iterator();
        while(iter.hasNext()){
            String k = iter.next();
            String v = options.get(k);

            Option option = new Option();
            option.setValue(k);
            option.setTagText(v);
            
            if(k.equals(value)) option.setSelected(true);
            select.addElement(option);
        }
		return select.toString();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getOptions() {
		return options;
	}

	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
}
