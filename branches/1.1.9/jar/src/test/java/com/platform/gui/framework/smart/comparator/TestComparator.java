package com.platform.gui.framework.smart.comparator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;

import com.platform.gui.framework.smart.util.Sorter;

public class TestComparator extends TestCase{

	public void testNormalBean(){
		try{
			Calendar calendar = Calendar.getInstance();
			
			//test normal bean
			TestBean bean0 = new TestBean(0);
			bean0.setInteger(2);
			bean0.setStr(null);
			bean0.setDate(calendar.getTime());
			
			//test1
			TestBean bean1 = new TestBean(1);
			bean1.setInteger(3);
			bean1.setStr("aaa");

			calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 2);
			bean1.setDate(calendar.getTime());
			
			//test2
			TestBean bean2 = new TestBean(2);
			bean2.setInteger(1);
			bean2.setStr("bb");
			
			calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
			bean2.setDate(calendar.getTime());
			
			//add to list
			List<TestBean> beans = new ArrayList<TestBean>();
			beans.add(bean2);
			beans.add(bean1);
			beans.add(bean0);
			
			Sorter<TestBean> sorter = new Sorter<TestBean>();
			
			//comparator by integer
			sorter.sort(beans, "str", SortOrder.ASC);
			assertEquals(0, beans.get(0).getId());
			assertEquals(1, beans.get(1).getId());
			assertEquals(2, beans.get(2).getId());
			
			//comparator by string
			sorter.sort(beans, "integer", SortOrder.ASC);	
			assertEquals(2 , beans.get(0).getId());
			assertEquals(0 , beans.get(1).getId());
			assertEquals(1 , beans.get(2).getId());
			
			//comparator by data
			sorter.sort(beans, "date", SortOrder.ASC);
			assertEquals(0 , beans.get(0).getId());
			assertEquals(2 , beans.get(1).getId());
			assertEquals(1 , beans.get(2).getId());
			
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
	
	public void testDynaBean(){
		try{
			//test dynamic bean
			DynaBean dybean0 = new LazyDynaBean();
			dybean0.set("property", 1);
			
			DynaBean dybean1 = new LazyDynaBean();
			dybean1.set("property", null);

			DynaBean dybean2 = new LazyDynaBean();
			dybean2.set("property", 2);
			
			List<DynaBean> dybeans = new ArrayList<DynaBean>();
			dybeans.add(dybean0);
			dybeans.add(dybean1);
			dybeans.add(dybean2);
			
			Sorter<DynaBean> dysorter = new Sorter<DynaBean>();
			dysorter.sort(dybeans, "property", SortOrder.ASC);
			
			assertEquals(1, dybeans.get(1).get("property"));
			assertEquals(2, dybeans.get(2).get("property"));
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}		
	}
}
