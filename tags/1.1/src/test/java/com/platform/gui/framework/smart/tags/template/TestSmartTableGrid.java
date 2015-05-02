package com.platform.gui.framework.smart.tags.template;
import junit.framework.TestCase;

import com.platform.gui.framework.smart.tags.mock.MockSmartRowAction;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

public class TestSmartTableGrid extends TestCase{
	
	public void testTableGrid(){
		try{
			MockSmartTableGridContext context = new MockSmartTableGridContext();
			SmartTableGrid tableGrid = new SmartTableGrid(context , new MockSmartRowAction());

			System.out.println(tableGrid.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
