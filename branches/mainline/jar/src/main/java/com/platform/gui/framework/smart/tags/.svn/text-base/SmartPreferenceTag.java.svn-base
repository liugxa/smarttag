package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.model.SmartPreference;

public class SmartPreferenceTag extends SmartElementTag{

	private Logger logger = Logger.getLogger(SmartPreferenceTag.class);
	
	private static final long serialVersionUID = 1L;

	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartPreference preference = new SmartPreference();
			preference.setId(0);
			preference.setName(name);
			preference.setLabel(this.getText(label));
			preference.setValue(value);
			
			preference.setContext(context);
			preference.setTemplate(template);
			preference.setTemplatePath(templatePath);
			
			SmartListTableTag parent = (SmartListTableTag)this.getParent();		
			preference.setParent(parent.getList());
			parent.setPreference(preference);
			
			return EVAL_PAGE;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}
}