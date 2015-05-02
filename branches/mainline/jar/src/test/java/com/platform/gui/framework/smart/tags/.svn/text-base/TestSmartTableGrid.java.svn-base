package com.platform.gui.framework.smart.tags;
import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;

import com.platform.gui.framework.smart.tags.mock.MockSmartTableGrid;
import com.platform.gui.framework.smart.tags.mock.MockSmartTableGridContext;

public class TestSmartTableGrid extends TestCase{
	
	private Logger logger = Logger.getLogger(TestSmartTableGrid.class);
	
	private MockSmartTableGridContext context = new MockSmartTableGridContext();
	
	public void testTableGrid(){
		try{
			MockSmartTableGrid tableGrid = new MockSmartTableGrid(context);
			
			//test table columns
			Parser parser = new Parser(tableGrid.getHtml());
			NodeList as = parser.parse(new TagNameFilter("a"));
			assertEquals(8 , as.size());
			
			assertTrue(as.elementAt(0) instanceof LinkTag);
			LinkTag a0 = (LinkTag)as.elementAt(0);
			assertEquals(tableGrid.getCells().get(0).getLabel() , a0.toPlainTextString().trim());
			
			LinkTag a7 = (LinkTag)as.elementAt(7);
			assertEquals(tableGrid.getCells().get(7).getLabel() , a7.toPlainTextString().trim());
			
			if(logger.isDebugEnabled()) logger.debug(tableGrid.getHtml());
		}catch(Exception e){
			assertTrue(false);
		}
	}
	

}
