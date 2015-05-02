package com.platform.gui.framework.smart.util;

import java.util.Collections;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.platform.gui.framework.smart.comparator.GenericComparator;
import com.platform.gui.framework.smart.comparator.SortOrder;


/**
 * A Sorter that provice sort method to sort a List<Object> collection by a or
 * series property of this Object instance.
 * <p>
 * By default, it support String, short, int, long, float, double, byte, char,
 * boolean and Date type.
 * 
 * @author fkong
 * 
 */

public class Sorter<T> {
	
	 private Log logger = LogFactory.getLog(Sorter.class);
	
//	/**
//	 * Sort the objects in list with the given propertis of the object.   
//	 * @param <T> 
//	 * @param list the same kind of Object collection
//	 * @param properties the property array of Object 
//	 * @param sortOrder sort type, ASC or DESC
//	 * @throws SortException
//	 */
//	public <T> void sort(List<T> list, String[] properties, SortOrder sortOrder) throws SortException {
//		if(list == null || properties == null || list.size() == 0 || properties.length == 0) return;
//		
//		try{
//			// item object
//			Class clazz = list.get(0).getClass();
//			
//			// sort with the first property 
//			sort(list, properties[0], sortOrder);
//			
//			// If the only sort by one property, return
//			if( properties.length == 1 ) {
//				return ;
//			}
//	
//			// skip the first 
//			for(int idxProp = 1 ; idxProp < properties.length  ; idxProp++ ) {
//				String preProp = properties[idxProp - 1];
//				String prop = properties[idxProp];
//				
//				Comparator comparator = ComparatorFactory.getComparator(clazz, preProp);
//				
//				List<T> tmpList = new ArrayList<T>();
//				int idx = -1;
//				for( int idxObj = 1 ; idxObj < list.size(); idxObj ++) {
//					if( comparator.compare(list.get(idxObj - 1), list.get(idxObj)) == 0 ) {
//						if( idx == -1 ) {// record the first same item
//							idx = idxObj - 1;
//						}
//						if( tmpList.isEmpty() ) {
//							tmpList.add(list.get(idxObj - 1));	
//						}
//						tmpList.add(list.get(idxObj));
//						if( idxObj == list.size() - 1 ) {
//							sort(tmpList, prop, sortOrder);
//							for( int i = 0 ; i < tmpList.size() ; i++) {
//								list.set(idx + i, tmpList.get(i));
//							}
//							idx = -1;
//							tmpList.clear();
//						}
//					} else {
//						if( !tmpList.isEmpty() ) {
//							sort(tmpList, prop, sortOrder);
//							for( int i = 0 ; i < tmpList.size() ; i++) {
//								list.set(idx + i, tmpList.get(i));
//							}
//							idx = -1;
//							tmpList.clear();
//						}
//					}
//				}// end for idxObj
//			}// end for idxProp
//		}catch(Exception e){
//			throw new SortException(e);
//		}
//	}
	
	
	/**
	 * Sort and order the list collection, the list could be any same type Object. 
	 * @param list the same type object collection.
	 * @param property the property name of the object in list
	 * @param sortOrder sort type, see SortOrder enum type
	 */
	public void sort(List<T> list, String property, SortOrder sortOrder) throws Exception {
		if(list == null || list.size() == 0) return;
		if(property == null || property.equals("")) return;
		try{
			GenericComparator<T> comparator = new GenericComparator<T>(property);
			Collections.sort(list, comparator);
			if( sortOrder == SortOrder.DESC ) {
				Collections.reverse(list);
			}
		}catch(Exception e){
			//ignore it!
			logger.error(e.getMessage());
		}
	}

	/**
	 * Sort the list collection, the list could be any same type Object. 
	 * @param list the same type object collection.
	 * @param property the property name of the object in list
	 * @throws Exception
	 */
	public void sort(List<T> list, String property) throws Exception {
		if(list == null || list.size() == 0) return;
		if(property == null || property.equals("")) return;
		try{
			GenericComparator<T> comparator = new GenericComparator<T>(property);
			Collections.sort(list, comparator);
		}catch(Exception e){
			//ignore it!
			logger.error(e.getMessage());
		}
	}

	/**
	 * Order the list collection, the list could be any same type Object. 
	 * @param list the same type object collection.
	 * @param sortOrder sort type, see SortOrder enum type
	 * @throws Exception
	 */
	public void order(List<T> list , SortOrder sortOrder) throws Exception {
		try{
			if( sortOrder == SortOrder.DESC ) {
				Collections.reverse(list);
			}
		}catch(Exception e){
			//ignore it!
			logger.error(e.getMessage());
		}
	}
}
