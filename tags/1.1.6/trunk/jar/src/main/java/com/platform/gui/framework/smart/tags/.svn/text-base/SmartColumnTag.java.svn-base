package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.util.SmartColumnDecorateUtil;
import com.platform.gui.framework.smart.util.I18NUtil;

public class SmartColumnTag extends TagSupport{ 

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String label;
	
	private String value;
	
	private String url;
	
	private String format;
	
	private String decorate;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			//add it to its parent cell list
			SmartTableGridTag parent = (SmartTableGridTag)this.getParent();
			
			//initialize the cell object
			SmartCell cell = new SmartCell();
			cell.setName(name);
			cell.setLabel(I18NUtil.getCellValue(this.pageContext, label));
			
			cell.setValue(value);
			cell.setUrl(url);
			cell.setFormat(format);
			cell.setDecorate(decorate);
			
			IColumnDecorate decorate = SmartColumnDecorateUtil.getColumnDecorateFromJSP(this.pageContext , cell);
			cell.setColumnDecorate(decorate);
			
			parent.getCells().add(cell);
		}catch(Exception e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getDecorate() {
		return decorate;
	}

	public void setDecorate(String decorate) {
		this.decorate = decorate;
	}
}
