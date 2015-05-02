package com.platform.gui.framework.smart.inter.impl;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;
import com.platform.gui.framework.smart.util.StringEscape;

public class DefaultColumnDecorate implements IColumnDecorate{
	
	private Logger logger = Logger.getLogger(DefaultColumnDecorate.class);
	
	protected String parameters;

	public DefaultColumnDecorate(){}
	
	public DefaultColumnDecorate(String parameters){
		this.parameters = parameters;
	}
	
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception {
		String value = "-";
		
		Object obj = this.getColumnKeyValue(bean, column);
		if(obj != null) value = obj.toString();
		
		Boolean escape = column.getEscape();
		if(escape != null && escape == true) value = StringEscape.escapeHtml(value);
		return (value.equals(""))?"-":StringEscape.escapeWhitspace(value);
	}
	
	
	/**
	 * Escape the value include the white space.
	 * @param escape
	 * @param s
	 * @return
	 */
	public String escape(Boolean escape , String s){
		if(escape == true) s = StringEscape.escapeHtml(s);
		return StringEscape.escapeWhitspace(s);
	}
	
	
	/**
	 * Get the column value. If the key has been set, return the bean value by its key, Otherwise, by its name.
	 * @param bean
	 * @param column
	 * @return
	 * @throws Exception
	 */
	public Object getColumnKeyValue(Object bean , DataColumn column) throws Exception{
		String key = column.getKey();
		String name = column.getName();
		
		Object obj = null;
		if(key != null){
			obj = this.getColumnValue(bean, key);
		}else{
			obj = this.getColumnValue(bean, name);
		}
		return obj;
	}
	
	/**
	 * The smart tag support the define the 'express' in the "parameters" property. and it analysis the express 
	 * just like the OGNL does.
	 * @param str
	 * @param bean
	 * @return
	 * @throws Exception
	 */
	public String eval(String str , Object bean) throws Exception{
		StringBuffer buffer = new StringBuffer();
		Matcher matcher = Pattern.compile("#\\{(\\w*)\\}").matcher(str);
		while(matcher.find()){
			String name = matcher.group(1);
			try{
				Object value = BeanUtils.getProperty(bean, name);
				matcher.appendReplacement(buffer , value.toString());
			}catch(NoSuchMethodException e){
				//if can not found this property, ignore it!
				logger.error("can not found the property [" + name + "] from the bean");
			}
		}
		matcher.appendTail(buffer);
		return (buffer.length() == 0 ) ? str : buffer.toString();
	}
	
	/**
	 * The smart tag support the define the 'express' in the "name" property. and it analysis the express 
	 * just like the OGNL does.
	 * @param name
	 * @param index
	 * @return
	 * @throws Exception
	 */
	public String eval(String name , Integer index) throws Exception{
		String r = null;
		Matcher matcher = Pattern.compile("#\\{(index)\\}").matcher(name);
		
		r = matcher.replaceAll(index + "");
		return (r == null) ? name : r;
		
	}
	
	/**
	 * Get the column value by the column name. it will return the object by use the PropertyUtils class
	 * @param bean
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public Object getColumnValue(Object bean , String columnName) throws Exception{
		return PropertyUtils.getProperty(bean, columnName);
	}
	
	/**
	 * I18N help method to get the text value from the properties file.
	 * @param context
	 * @param key
	 * @return
	 */
	public String getText(TableContext context , String key){
		String r = key;
		ResourceBundle resource = context.getResource();
		
		try{
			if(resource != null) r = resource.getString(key);
		}catch(Exception e){
			//ignore it!
		}
		return r;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
