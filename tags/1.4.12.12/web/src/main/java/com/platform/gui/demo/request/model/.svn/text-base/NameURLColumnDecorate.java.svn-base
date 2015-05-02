package com.platform.gui.demo.request.model;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ecs.html.A;

import com.platform.gui.framework.smart.inter.impl.URLColumnDecorate;
import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;

public class NameURLColumnDecorate extends URLColumnDecorate{
	
	public NameURLColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception {
		String columnName = column.getName();
		String primaryValue = BeanUtils.getProperty(bean, "id");
		Object columnValue = this.getColumnKeyValue(bean, column);
		
		String href = "#";
		if(parameters.indexOf("?") != -1){
			href = parameters + "&" + "id=" + primaryValue + "&" + columnName + "=" + columnValue;
		}else{
			href = parameters + "?" + "id=" + primaryValue + "&" + columnName + "=" + columnValue;
		}
		A a = new A();
		a.setHref(href);
		a.setTagText(columnValue + "");
		return a.toString();
	}

}
