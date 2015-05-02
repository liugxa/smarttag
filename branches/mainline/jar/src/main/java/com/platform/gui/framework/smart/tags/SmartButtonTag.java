package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.model.SmartButton;

public class SmartButtonTag extends SmartElementTag{

	private Logger logger = Logger.getLogger(SmartButtonTag.class);
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartSectionTag parent = (SmartSectionTag)this.getParent();
			
			SmartButton button = new SmartButton();
			button.setId(0);
			button.setName(name);
			
			button.setLabel(this.getText(label));
			button.setValue(value);
			
			button.setTemplate(template);
			button.setTemplatePath(templatePath);
			button.setContext(context);
		
			//set button's parent
			button.setParent(parent.getSection());
			parent.setButton(button);
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}
}
