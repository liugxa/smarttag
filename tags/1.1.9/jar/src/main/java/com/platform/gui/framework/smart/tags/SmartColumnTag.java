package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.util.SmartColumnDecorateUtil;

public class SmartColumnTag extends TagSupport{ 

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String label;
	
	private String value;
	
	private Boolean disable;
	
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
			SmartListTableTag listTable = (SmartListTableTag)parent.getParent();
			
			IDataColumn dataColumn = listTable.getDataColumn();
			IDataColumnDecorate columnDecorate = listTable.getDataColumnDecorate();
			
			//initialize the cell object
			SmartCell cell = new SmartCell();
			cell.setName(name);
			cell.setLabel(label);
			
			cell.setDisable(disable);
			cell.setValue(value);
			cell.setUrl(url);
			cell.setFormat(format);
			cell.setDecorate(decorate);

			IColumnDecorate decorate = SmartColumnDecorateUtil.getDecorate(pageContext.getRequest() , columnDecorate , dataColumn , cell);
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

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
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
