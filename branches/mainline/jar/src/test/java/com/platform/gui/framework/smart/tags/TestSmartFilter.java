package com.platform.gui.framework.smart.tags;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.mock.MockSmartFilter;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;

public class TestSmartFilter extends TestCase{

	private Logger logger = Logger.getLogger(TestSmartFilter.class);
	
	private MockSmartTableGridContext context = new MockSmartTableGridContext();
	
	public void testFilter(){
		try{
			MockSmartFilter filter = new MockSmartFilter(context);
			if(logger.isDebugEnabled()) logger.debug("html:" + filter.getHtml());
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
}
