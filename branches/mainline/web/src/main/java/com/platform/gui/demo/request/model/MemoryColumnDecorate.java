package com.platform.gui.demo.request.model;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ecs.html.Div;

import com.platform.gui.framework.smart.inter.impl.DefaultColumnDecorate;

public class MemoryColumnDecorate extends DefaultColumnDecorate{

	public String decorate(Integer index, Object bean , String columnName) throws Exception {
		if(index > 3){
			Div div0 = new Div();
			div0.setStyle("width:100px; height:8px;border:1px solid #CCC;");
			
			Div div1 = new Div();
			div1.setStyle("width:" + this.getColumnValue(bean, columnName) + "%; height:100%;background:green");
			
			div0.addElement(div1);
			return div0.toString();
		}else{
			return this.getColumnValue(bean, columnName) + "%";
		}
	}

}
