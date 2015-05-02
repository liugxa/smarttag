package com.platform.gui.framework.smart.tags.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataItem;
import com.platform.gui.framework.smart.inter.IDataItemDecorate;
import com.platform.gui.framework.smart.inter.IItemDecorate;
import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.DataSection;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartButton;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartItem;
import com.platform.gui.framework.smart.tags.model.SmartSection;

public class SmartFilterUtil {
	
	/**
	 * Get Smart table if user do not define <pf:table/> in JSP file
	 * @param pageContext
	 * @param context
	 * @param dataRecords
	 * @param dataColumn
	 * @param columnDecorate
	 * @return
	 * @throws Exception
	 */
	public static SmartFilter getSmartFilter(SmartTableContext context , IDataItem dataItem , IDataItemDecorate itemDecorate) throws Exception{
		SmartFilter filter = null;
		if(dataItem != null){
			List<SmartSection> sections = getSmartSectionList(context , dataItem , itemDecorate);
			
			// filter object
			filter = new SmartFilter(context , sections);
		}
		return filter;
	}
	
	/**
	 * PRIORITY
	 * Preference > JSP file > interface.
	 * TODO		
	 * JSP > interface
	 * if can not get the cells from the JSP, get it from the bean
	 * @return
	 * @throws Exception
	 */
	public static List<SmartSection> getSmartSectionList(SmartTableContext context, IDataItem _dataItem , IDataItemDecorate _itemDecorate) throws Exception{
		PageContext _pageContext = context.getPageContext();
		List<DataItem> dataItems = new ArrayList<DataItem>();
		
		if(_dataItem != null){		
			//transfer the IDataColumn to SmartCell object
			dataItems = _dataItem.getDataItems();
		}else{
			//get data column from request
			Object obj = _pageContext.getRequest().getAttribute(SmartConstants.DATA_ITEM);
			if(obj != null) dataItems = ((IDataItem)obj).getDataItems();
		}
		
		// get all of the sections
		Set<DataSection> dataSections = new LinkedHashSet<DataSection>();
		for(DataItem dataItem:dataItems){
			dataSections.add(dataItem.getSection());
		}
		
		// get all of the smart sections with items
		List<SmartSection> sections = new ArrayList<SmartSection>();
		for(DataSection dataSection:dataSections){
			SmartSection section = new SmartSection();
			BeanUtils.copyProperties(section , dataSection);
		
			// get the section's items
			List<SmartItem> items = new ArrayList<SmartItem>();
			for(DataItem dataItem:dataItems){
				if(dataItem.getSection().getName().equals(dataSection.getName())){
					SmartItem item = new SmartItem();
					BeanUtils.copyProperties(item , dataItem);
			  
					//get the decorate from the column object directly.
					IItemDecorate decorate = dataItem.getItemDecorate();
					if(decorate == null){
						//get the default decorate if the "decorate" column has been defined	
						decorate = SmartItemDecorateUtil.getDefaultDecorate(dataItem.getDecorate() , dataItem.getParameters());
					
						//still can not find it! So,get it from the interface - IDataColumnDecorate
						if(decorate == null){
							decorate = SmartItemDecorateUtil.getDecorateFromBean(_pageContext , _itemDecorate , _dataItem , item);
						}
						item.setItemDecorate(decorate);
					}
					items.add(item);
				}
			}
			section.setItems(items);
		
			// get the section's button
			SmartButton button = new SmartButton(dataSection.getButtonLabel());
			section.setButton(button);
			sections.add(section);
		}
		return sections;
	}
	
		
}
