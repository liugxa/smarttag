package com.platform.gui.framework.smart.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.PageContext;

public class I18NUtil {

	public static String getCellValue(PageContext pageContext , String value){
		String resource = (String)pageContext.getAttribute("resource");
		Locale locale = pageContext.getRequest().getLocale();
		return getCellValue(locale , resource , value);
	}
	
	public static String getCellValue(Locale locale , String resourceName, String key){
		String result = key;

		if(key != null){
			int begin = key.indexOf("{");
			if(begin != -1){
				// i18n
				int end = key.lastIndexOf("}");
				String k = key.substring(begin + 1, end);
				
				result = getResourceValue(locale , resourceName , k);
			}
		}
		return result;
	}
	
	public static String getResourceValue(Locale locale , String resourceName , String key){
		String v = key;
		try{
			if(resourceName != null){
				ResourceBundle bundle = ResourceBundle.getBundle(resourceName.replace('.', '/') , locale);
				v = getCellValue(bundle , key);
				if(v == null){
					//can not find the property in the resource file.
					ResourceBundle defaultBundle = ResourceBundle.getBundle("application");
					v = defaultBundle.getString(key);
				}
				if(v == null) v = key;					
			}else{
				//can not find the property in the resource file.
				ResourceBundle defaultBundle = ResourceBundle.getBundle("application" , Locale.ENGLISH);
				v = defaultBundle.getString(key);
				if(v == null) v = key;					
			}
		}catch(Exception e){
			
		}
		return v;
	}
	
	private static String getCellValue(ResourceBundle bundle, String key){
		String value = null;
		try{
			value = bundle.getString(key);
		}catch(Exception e){
			//can not find the property in the resource file.
		}
		return value;
	}
}
