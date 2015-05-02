package com.platform.gui.framework.smart.tags;

import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.model.SmartElement;
import com.platform.gui.framework.smart.tags.model.SmartInput;

public class SmartInputTag extends SmartElementTag{

	private Logger logger = Logger.getLogger(SmartInputTag.class);
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartSectionTag parent = (SmartSectionTag)this.getParent();
			List<SmartElement> elements = parent.getElements();
			
			SmartInput input = new SmartInput();
			input.setId(elements.size());
			input.setName(name);
			
			input.setLabel(this.getText(label));
			input.setValue(value);
			
			input.setContext(context);
			input.setTemplate(template);
			input.setTemplatePath(templatePath);
			
			//set input's size and its parent
			input.setParent(parent.getSection());
			elements.add(input);
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}
}
