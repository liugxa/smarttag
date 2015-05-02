package com.platform.gui.framework.smart.tags.template;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.platform.gui.framework.smart.model.DataItem;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartButton;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartItem;
import com.platform.gui.framework.smart.tags.model.SmartSection;
import com.platform.gui.framework.smart.tags.util.SmartItemDecorateUtil;

public class TestSmartListTable extends TestCase{
	
	public void testSmartFilter(){
		try{
			MockSmartTableGridContext context = new MockSmartTableGridContext();
			context.setFilterData(this.getFilterData());
			
			SmartFilter filter = new SmartFilter(context , this.getSmartSections());
			
			System.out.println(filter.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	private List<SmartSection> getSmartSections() throws Exception{
		List<SmartSection> sections = new ArrayList<SmartSection>();
		
		//option group 0
		SmartSection section0 = new SmartSection();
		List<SmartItem> items0 = new ArrayList<SmartItem>();
		SmartItem item0_0 = new SmartItem();
		item0_0.setName("name");
		item0_0.setLabel("Request Name");
		item0_0.setValue("Any");
		item0_0.setDecorate("input");
		item0_0.setItemDecorate(SmartItemDecorateUtil.getDefaultDecorate("input", null));
		items0.add(item0_0);
		
		section0.setLabel("Find");
		section0.setItems(items0);
		section0.setButton(new SmartButton("Find" , "find"));
		sections.add(section0);
		
		//option group 1;
		SmartSection section1 = new SmartSection();
		List<SmartItem> items1 = new ArrayList<SmartItem>();
		SmartItem item1_0 = new SmartItem();
		item1_0.setName("status");
		item1_0.setLabel("Request State");
		item1_0.setDecorate("select");
		item1_0.setItemDecorate(SmartItemDecorateUtil.getDefaultDecorate("select", "{'aa':'AAA','bb':'BBB'}"));
		
		SmartItem item1_1 = new SmartItem();
		item1_1.setName("date");
		item1_1.setLabel("Request Date");
		item1_1.setDecorate("select");
		item1_1.setItemDecorate(SmartItemDecorateUtil.getDefaultDecorate("select", "{'aa':'AAA','bb':'BBB'}"));
		
		SmartItem item1_2 = new SmartItem();
		item1_2.setName("machines");
		item1_2.setLabel("# of Machines");
		item1_2.setDecorate("input");
		item1_2.setItemDecorate(SmartItemDecorateUtil.getDefaultDecorate("input", null));
		
		items1.add(item1_0);
		items1.add(item1_1);
		items1.add(item1_2);
		
		section1.setIsDefault(true);
		section1.setLabel("Find");
		section1.setItems(items1);
		section1.setButton(new SmartButton("Filter" , "filter"));
		sections.add(section1);
		
		return sections;
		
	}	
	
	public FilterData getFilterData(){
		FilterData filterData = new FilterData();
		List<DataItem> items = new ArrayList<DataItem>();
		DataItem item = new DataItem();
		item.setName("status");
		item.setLabel("Request State");
		item.setDecorate("select");
		item.setValue("aa");
		
		items.add(item);
		filterData.setItems(items);
		return filterData;
	}
}
