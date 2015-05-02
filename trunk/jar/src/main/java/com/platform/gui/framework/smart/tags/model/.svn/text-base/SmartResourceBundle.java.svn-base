package com.platform.gui.framework.smart.tags.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class SmartResourceBundle extends ResourceBundle{

	private ResourceBundle bundle;

	public SmartResourceBundle(String resource , Locale locale){
		try{	 
			parent = ResourceBundle.getBundle("smart-global" , Locale.ENGLISH);
			bundle = ResourceBundle.getBundle(resource , locale , Thread.currentThread().getContextClassLoader());
		}catch(Exception e){
			//if can not find the resource bundle. forgot it.
		}
	}
	
	@Override
	public Enumeration<String> getKeys() {
		List<String> keys = new ArrayList<String>();
		
		if(bundle != null){
			Enumeration<String> ks1 = bundle.getKeys();
			while(ks1.hasMoreElements()){
				String key = ks1.nextElement(); 
				keys.add(key);
			}
		}
		
		if(parent != null){
			Enumeration<String> ks1 = bundle.getKeys();
			while(ks1.hasMoreElements()){
				String key = ks1.nextElement();
				keys.add(key);
				//for(String pk:parent.keySet()) keys.add(pk);
			}
		}
		return Collections.enumeration(keys);
	}

	@Override
	protected Object handleGetObject(String key) {
		Object obj = null;
		try{
			if(bundle != null) obj = bundle.getObject(key);
		}catch(Exception e){
			//forgot it
		}
		return obj;
	}
	
	public String getText(String key){
		//get the property value from the bundle
		String value = this.getString(bundle, key);
		if(value == null){
			value = this.getString(parent, key);
		}

		if(value == null) value = key;
		return value;
	}

	private String getString(ResourceBundle bundle , String key){
		String value = null;
		if(bundle != null){
			try{
				value = bundle.getString(key);
			}catch(Exception e){
				//forgot it
			}
		}
		return value;
	}
}
