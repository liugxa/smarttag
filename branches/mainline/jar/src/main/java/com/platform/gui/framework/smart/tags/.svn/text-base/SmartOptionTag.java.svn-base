package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.model.SmartOption;

public class SmartOptionTag extends SmartElementTag{

	private Logger logger = Logger.getLogger(SmartOptionTag.class);
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			Tag tag = this.getParent();
			SmartOption option = new SmartOption();
			
			List<SmartOption> options = new ArrayList<SmartOption>();
			String value = null;
			
			if(tag instanceof SmartRowActionTag){
				SmartRowActionTag parent = (SmartRowActionTag)tag;
				option.setParent(parent.getCell());
				options = parent.getOptions();
				value = parent.getValue();
			}
			else if(tag instanceof SmartSelectTag){
				SmartSelectTag parent = (SmartSelectTag)tag;
				option.setParent(parent.getSelect());
				options = parent.getOptions();
				value = parent.getValue();
			}
			
			option.setId(options.size());
			option.setName(name);
			
			option.setValue(value);
			option.setLabel(this.getText(label));
			
			option.setContext(context);
			option.setTemplate(template);
			option.setTemplatePath(templatePath);
			
			if(value != null && name.equals(value)) option.setSelected(true);
			options.add(option);
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}
}
