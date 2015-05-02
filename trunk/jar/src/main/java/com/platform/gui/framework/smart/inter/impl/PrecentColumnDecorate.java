package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.Div;

import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;

public class PrecentColumnDecorate extends DefaultColumnDecorate{
	
	public PrecentColumnDecorate(){}
	
	public PrecentColumnDecorate(String parameters){
		super(parameters);
	}
	
	/**
	 * Decorate column value
	 * @param columnValue
	 * @return
	 */
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception{
		Div div = new Div();
		div.setStyle("width:60px; height:8px;border:1px solid #CCC;");
		
		Div div0 = new Div();
		Object columnValue = this.getColumnKeyValue(bean, column);
		div0.setStyle("width:" + columnValue + "%; height:100%;background:green");
		
		div.addElement(div0);
		return div.toString();
	}
}
