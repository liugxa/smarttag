package com.platform.gui.framework.smart.inter.impl;

import java.lang.reflect.Field;
import java.util.Date;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;

public class ColumnDecorateFactory {

	/**
	 * Get the decorate of the bean by its date type.
	 * @param bean
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static IColumnDecorate getDecorateByType(Class beanClass , DataColumn column){
		String columnName = column.getName();
		//get he default decorate by the column type.
		IColumnDecorate decorate = new DefaultColumnDecorate();
		
		try{
			//get the decorate by the data type
			Field field = beanClass.getDeclaredField(columnName);
			Class property = field.getType();
			if(property.isAssignableFrom(Date.class)){
				decorate = new DateColumnDecorate();
			}
			else if(property.isAssignableFrom(Number.class)){
				decorate = new NumberColumnDecorate();
			}
		}catch(Exception e){
			//forgot it!
		}
		return decorate;
	}
}
