package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.util.SmartColumnDecorateUtil;

public class SmartColumnTag extends TagSupport{ 

	private static final long serialVersionUID = 1L;

	private String key;
	
	private String name;
	
	private String label;
	
	private String value;
	
	private Boolean disable;
	
	private Boolean escape;
	
	private String decorate;
	
	private String parameters;
	
	/* right/left/middle/top/bottom */
	private String align;
	
	private String style;
	
	/** @deprecated url has been replaced by parameters*/
	private String url;
	
	/** @deprecated format has been replaced by parameters*/
	private String format;
	
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
			BeanUtils.copyProperties(cell , this);

			IColumnDecorate decorate = SmartColumnDecorateUtil.getDecorateFromJsp(pageContext , columnDecorate , dataColumn , cell);
			cell.setColumnDecorate(decorate);
			
			parent.getCells().add(cell);
		}catch(Exception e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public Boolean getEscape() {
		return escape;
	}

	public void setEscape(Boolean escape) {
		this.escape = escape;
	}
	
	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}
