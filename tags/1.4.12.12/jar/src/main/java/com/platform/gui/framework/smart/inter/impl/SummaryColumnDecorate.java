package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.A;
import org.apache.ecs.html.Div;

import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;

public class SummaryColumnDecorate extends DefaultColumnDecorate{
	
	public SummaryColumnDecorate(){}
	
	public SummaryColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception {
		String formName = context.getName();
		Integer length = Integer.parseInt(parameters);
		
		String value = super.decorate(context , index, bean, column);
		if(value.length() > length){
			String summary = value.substring(0 , length);
	
			A m = new A();
			m.setHref("javascript:void(0);");
			m.setOnClick("st_summary_onClick('" + formName + "' , '" + index + "' , 'more');");
			m.setTagText("[more]");
			
			Div s = new Div();
			s.setID("st_summary_s_" + index + "_" + formName);
			s.setTagText(summary + "... " + m.toString());
			s.setStyle("overflow:visible");
			
			A l = new A();
			l.setHref("javascript:void(0);");
			l.setOnClick("st_summary_onClick('" + formName + "' , '" + index + "' , 'less');");
			l.setTagText("[less]");
			
			Div c = new Div();
			c.setID("st_summary_c_" + index + "_" + formName);
			c.setTagText(value + " " + l.toString());
			c.setStyle("overflow:visible;display:none");
			
			return s.toString() + c.toString();
		}else{
			return value;
		}
	}
}