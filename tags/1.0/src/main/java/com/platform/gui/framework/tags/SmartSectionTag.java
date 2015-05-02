package com.platform.gui.framework.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.tags.model.SmartButton;
import com.platform.gui.framework.tags.model.SmartElement;
import com.platform.gui.framework.tags.model.SmartSection;

public class SmartSectionTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	/**
	 * Display the option group's section name
	 */
	private String label;
	
	/**
	 * The filter bar will display this option groups at first time
	 */
	private String isDefault;
	
	/**
	 * The SmartFilterOption object
	 */
	private List<SmartElement> elements;
	
	/**
	 * Display a button
	 */
	private SmartButton button;

	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		
		// initialize the options/button object
		elements = new ArrayList<SmartElement>();
		button = new SmartButton();
		
		// return
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		SmartSection section = new SmartSection();
		section.setLabel(label);
		section.setButton(button);
		section.setElements(elements);
		section.setIsDefault(isDefault == "true"?true:false);
		
		SmartFilterTag parent = (SmartFilterTag)this.getParent();
		parent.getSections().add(section);
		return EVAL_PAGE;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<SmartElement> getElements() {
		return elements;
	}

	public void setElements(List<SmartElement> elements) {
		this.elements = elements;
	}

	public SmartButton getButton() {
		return button;
	}

	public void setButton(SmartButton button) {
		this.button = button;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
}
