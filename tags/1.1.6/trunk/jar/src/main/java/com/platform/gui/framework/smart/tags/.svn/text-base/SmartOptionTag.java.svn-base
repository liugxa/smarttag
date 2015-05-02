package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.model.SmartOption;

public class SmartOptionTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String label;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		SmartRowActionTag parent = (SmartRowActionTag)this.getParent();
		parent.getOptions().add(new SmartOption(name , label));
		return EVAL_PAGE;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
