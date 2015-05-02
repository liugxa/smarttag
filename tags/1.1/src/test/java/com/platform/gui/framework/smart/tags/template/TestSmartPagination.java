package com.platform.gui.framework.smart.tags.template;
import junit.framework.TestCase;

import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartPagination;

public class TestSmartPagination extends TestCase{
	
	public void testPagination(){
		try{
			MockSmartTableGridContext context = new MockSmartTableGridContext();
			SmartPagination pagination = new SmartPagination(context);

			System.out.println(pagination.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
