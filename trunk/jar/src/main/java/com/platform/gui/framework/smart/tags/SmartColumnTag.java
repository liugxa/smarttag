package com.platform.gui.framework.smart.tags;

import javax.servlet.jsp.JspException;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.util.SmartColumnDecorateUtil;

public class SmartColumnTag extends SmartElementTag{ 

	private static final long serialVersionUID = 1L;

	private Boolean disable;
	
	private Boolean escape = true;
	
	/* right | left | middle | top | bottom */
	private String align;
	
	/**
	 * doEndTag() method!
	 */
	public int doEndTag() throws JspException {
		try{
			//add it to its parent cell list
			SmartTableGridTag parent = (SmartTableGridTag)this.getParent();
			SmartListTableTag listTable = (SmartListTableTag)parent.getParent();
			
			SmartTableContext context = listTable.getContext();
			IDataColumn dataColumn = listTable.getDataColumn();
			IDataColumnDecorate columnDecorate = listTable.getDataColumnDecorate();
			
			//initialize the cell object
			SmartCell cell = new SmartCell();
			BeanUtils.copyProperties(cell , this);

			IColumnDecorate decorate = SmartColumnDecorateUtil.getDecorateFromJsp(context , columnDecorate , dataColumn , cell);
			cell.setColumnDecorate(decorate);
			
			parent.getCells().add(cell);
		}catch(Exception e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public Boolean getEscape() {
		return escape;
	}

	public void setEscape(Boolean escape) {
		this.escape = escape;
	}
	
	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}
}
