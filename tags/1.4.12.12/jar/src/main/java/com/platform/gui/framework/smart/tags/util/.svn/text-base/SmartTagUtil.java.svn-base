package com.platform.gui.framework.smart.tags.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.util.MakeIterator;

import com.opensymphony.xwork2.util.TextParseUtil;
import com.opensymphony.xwork2.util.ValueStack;

public class SmartTagUtil {
	
	public static Map<String,String> findListValue(ValueStack stack , String list , String listKey , String listValue) throws Exception{
		Map<String,String> map = new LinkedHashMap<String,String>();
		Object value = findValue(stack, list);
		
		if(value instanceof Map){
			Set keySet = ((Map) value).keySet();
			for(Object k:keySet){
				Object v = ((Map)value).get(k);
				map.put(k.toString(), v.toString());
			}
		}else{
			if(MakeIterator.isIterable(value)){
				value = MakeIterator.convert(value);
			}
			
			Iterator<?> iter = (Iterator<?>)value;
			while(iter.hasNext()){
				Object obj = iter.next();
				
				//get list key/value by 'listKey'/'listValue' property,
				//if it does not defined, append the value into map directly.
				if(listKey != null && !listKey.equals("")){
					String k = BeanUtils.getProperty(obj , listKey);
					String v = BeanUtils.getProperty(obj, listValue);
					map.put(k, v);
				}else{
					map.put(obj.toString(), obj.toString());
				}
			}
		}
		return map;
	}
	
	public static Object findValue(ValueStack stack , String expr) {
		Object r = null;
		if(expr != null) r = stack.findValue(expr);
		return r;
	}
	
	
	public static String findString(ValueStack stack , String expr) {
		String r = null;
		if(expr != null) r = TextParseUtil.translateVariables('%', expr, stack);
		return r;
	}
}
