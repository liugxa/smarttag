package com.platform.gui.framework.tags.decorate;

import java.text.NumberFormat;

public class NumberColumnDecorate extends DefaultColumnDecorate{

	public NumberColumnDecorate(){
		super();
	}
	
	public NumberColumnDecorate(String pattern){
		super(pattern);
	}
	
	public String decorate(Object column) throws Exception {
		return NumberFormat.getInstance().format(column);
	}
	
}
