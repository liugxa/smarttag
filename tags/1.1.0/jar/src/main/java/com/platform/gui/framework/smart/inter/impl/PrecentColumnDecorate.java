package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.Div;

public class PrecentColumnDecorate extends DefaultColumnDecorate{
	
	/**
	 * Decorate column value
	 * @param columnValue
	 * @return
	 */
	public String decorate(Object bean , String columnName) throws Exception{
		Div div = new Div();
		div.setStyle("width:60px; height:8px;border:1px solid #CCC;");
		
		Div div0 = new Div();
		Object columnValue = this.getColumnValue(bean, columnName);
		div0.setStyle("width:" + columnValue + "%; height:100%;background:green");
		
		div.addElement(div0);
		return div.toString();
	}
}
