package com.platform.gui.framework.smart.tags.template;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartButton;
import com.platform.gui.framework.smart.tags.model.SmartElement;
import com.platform.gui.framework.smart.tags.model.SmartFilter;
import com.platform.gui.framework.smart.tags.model.SmartFilterResult;
import com.platform.gui.framework.smart.tags.model.SmartSection;

public class TestSmartListTable extends TestCase{
	
	public void testListTable(){
		try{
			MockSmartTableGridContext context = new MockSmartTableGridContext();
			
			SmartFilter filter = new SmartFilter();
			filter.setSections(this.getSmartSections());
			filter.setResult(this.getSmartResult());
			
			//SmartListTable listTable = new SmartListTable(context , filter , new MockSmartTableGrid() , new MockSmartPreference());
			//System.out.println(listTable.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	private List<SmartSection> getSmartSections(){
		List<SmartSection> sections = new ArrayList<SmartSection>();
		
		//option group 0
		SmartSection section0 = new SmartSection();
		List<SmartElement> elements0 = new ArrayList<SmartElement>();
		elements0.add(new SmartElement("input" , "name" , "Request Name" , "Any"));
		section0.setLabel("Find");
		section0.setElements(elements0);
		section0.setButton(new SmartButton("Find" , "find"));
		sections.add(section0);
		
		//option group 1;
		SmartSection section1 = new SmartSection();
		List<SmartElement> elements1 = new ArrayList<SmartElement>();
		elements1.add(new SmartElement("select" , "status" , "Request State" , "Any"));
		elements1.add(new SmartElement("select" , "date" , "Request Date" , "Any"));
		elements1.add(new SmartElement("input" , "machines" , "# of Machines" , "Any"));
		
		section1.setIsDefault(true);
		section1.setLabel("Find");
		section1.setElements(elements1);
		section1.setButton(new SmartButton("Filter" , "filter"));
		sections.add(section1);
		
		return sections;
		
	}
	
	private SmartFilterResult getSmartResult(){
		//set filter result
		SmartFilterResult result = new SmartFilterResult();
		Map<String , String> elements = new HashMap<String , String>();
		elements.put("Request State" , "State0");
		elements.put("Request Date" , "2/18/2009");
		elements.put("# of Machines" , "199");
		result.setElements(elements);
		return result;
	}	
}
