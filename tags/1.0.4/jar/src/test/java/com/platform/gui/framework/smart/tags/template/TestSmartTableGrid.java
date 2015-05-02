package com.platform.gui.framework.smart.tags.template;
import junit.framework.TestCase;

import com.platform.gui.framework.smart.tags.mock.MockSmartTableGrid;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class TestSmartTableGrid extends TestCase{
	
	public void testTableGrid(){
		try{
			SmartTableGrid tableGrid = new MockSmartTableGrid();
			System.out.println(tableGrid.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
