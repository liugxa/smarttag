package com.platform.gui.framework.smart.inter.impl;

import org.apache.ecs.html.A;
import org.apache.ecs.html.Div;

import com.platform.gui.framework.smart.model.DataColumn;

public class SummaryColumnDecorate extends DefaultColumnDecorate{
	
	private Integer length;

	public SummaryColumnDecorate(){}
	
	public SummaryColumnDecorate(String parameters){
		this.length = Integer.parseInt(parameters);
	}
	
	public String decorate(Integer index , Object bean , DataColumn column) throws Exception {
		String value = super.decorate(index, bean, column);
		if(value.length() > length){
			String summary = value.substring(0 , length);
	
			A m = new A();
			m.setHref("javascript:void(0);");
			m.setOnClick("st_summary_onClick('" + index + "' , 'more');");
			m.setTagText("[more]");
			
			Div s = new Div();
			s.setID("st_summary_s_" + index);
			s.setTagText(summary + "...... " + m.toString());
			s.setStyle("overflow:visible");
			
			A l = new A();
			l.setHref("javascript:void(0);");
			l.setOnClick("st_summary_onClick('" + index + "' , 'less');");
			l.setTagText("[less]");
			
			Div c = new Div();
			c.setID("st_summary_c_" + index);
			c.setTagText(value + " " + l.toString());
			c.setStyle("overflow:visible;display:none");
			
			return s.toString() + c.toString();
		}else{
			return value;
		}
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
}