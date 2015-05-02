package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.tags.model.SmartPreference;

public class SmartPreferenceTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String label;

	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {		
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			
			SmartPreference preference = new SmartPreference();
			preference.setLabel(label);

			parent.setPreference(preference);			
			return EVAL_PAGE;
		} catch (Exception e) {
			throw new SmartTagException(e);
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}