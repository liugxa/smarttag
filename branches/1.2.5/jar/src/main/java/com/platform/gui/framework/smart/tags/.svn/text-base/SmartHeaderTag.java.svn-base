package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.tags.model.SmartHeader;

public class SmartHeaderTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartHeader header = new SmartHeader();
			
			// print the table header
			JspWriter writer = pageContext.getOut();
			writer.print(header.getHtml());
			return EVAL_PAGE;
		}catch(Exception e){
			throw new SmartTagException(e);
		}
	}
}
