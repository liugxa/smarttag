package com.platform.gui.demo.request.model;

import org.apache.ecs.html.Div;

import com.platform.gui.framework.smart.inter.impl.IColumnDecorate;

public class MemoryColumnDecorate implements IColumnDecorate{

	public String decorate(Object column) throws Exception {
		
		Div div0 = new Div();
		div0.setStyle("width:100px; height:8px;border:1px solid #CCC;");
		
		Div div1 = new Div();
		div1.setStyle("width:" + column + "%; height:100%;background:green");
		
		div0.addElement(div1);
		return div0.toString();
	}

}
