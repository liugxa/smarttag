package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.model.SmartElement;
import com.platform.gui.framework.smart.tags.model.SmartOption;
import com.platform.gui.framework.smart.tags.model.SmartSelect;

public class SmartSelectTag extends SmartElementTag{
	
	private Logger logger = Logger.getLogger(SmartSectionTag.class);
	
	private static final long serialVersionUID = 1L;
	
	private List<SmartOption> options;
	
	private SmartSelect select;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		options = new ArrayList<SmartOption>();
		select = new SmartSelect();
		return super.doStartTag();
	}
	
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartSectionTag parent = (SmartSectionTag)this.getParent();		
			List<SmartElement> elements = parent.getElements();
	
			select.setId(elements.size());
			select.setName(name);
			
			select.setLabel(this.getText(label));
			select.setValue(value);
			
			select.setContext(context);
			select.setTemplate(template);
			select.setTemplatePath(templatePath);
			select.setOptions(options);
			
			select.setParent(parent.getSection());
			elements.add(select);
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}
	
	public List<SmartOption> getOptions() {
		return options;
	}

	public void setOptions(List<SmartOption> options) {
		this.options = options;
	}

	public SmartSelect getSelect() {
		return select;
	}

	public void setSelect(SmartSelect select) {
		this.select = select;
	}	
}
