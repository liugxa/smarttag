package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.model.SmartButton;


public class SmartButtonTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String label;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		SmartButton button = new SmartButton();
		button.setLabel(label);
		button.setName(name);
		
		SmartSectionTag parent = (SmartSectionTag)this.getParent();
		parent.setButton(button);
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
