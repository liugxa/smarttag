package com.platform.gui.framework.smart.inter.impl;

import java.net.URLEncoder;

import org.apache.ecs.html.A;

import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.TableContext;
import com.platform.gui.framework.smart.util.StringEscape;

public class URLColumnDecorate extends DefaultColumnDecorate{
	
	public URLColumnDecorate(){}
	
	public URLColumnDecorate(String parameters){
		super(parameters);
	}
	
	public String decorate(TableContext context , Integer index , Object bean , DataColumn column) throws Exception {
		String columnName = column.getName();
		Object obj = this.getColumnKeyValue(bean, column);
		
		String columnValue = "";
		if(obj != null) columnValue = obj.toString();
		
		String href = "#";
		if(this.parameters != null && !this.parameters.equals("")){
			href = this.eval(this.parameters , bean);
		
			if(href.indexOf("?") != -1){
				href = href + "&" + columnName + "=" + URLEncoder.encode(columnValue , "UTF-8");
			}else{
				href = href + "?" + columnName + "=" + URLEncoder.encode(columnValue , "UTF-8");
			}
		}
		
		A a = new A();
		a.setHref(href);
		
		Boolean escape = column.getEscape();
		String text = columnValue;
		
		if(escape == true) text = StringEscape.escapeHtml(columnValue);
		a.setTagText(StringEscape.escapeWhitspace(text));
		
		return a.toString();
	}
}
