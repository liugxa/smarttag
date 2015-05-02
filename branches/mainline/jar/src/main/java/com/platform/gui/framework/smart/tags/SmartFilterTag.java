package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartFilterResult;
import com.platform.gui.framework.smart.tags.model.SmartSection;


public class SmartFilterTag extends SmartElementTag{

	private Logger logger = Logger.getLogger(SmartFilterTag.class);
	
	private static final long serialVersionUID = 1L;
	
	private List<SmartSection> sections;
	
	private SmartFilter filter;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		sections = new ArrayList<SmartSection>();
		filter = new SmartFilter();
		return super.doStartTag();
	}
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			
			filter.setId(0);
			filter.setName(name);
			
			filter.setValue(value);
			filter.setLabel(this.getText(label));
			
			filter.setSections(sections);
			filter.setResult(this.getFilterResult());
			
			filter.setContext(context);
			filter.setTemplate(template);
			filter.setTemplatePath(templatePath);
			
			filter.setParent(parent.getList());		
			parent.setFilter(filter);
			
			return EVAL_PAGE;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}

	/**
	 * Transfer the data from FilterData to SmartResult
	 * @return
	 */
	private SmartFilterResult getFilterResult() throws Exception{
		SmartFilterResult result = new SmartFilterResult();
		Object obj = pageContext.findAttribute(SmartConstants.FILTER_DATA);
		if(obj != null){
			FilterData filterData = (FilterData)obj;
			result.setElements(filterData.getFilterResult());
		}
		return result;
	}

	public List<SmartSection> getSections() {
		return sections;
	}

	public void setSections(List<SmartSection> sections) {
		this.sections = sections;
	}

	public SmartFilter getFilter() {
		return filter;
	}

	public void setFilter(SmartFilter filter) {
		this.filter = filter;
	}
}