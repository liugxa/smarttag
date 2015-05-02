package com.platform.gui.demo.dynamic.action;

import com.platform.gui.demo.dynamic.util.DataTableUtils;
import com.platform.gui.framework.smart.inter.impl.DefaultDataRecordList;

public class MockDataRecordList extends DefaultDataRecordList<Object>{

	public MockDataRecordList(String fileName) throws Exception{
		super();
		this.setRecords(DataTableUtils.getTableDataFromFile(fileName));
		
	}
}
