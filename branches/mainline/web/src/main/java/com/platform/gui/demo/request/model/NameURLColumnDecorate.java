package com.platform.gui.demo.request.model;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ecs.html.A;

import com.platform.gui.framework.smart.inter.impl.URLColumnDecorate;

public class NameURLColumnDecorate extends URLColumnDecorate{
	
	public NameURLColumnDecorate(String link){
		super(link);
	}
	
	public String decorate(Integer index , Object bean , String columnName) throws Exception {
		String primaryValue = BeanUtils.getProperty(bean, "id");
		Object columnValue = this.getColumnValue(bean, columnName);
		
		String href = "#";
		if(this.getLink().indexOf("?") != -1){
			href = this.getLink() + "&" + "id=" + primaryValue + "&" + columnName + "=" + columnValue;
		}else{
			href = this.getLink() + "?" + "id=" + primaryValue + "&" + columnName + "=" + columnValue;
		}
		A a = new A();
		a.setHref(href);
		a.setTagText(columnValue + "");
		return a.toString();
	}

}
