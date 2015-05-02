package com.platform.gui.framework.smart.tags;
import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.mock.MockSmartFilter;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGrid;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartListTable;

public class TestSmartListTable extends TestCase{
	
	private Logger logger = Logger.getLogger(TestSmartListTable.class);
	
	private MockSmartTableGridContext context = new MockSmartTableGridContext();
	
	public void testListTable(){
		try{
			SmartListTable list = new SmartListTable();
			list.setContext(context);
			list.setTableGrid(new MockSmartTableGrid(context));
			list.setFilter(new MockSmartFilter(context));
			
			if(logger.isDebugEnabled()) logger.debug(list.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
		
}
