package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.A;

public class URLColumnDecorate extends DefaultColumnDecorate{

	private String link;
	
	public URLColumnDecorate(String link){
		this.link = link;
	}
	
	public String decorate(Object column) throws Exception {
		A a = new A();
		a.setHref(link);
		a.setTagText(column.toString());
		return a.toString();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
