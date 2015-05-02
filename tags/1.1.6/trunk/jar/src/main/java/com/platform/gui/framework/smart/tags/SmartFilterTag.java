package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartFilterResult;
import com.platform.gui.framework.smart.tags.model.SmartSection;
import com.platform.gui.framework.smart.util.I18NUtil;

public class SmartFilterTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	private String label;
	
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
			SmartFilter filter = new SmartFilter();
			filter.setLabel(I18NUtil.getCellValue(this.pageContext, label));
			
			filter.setSections(sections);
			filter.setResult(this.getFilterResult());
			
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			parent.setFilter(filter);
			
			return EVAL_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
	}

	/**
	 * Transfer the data from FilterData to SmartResult
	 * @return
	 */
	private SmartFilterResult getFilterResult() throws Exception{
		SmartFilterResult result = new SmartFilterResult();
		Object obj = pageContext.findAttribute("filterData");
		if(obj != null){
			FilterData filterData = (FilterData)obj;
			result.setElements(filterData.getFilterResult());
		}
		return result;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<SmartSection> getSections() {
		return sections;
	}

	public void setSections(List<SmartSection> sections) {
		this.sections = sections;
	}
}