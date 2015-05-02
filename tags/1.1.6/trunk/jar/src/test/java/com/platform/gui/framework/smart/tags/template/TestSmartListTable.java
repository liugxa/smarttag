package com.platform.gui.framework.smart.tags.template;
import junit.framework.TestCase;

import com.platform.gui.framework.smart.tags.mock.MockSmartFilter;
import com.platform.gui.framework.smart.tags.mock.MockSmartPreference;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGrid;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartListTable;

public class TestSmartListTable extends TestCase{
	
	public void testListTable(){
		try{
			MockSmartTableGridContext context = new MockSmartTableGridContext();
			SmartListTable listTable = new SmartListTable(context , new MockSmartFilter() , new MockSmartTableGrid() , new MockSmartPreference());
			System.out.println(listTable.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
