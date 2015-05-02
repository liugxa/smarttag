package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnableDecorate;
import com.platform.gui.framework.smart.inter.impl.DateColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.DefaultColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.NumberColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.PrecentColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.URLColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;

public class SmartColumnTag extends TagSupport{ 

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String value;
	
	private String url;
	
	private String format;
	
	private String decorate;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		//add it to its parent cell list
		SmartTableGridTag parent = (SmartTableGridTag)this.getParent();
		
		//initialize the cell object
		SmartCell cell = new SmartCell();
		cell.setName(name);
		cell.setValue(value);
		cell.setUrl(url);
		cell.setFormat(format);
		cell.setDecorate(decorate);
		cell.setColumnDecorate(this.getColumnDecorate(cell));
		
		parent.getCells().add(cell);
		return EVAL_PAGE;
	}

	/**
	 * Get decorate from the tag bean defined
	 * @param bean
	 * @param columnName
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private IColumnDecorate getColumnDecorate(SmartCell cell) throws JspException{
		String cellDecorate = cell.getDecorate();
		String cellFormat = cell.getFormat();
		String cellUrl = cell.getUrl();
		
		//get he default decorate by the column type.
		IColumnDecorate decorate = new DefaultColumnDecorate();
		
		//get the decorate by keywords
		if(cellDecorate != null){
			if(cellDecorate.equalsIgnoreCase("percent")){
				decorate = new PrecentColumnDecorate();
			}
			else if(cellDecorate.equalsIgnoreCase("date")){
				decorate = new DateColumnDecorate(cellFormat);
			}
			else if(cellDecorate.equalsIgnoreCase("number")){
				decorate = new NumberColumnDecorate(cellFormat);
			}
			else if(cellDecorate.equalsIgnoreCase("link")){
				decorate = new URLColumnDecorate(cellUrl);
			}
		}else{
			//get the decorate from the java bean
			Object bean = this.pageContext.findAttribute(SmartConstants.DATA);
			if(bean != null){
				IDataRecordList recordList = (IDataRecordList)bean;
				if(recordList instanceof IEnableDecorate){
					decorate = ((IEnableDecorate) recordList).getColumnDecorate(cell.getName());
				}
			}
			
		}
		
		return decorate;
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
