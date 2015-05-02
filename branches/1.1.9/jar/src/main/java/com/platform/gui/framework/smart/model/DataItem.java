package com.platform.gui.framework.smart.model;

import com.platform.gui.framework.smart.inter.IItemDecorate;


public class DataItem extends DataElement{
	
	private IItemDecorate itemDecorate;

	private DataSection section;
	
	public IItemDecorate getItemDecorate() {
		return itemDecorate;
	}

	public void setItemDecorate(IItemDecorate itemDecorate) {
		this.itemDecorate = itemDecorate;
	}

	public DataSection getSection() {
		return section;
	}

	public void setSection(DataSection section) {
		this.section = section;
	}
}
