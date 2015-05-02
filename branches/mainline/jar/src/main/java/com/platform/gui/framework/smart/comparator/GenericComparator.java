package com.platform.gui.framework.smart.comparator;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.comparators.NullComparator;

public class GenericComparator<T> implements Comparator<T>, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String property;
	
	public GenericComparator(String property){
		this.property = property;
	}

	public int compare(T o1, T o2){
		try{
			Object property1 = PropertyUtils.getProperty(o1 , property);
			Object property2 = PropertyUtils.getProperty(o2 , property);
			
			if(property1 != null && property2 != null){
				String class1 = property1.getClass().getSimpleName();
				String class2 = property2.getClass().getSimpleName();
				//System.out.println(class1 + "|" + class2);
				
				//if the property is simply type, use BeanComparator.
				//otherwise, comparator it by myself
				if(class1.equals("Object") && !class2.equals("Object")){
					return -1;
				}

				if(class1.equals("Object") && class2.equals("Object")){
					return 0; 
				}
				
				if(!class1.equals("Object") && class2.equals("Object")){
					return 1; 
				}
			}
			
			BeanComparator comparator = new BeanComparator(property , new NullComparator(false));			
			return comparator.compare(o1, o2);
		}catch(Exception e){
			e.printStackTrace();
			throw new CompareException(e);
		}
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}
}
