package com.platform.gui.demo.request.model;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ecs.html.Div;

import com.platform.gui.framework.smart.inter.impl.DefaultColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;

public class MemoryColumnDecorate extends DefaultColumnDecorate{

	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		String columnName = column.getName();
		Integer id = Integer.parseInt(BeanUtils.getProperty(bean, "id"));
		if(id > 3){
			Div div0 = new Div();
			div0.setStyle("width:100px; height:8px;border:1px solid #CCC;");
			
			Div div1 = new Div();
			div1.setStyle("width:" + this.getColumnKeyValue(bean, column) + "%; height:100%;background:green");
			
			div0.addElement(div1);
			return div0.toString();
		}else{
			return this.getColumnKeyValue(bean, column) + "%";
		}
	}

}
