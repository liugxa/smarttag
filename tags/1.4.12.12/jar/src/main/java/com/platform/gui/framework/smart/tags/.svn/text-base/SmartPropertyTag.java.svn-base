package com.platform.gui.framework.smart.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts2.views.jsp.TagUtils;

import com.opensymphony.xwork2.util.ValueStack;
import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.util.StringEscape;

public class SmartPropertyTag extends  TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private String value;
	
	private Boolean escape = true;
	
	public int doStart() throws JspException {
		return EVAL_BODY_INCLUDE;
	}
	public int doEndTag() throws JspException {
		try {
			ValueStack stack = TagUtils.getStack(pageContext);
			String s = this.findValue(stack, value);
			if(s != null) pageContext.getOut().write(s);
		} catch (IOException e) {
			throw new SmartTagException(e);
		}
		return EVAL_PAGE;
	}
	
	public String findValue(ValueStack stack , String value) {
		String r = null;
		
		// the same logic as with findValue(String)
		//if value start with %{ and end with }, just cut it off!
		if (value.startsWith("%{") && value.endsWith("}")) {
			value = value.substring(2, value.length() - 1);
		}

		// exception: don't call findString(), since we don't want the
		// expression parsed in this one case. it really
		// doesn't make sense, in fact.
		String actualValue = (String) stack.findValue(value, String.class);
		if (actualValue != null) r = actualValue;
		
		// escape the value
		if(r != null){
			if(escape) r = StringEscape.escapeHtml(r);
			r = StringEscape.escapeWhitspace(r);
		}
		return r;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Boolean getEscape() {
		return escape;
	}
	
	public void setEscape(Boolean escape) {
		this.escape = escape;
	}
}
