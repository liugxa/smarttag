package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.model.SmartElement;
import com.platform.gui.framework.smart.util.I18NUtil;

public class SmartElementTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String label;
	
	private String value;
	
	private String type;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		SmartSectionTag parent = (SmartSectionTag)this.getParent();
		
		String l = I18NUtil.getCellValue(this.pageContext, label);
		parent.getElements().add(new SmartElement(type , name , l , value));
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
