package com.platform.gui.framework.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.tags.model.SmartFilter;
import com.platform.gui.framework.tags.model.SmartSection;
import com.platform.gui.framework.tags.model.SmartFilterResult;

public class SmartFilterTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private List<SmartSection> sections;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		
		// initialize the options/button object
		sections = new ArrayList<SmartSection>();
		
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartFilter filter = new SmartFilter();
			filter.setSections(sections);
			
			Object obj = pageContext.getAttribute("filterResult");
			if(obj != null) filter.setResult((SmartFilterResult) obj);
			
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			parent.setFilter(filter);
			
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
	}

	public List<SmartSection> getSections() {
		return sections;
	}

	public void setSections(List<SmartSection> sections) {
		this.sections = sections;
	}
}