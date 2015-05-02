package com.platform.gui.framework.tags;

import java.util.Date;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.PropertyUtils;

import com.platform.gui.framework.tags.decorate.DateColumnDecorate;
import com.platform.gui.framework.tags.decorate.DefaultColumnDecorate;
import com.platform.gui.framework.tags.decorate.IColumnDecorate;
import com.platform.gui.framework.tags.decorate.NumberColumnDecorate;
import com.platform.gui.framework.tags.decorate.PrecentColumnDecorate;
import com.platform.gui.framework.tags.decorate.URLColumnDecorate;
import com.platform.gui.framework.tags.inter.IEnableDecorate;
import com.platform.gui.framework.tags.model.SmartCell;

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
		cell.setColumnDecorate(this.getCellDecorate(parent , cell));
		
		parent.getCells().add(cell);
		return EVAL_PAGE;
	}
	
	@SuppressWarnings("unchecked")
	private IColumnDecorate getCellDecorate(SmartTableGridTag parent , SmartCell cell){
		IColumnDecorate decorate = new DefaultColumnDecorate();
		try{
			List beans = (List) this.pageContext.findAttribute(parent.getList());
			
			if(beans != null && beans.size() > 0){
				Object obj = beans.get(0);
				Object property = PropertyUtils.getProperty(obj , cell.getName());
				
				//get the decorate object if it implements IEnableDecorate interface. if not, 
				//the smart tag will display the column value by use the default decorate..
				if(obj instanceof IEnableDecorate){
					decorate = ((IEnableDecorate)obj).getColumnDecorate(cell.getName());
				}else{
					decorate = this.getDecorateFromTag(property, cell);
				}
			}
		}catch(Exception e){
			//forgot it!
		}
		return decorate;
	}

	/**
	 * Get decorate from the tag bean defined
	 * @param bean
	 * @param columnName
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	private IColumnDecorate getDecorateFromTag(Object property , SmartCell cell){
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
		}
		
		if(cellFormat != null){
			//get the decorate by the data type
			if(property instanceof Date){
				decorate = new DateColumnDecorate(cellFormat);
			}
			else if(property instanceof Number){
				decorate = new NumberColumnDecorate(cellFormat);
			}
		}
		
		if(cellUrl != null){
			decorate = new URLColumnDecorate(cellUrl);
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
