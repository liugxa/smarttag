package com.platform.gui.framework.smart.inter.impl;

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
