package com.platform.gui.framework.smart.tags.model;

import com.platform.gui.framework.smart.inter.IColumnDecorate;

public class SmartCell extends SmartElement{

	private Boolean disable;
	
	private Boolean escape = true;
	
	/* right | left | middle |top |bottom */
	private String align;
	
	private IColumnDecorate columnDecorate;
	

	public Boolean getDisable() {
		return disable;
	}

	public void setDisable(Boolean disable) {
		this.disable = disable;
	}

	public IColumnDecorate getColumnDecorate() {
		return columnDecorate;
	}

	public void setColumnDecorate(IColumnDecorate columnDecorate) {
		this.columnDecorate = columnDecorate;
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
