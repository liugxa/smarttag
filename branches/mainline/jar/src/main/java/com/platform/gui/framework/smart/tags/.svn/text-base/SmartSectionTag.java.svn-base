package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.model.SmartButton;
import com.platform.gui.framework.smart.tags.model.SmartElement;
import com.platform.gui.framework.smart.tags.model.SmartSection;

public class SmartSectionTag extends SmartElementTag{

	private Logger logger = Logger.getLogger(SmartSectionTag.class);
	
	private static final long serialVersionUID = 1L;
	
	/* The filter bar will display this option groups at first time */
	private String isDefault;
	
	/* The  element object */
	private List<SmartElement> elements;
	
	/* Display a button */
	private SmartButton button;

	private SmartSection section;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		elements = new ArrayList<SmartElement>();
		button = new SmartButton();
		
		section = new SmartSection();
		return super.doStartTag();
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartFilterTag parent = (SmartFilterTag)this.getParent();
			List<SmartSection> sections = parent.getSections();
			
			section.setId(sections.size());
			section.setName(name);
			
			section.setLabel(this.getText(label));
			section.setValue(value);
			
			section.setButton(button);		
			section.setElements(elements);
	
			section.setIsDefault(isDefault == "true"?true:false);		
			section.setContext(context);
			section.setTemplate(template);
			section.setTemplatePath(templatePath);
			
			section.setParent(parent.getFilter());
			sections.add(section);
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
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

	public List<SmartElement> getElements() {
		return elements;
	}

	public void setElements(List<SmartElement> elements) {
		this.elements = elements;
	}

	public SmartSection getSection() {
		return section;
	}

	public void setSection(SmartSection section) {
		this.section = section;
	}
}
