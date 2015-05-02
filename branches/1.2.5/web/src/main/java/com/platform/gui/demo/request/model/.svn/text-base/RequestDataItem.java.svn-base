package com.platform.gui.demo.request.model;

import java.util.ArrayList;
import java.util.List;

import com.platform.gui.framework.smart.inter.IDataItem;
import com.platform.gui.framework.smart.inter.impl.item.CheckboxItemDecorate;
import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.DataSection;

public class RequestDataItem implements IDataItem{

	public List<DataItem> getDataItems() throws Exception {
		List<DataItem> items = new ArrayList<DataItem>();
		//section 0 
		DataSection section = new DataSection("section0" , "Section 0");
		section.setButtonLabel("Find");
		
		DataItem item0 = new DataItem();
		item0.setLabel("Request Name");
		item0.setName("name");
		item0.setDecorate("input");
		item0.setSection(section);
		items.add(item0);

		DataSection section1 = new DataSection("section1" , "Section 1");
		section1.setButtonLabel("Filter");
		
		DataItem item1 = new DataItem();
		item1.setLabel("Request Status");
		item1.setName("status");
		item1.setSection(section1);
		
		/*
		item1.setDecorate("radio");
		item1.setParameters("{'active':'Active','suspend':'Suspend'}");
		*/
		
		item1.setItemDecorate(new CheckboxItemDecorate("{'active':'Active','suspend':'Suspend'}"));
		items.add(item1);
		
		return items;
	}

}
