package com.platform.gui.demo.mock.action;

import java.util.List;

import junit.framework.TestCase;

import com.platform.gui.framework.smart.model.DataColumn;

public class TestMockDataColumn extends TestCase{

	public void testGetDataColumn(){
		try{
			String filePath = this.getClass().getResource("").getFile();
			//System.out.println(filePath);

			MockDataColumn[] dataColumns = new MockDataColumn[4];
			for(int i=0;i<dataColumns.length;i++){
				String fileName = filePath + "columns.txt";
				dataColumns[i] = new MockDataColumn(fileName , i + "");
			}
			
			//column 0
			List<DataColumn> columns0 = dataColumns[0].getDataColumn();
			assertNotNull(columns0);
			assertEquals(7 , columns0.size());
			
			DataColumn column0 = columns0.get(0);
			assertEquals("name" , column0.getName());
			assertEquals("Offering Name" , column0.getValue());
			
			DataColumn column3 = columns0.get(3);
			assertEquals("storage" , column3.getName());
			assertEquals("Storage (GB)" , column3.getValue());			

			//column 1
			List<DataColumn> columns1 = dataColumns[1].getDataColumn();
			assertNotNull(columns1);
			assertEquals(5 , columns1.size());

			//column 2
			List<DataColumn> columns2 = dataColumns[2].getDataColumn();
			assertNotNull(columns2);
			assertEquals(3 , columns2.size());
			
			//column 3
			List<DataColumn> columns3 = dataColumns[3].getDataColumn();
			assertNotNull(columns3);
			assertEquals(9 , columns3.size());
			
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
