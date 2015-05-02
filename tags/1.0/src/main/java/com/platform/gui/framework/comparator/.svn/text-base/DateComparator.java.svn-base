package com.platform.gui.framework.comparator;

import java.util.Date;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.WrapDynaBean;

/**
 * User java.util.Date type to compare the given two Objects. Assume the date1
 * and date2 is a property of object1 and object2. The compare result will be:
 * 
 * <li>If the date1 is null and date2 is null, the result is 0.</li>
 * <li>If the date1 is null, but date2 is not null, the result is -1.</li>
 * <li>If the date1 is not null, but date2 is null, the result is 1.</li>
 * <li>If date1 equals date2, the result is 0.</li>
 * <li>If date1 before date2, the result is -1.</li>
 * <li>If date1 after date2, the result is 1.</li>
 * 
 * @author fkong
 */
public class DateComparator extends BeanComparator {

	public DateComparator(String property) {
		super(property);
	}

	public int compare(Object o1, Object o2) {
		DynaBean db1 = new WrapDynaBean(o1);
		Date date1 = (Date)db1.get(property);
		
		DynaBean db2 = new WrapDynaBean(o2);
		Date date2 = (Date)db2.get(property);
	    
		if( date1 == null && date2 == null ) {
			return 0;
		}
		if( date1 == null ) {
			return -1;
		}
		if( date2 == null ) {
			return 1;
		}
		
		return date1.compareTo(date2);
	}
}
