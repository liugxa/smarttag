package com.platform.gui.framework.smart.inter.impl;

import java.lang.reflect.Field;
import java.util.Date;

import com.platform.gui.framework.smart.inter.IColumnDecorate;

public class ColumnDecorateFactory {

	/**
	 * Get the decorate of the bean by its date type.
	 * @param bean
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static IColumnDecorate getDecorateByType(Class beanClass , String columnName , String parameters){
		//get he default decorate by the column type.
		IColumnDecorate decorate = new DefaultColumnDecorate();
		
		try{
			//get the decorate by the data type
			Field field = beanClass.getDeclaredField(columnName);
			Class property = field.getType();
			if(property.isAssignableFrom(Date.class)){
				decorate = new DateColumnDecorate(parameters);
			}
			else if(property.isAssignableFrom(Number.class)){
				decorate = new NumberColumnDecorate(parameters);
			}
		}catch(Exception e){
			//forgot it!
		}
		return decorate;
	}
}
