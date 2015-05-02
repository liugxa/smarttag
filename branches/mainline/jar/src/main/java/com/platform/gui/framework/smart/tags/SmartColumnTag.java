package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.util.SmartColumnDecorateUtil;

public class SmartColumnTag extends SmartElementTag{ 

	private Logger logger = Logger.getLogger(SmartColumnTag.class);
	
	private static final long serialVersionUID = 1L;
	
	private Boolean disable;
	
	private String decorate;
	
	private String parameters;
	
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
			cell.setId(parent.getCells().size());
			cell.setName(name);
			
			cell.setLabel(this.getText(label));
			cell.setValue(value);
			cell.setDisable(disable);

			cell.setDecorate(decorate);
			cell.setParameters(parameters);

			IColumnDecorate decorate = SmartColumnDecorateUtil.getDecorate(pageContext , columnDecorate , dataColumn , cell);
			cell.setColumnDecorate(decorate);
			
			cell.setContext(context);
			cell.setTemplate(template);
			cell.setTemplatePath(templatePath);
			
			cell.setParent(parent.getTable());
			parent.getCells().add(cell);			
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
	}

	public String getDecorate() {
		return decorate;
	}

	public void setDecorate(String decorate) {
		this.decorate = decorate;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
