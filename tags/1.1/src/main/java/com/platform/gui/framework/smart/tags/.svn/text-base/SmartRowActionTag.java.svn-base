package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.model.SmartOption;
import com.platform.gui.framework.smart.tags.model.SmartRowAction;

public class SmartRowActionTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	/**
	 * The action list, user can define a 
	 * static values or a method which came from the action
	 */
	private List<SmartOption> options;

	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		options = new ArrayList<SmartOption>();
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		SmartRowAction rowAction = new SmartRowAction();
		rowAction.setName(name);
		rowAction.setOptions(options);
		
		//add it to its parent cell list
		SmartTableGridTag parent = (SmartTableGridTag)this.getParent();
		parent.setRowAction(rowAction);
		return EVAL_PAGE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SmartOption> getOptions() {
		return options;
	}

	public void setOptions(List<SmartOption> options) {
		this.options = options;
	}
}
