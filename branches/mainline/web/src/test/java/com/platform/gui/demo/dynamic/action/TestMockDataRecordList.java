package com.platform.gui.demo.dynamic.action;

import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.beanutils.BeanUtils;

public class TestMockDataRecordList extends TestCase{

	public void testGetAllRecords(){
		try{
			String filePath = this.getClass().getResource("").getFile();
			MockDataRecordList[] recordList = new MockDataRecordList[4];
			for(int i=0;i<recordList.length;i++){
				String fileName = filePath + "type" + i + ".txt";
				recordList[i] = new MockDataRecordList(fileName);
			}
			
			//type0 list
			List<Object> records0 = recordList[0].getAllRecords();
			assertNotNull(records0);
			assertEquals(15 , records0.size());
			
			Object record03 = records0.get(3);
			assertEquals("Small RedHat Linux 5.2", BeanUtils.getProperty(record03, "name"));
			assertEquals("10", BeanUtils.getProperty(record03, "storage"));
			assertEquals("$0.10", BeanUtils.getProperty(record03, "price"));
			
			
			//type1 list
			List<Object> records1 = recordList[1].getAllRecords();
			assertNotNull(records1);
			assertEquals(3 , records1.size());

			//type2 list
			List<Object> records2 = recordList[2].getAllRecords();
			assertNotNull(records2);
			assertEquals(3 , records2.size());
			
			//type3 list
			List<Object> records3 = recordList[3].getAllRecords();
			assertNotNull(records3);
			assertEquals(9 , records3.size());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
