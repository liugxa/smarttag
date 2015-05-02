package com.platform.gui.framework.tags.decorate;

import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

public class ColumnDecorateFactory {

	/**
	 * Get the decorate of the bean by its date type.
	 * @param bean
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public static IColumnDecorate getDecorateFromBean(Object bean , String columnName){
		//get he default decorate by the column type.
		IColumnDecorate decorate = new DefaultColumnDecorate();
		
		try{
			//get the decorate by the data type
			Object property = PropertyUtils.getProperty(bean , columnName);
			if(property instanceof Date){
				decorate = new DateColumnDecorate();
			}
			else if(property instanceof Number){
				decorate = new NumberColumnDecorate();
			}
		}catch(Exception e){
			//forgot it!
		}
		return decorate;
	}
	
}
