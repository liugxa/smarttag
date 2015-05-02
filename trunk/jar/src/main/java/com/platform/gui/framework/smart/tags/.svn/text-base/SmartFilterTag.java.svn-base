package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.tags.exception.SmartTagException;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartSection;
import com.platform.gui.framework.smart.tags.util.SmartFilterUtil;

public class SmartFilterTag extends SmartElementTag{

	private static final long serialVersionUID = 1L;
		
	private List<SmartSection> sections;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		sections = new ArrayList<SmartSection>();	
		return EVAL_BODY_INCLUDE;
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			
			SmartFilter filter = new SmartFilter();
			BeanUtils.copyProperties(filter , this);
			
			// if user do not define the sections, get it from the java bean
			if(sections.size() == 0){
				sections = SmartFilterUtil.getSmartSectionList(parent.getContext(), parent.getDataItem(), parent.getDataItemDecorate());
				filter.setSections(sections);
			}

			parent.setFilter(filter);
			return EVAL_PAGE;
		} catch (Exception e) {
			throw new SmartTagException(e);
		}
	}

	public List<SmartSection> getSections() {
		return sections;
	}

	public void setSections(List<SmartSection> sections) {
		this.sections = sections;
	}
}