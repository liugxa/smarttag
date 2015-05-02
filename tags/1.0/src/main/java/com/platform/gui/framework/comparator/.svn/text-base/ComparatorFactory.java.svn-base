package com.platform.gui.framework.comparator;

import org.apache.commons.beanutils.PropertyUtils;

/**
 * A factory that be used to create BeanComparator instance. It use
 * comparator.properties file to get BeanComparator class implement.
 * 
 * @author fkong
 */
public class ComparatorFactory {
	
	/**
	 * Get an instance of BeanComparator with given Object and property of this Object.
	 * @param clazz Class instance 
	 * @param property the property of class
	 * @return an instance of BeanComparator
	 */
	public static <T> BeanComparator getComparator(Object bean, String property)  throws Exception{
    	BeanComparator comparator = new GenericComparator(property);
    	
    	String typeName = PropertyUtils.getPropertyType(bean, property).getName();
		if(typeName.equals("java.lang.String")){
			comparator = new StringComparator(property);
		}else{
			if(typeName.equals("java.util.Date")){
				comparator = new DateComparator(property);
			}
		}
		return comparator;
	}
}
