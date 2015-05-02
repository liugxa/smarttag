package com.platform.gui.framework.smart.util;

import com.platform.gui.framework.smart.comparator.SortOrder;

public class SortOrderUtil {
	
	public static SortOrder transfer(String name){
		SortOrder order = SortOrder.ASC;
		if(name != null && !name.equals("")){
			if(name.equalsIgnoreCase("desc")) order = SortOrder.DESC;
		}
		return order;
	}
	
}
