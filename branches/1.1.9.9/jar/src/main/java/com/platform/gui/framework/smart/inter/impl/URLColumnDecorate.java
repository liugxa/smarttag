package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.A;

import com.platform.gui.framework.smart.model.DataColumn;

public class URLColumnDecorate extends DefaultColumnDecorate{
	
	private String link;
	
	public URLColumnDecorate(String link){
		this.link = link;
	}
	
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		String columnName = column.getName();
		String href = "#";
		Object columnValue = this.getColumnKeyValue(bean, column);
		
		if(link.indexOf("?") != -1){
			href = link + "&" + columnName + "=" + columnValue;
		}else{
			href = link + "?" + columnName + "=" + columnValue;
		}
		
		A a = new A();
		a.setHref(href);
		a.setTagText(columnValue + "");
		return a.toString();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
