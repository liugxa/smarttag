package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.inter.impl.SelectColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartOption;

public class SmartRowActionTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	/* action name */
	private String name;
	
	private String label;
	
	private Boolean disable;
	
	/*
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
		SmartCell actionCell = new SmartCell();
		actionCell.setName(name);
		actionCell.setLabel(label);
		actionCell.setDisable(disable);
		
		Map<String,String> parameters = new LinkedHashMap<String,String>();
		for(SmartOption option:options){
			parameters.put(option.getName(), option.getLabel());
		}
		actionCell.setColumnDecorate(new SelectColumnDecorate(parameters));
		
		//add it to its parent cell list
		SmartTableGridTag parent = (SmartTableGridTag)this.getParent();
		parent.getCells().add(actionCell);
		return EVAL_PAGE;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
	
	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
}
