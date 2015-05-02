package com.platform.gui.framework.smart.tags.template;
import junit.framework.TestCase;

import com.platform.gui.framework.smart.tags.mock.MockSmartFilter;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartFilter;

public class TestSmartFilter extends TestCase{
	
	public void testFilterResult(){
		try{
			SmartFilter filter = new SmartFilter(new MockSmartTableGridContext());
			filter.setResult(MockSmartFilter.getSmartResult());
			filter.setSections(MockSmartFilter.getSmartSections());
			System.out.println(filter.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
