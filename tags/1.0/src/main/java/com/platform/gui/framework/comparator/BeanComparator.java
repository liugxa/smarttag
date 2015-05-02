package com.platform.gui.framework.comparator;

import java.util.Comparator;

/**
 * A abstract class for compare POJO object. All property comparator must
 * extends this class direct or indirect. The property is belong to an bean
 * which need to be compared.
 * 
 * @author fkong
 */
@SuppressWarnings("unchecked")
public abstract class BeanComparator implements Comparator {
	/**
	 * the property of POJO object.
	 */
	protected String property;
	
	public BeanComparator(String property) {
		this.property = property;
	}
	
	public String getProperty() {
    	return property;
    }
	public void setProperty(String property) {
    	this.property = property;
    }
}
