package com.platform.gui.framework.smart.inter.impl.item;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.ecs.html.Div;
import org.apache.ecs.html.Input;

import com.platform.gui.framework.smart.inter.IItemDecorate;
import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.TableContext;

public class DefaultItemDecorate implements IItemDecorate{
	
	protected String parameters;
	
	public DefaultItemDecorate(){}
	
	public DefaultItemDecorate(String parameters){
		this.parameters = parameters;
	}
	
	public String decorate(TableContext context , Integer index, FilterData filterData, DataItem item) throws Exception {
		return item.getName();
	}
	
	/**
	 * Get item key value if it set the "key" property. Otherwise, get its value by its name
	 * @param filterData
	 * @param item
	 * @return
	 * @throws Exception
	 */
	public Object getItemKeyValue(FilterData filterData , DataItem  item) throws Exception{
		String key = item.getKey();
		String name = item.getName();
		
		Object obj = null;
		if(key != null){
			obj = this.getItemValue(filterData , key);
		}else{
			obj = this.getItemValue(filterData , name);
		}
		return obj;
	}

	/**
	 * Get item value by its name
	 * @param filterData
	 * @param itemName
	 * @return
	 * @throws Exception
	 */
	public Object getItemValue(FilterData filterData , String itemName) throws Exception{
		Object r = null;
		DataItem dataItem = this.getFilterItem(filterData, itemName);
		
		if(dataItem != null) r = dataItem.getValue();
		return r;
	}
	
	/**
	 * Get filter item from the filter data
	 * @param filterData
	 * @param itemName
	 * @return
	 */
	public DataItem getFilterItem(FilterData filterData , String itemName){
		DataItem r = null;
		if(filterData != null){
			List<DataItem> filterItems = filterData.getItems();
			if(filterItems != null){
				for(DataItem filterItem:filterItems){
					//does the item exist?
					if(filterItem.getName().equals(itemName)){
						r = filterItem;
						break;
					}
				}
			}
		}
		return r;
	}
	
	/**
	 * The hidden elements of filter
	 * @param index
	 * @param item
	 * @return
	 * @throws Exception
	 */
	public String addHiddenValues(Integer index , DataItem item) throws Exception{
		Div div = new Div();
		
		Input[] hInputs = new Input[2];
		hInputs[0] = new Input();
		hInputs[0].setType("hidden");
		hInputs[0].setValue(item.getLabel());
		hInputs[0].setName("filterData.items[" + index + "].label");
		div.addElement(hInputs[0]);
		
		hInputs[1] = new Input();
		hInputs[1].setType("hidden");
		hInputs[1].setValue(item.getName());
		hInputs[1].setName("filterData.items[" + index + "].name");
		div.addElement(hInputs[1]);
		
		return div.toString();
	}

	public String getText(TableContext context , String key) throws Exception{
		String r = key;
		ResourceBundle resource = context.getResource();
		
		try{
			if(resource != null) r = resource.getString(key);
		}catch(Exception e){
			//ignore it!
		}
		return r;
		
	}
	
	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
