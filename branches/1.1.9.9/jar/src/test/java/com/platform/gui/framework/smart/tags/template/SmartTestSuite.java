package com.platform.gui.framework.smart.tags.template;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SmartTestSuite extends TestCase{
	
	public static Test suite() {
		TestSuite suite= new TestSuite("SmartTestSuite");
		
		suite.addTestSuite(TestSmartTableGrid.class);
		
		//suite.addTestSuite(TestSmartListTable.class);
		//suite.addTestSuite(TestSmartFilter.class);
		return suite;
	}
}
