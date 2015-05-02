package com.platform.gui.framework.smart.tags.model;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.inter.IItemDecorate;
import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;

public class SmartSection extends SmartElement{
	
	private boolean isDefault;
	
	private List<SmartItem> items;

	private SmartButton button;
	
	public String getItemValue(Integer index , FilterData filterData , SmartItem item) throws Exception{
		//get cell's decorate and decorate the value
		DataItem dataItem = new DataItem();
		BeanUtils.copyProperties(dataItem , item);
		
		IItemDecorate decorate = item.getItemDecorate();
		return decorate.decorate(index , filterData , dataItem);
	}
	
	public List<SmartItem> getItems() {
		return items;
	}

	public void setItems(List<SmartItem> items) {
		this.items = items;
	}

	public SmartButton getButton() {
		return button;
	}

	public void setButton(SmartButton button) {
		this.button = button;
	}

	public boolean getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}
}
