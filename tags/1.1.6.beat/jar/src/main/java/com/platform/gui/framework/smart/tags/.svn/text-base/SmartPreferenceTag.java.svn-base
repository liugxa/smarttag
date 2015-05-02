package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.tags.model.SmartPreference;
import com.platform.gui.framework.smart.util.I18NUtil;

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
			SmartPreference preference = new SmartPreference();
			preference.setLabel(I18NUtil.getCellValue(this.pageContext, label));
						
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			parent.setPreference(preference);
			
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}