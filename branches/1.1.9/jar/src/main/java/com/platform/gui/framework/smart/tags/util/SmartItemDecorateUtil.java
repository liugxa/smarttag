package com.platform.gui.framework.smart.tags.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataItem;
import com.platform.gui.framework.smart.inter.IDataItemDecorate;
import com.platform.gui.framework.smart.inter.IItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.CheckboxItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.DefaultItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.InputItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.RadioItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.SelectItemDecorate;
import com.platform.gui.framework.smart.inter.impl.item.TimeItemDecorate;
import com.platform.gui.framework.smart.tags.model.SmartItem;

public class SmartItemDecorateUtil {

	/**
	 * Get item decorate from java bean
	 * @param pageContext
	 * @param columnDecorate
	 * @param dataColumn
	 * @param cell
	 * @return
	 * @throws Exception
	 */
	public static IItemDecorate getDecorateFromBean(PageContext pageContext, IDataItemDecorate itemDecorate , 
			IDataItem dataItem, SmartItem item) throws Exception{
		IDataItemDecorate did = itemDecorate;
		if(did == null){
			//get decorate from data column object
			if(dataItem != null && dataItem instanceof IDataItemDecorate){
				did = (IDataItemDecorate)dataItem;
			}else{
				//get decorate from the request
				Object obj = pageContext.getRequest().getAttribute(SmartConstants.DATA_ITEM_DECORATE);
				if(obj != null && obj instanceof IDataItemDecorate){
					did = (IDataItemDecorate)obj;
				}else{
					//get from data column
					Object column = pageContext.getRequest().getAttribute(SmartConstants.DATA_ITEM);
					if(column != null && column instanceof IDataItemDecorate){
						did = (IDataItemDecorate)column;
					}
				}
			}
		}
		
		IItemDecorate decorate = new DefaultItemDecorate();
		if(did != null){
			//if user define the key property, send the key value. Otherwise, send cell's name.
			String key = item.getKey();
			if(key != null){
				decorate =  did.getItemDecorate(key);
			}else{
				decorate = did.getItemDecorate(item.getName());
			}
		}
		return decorate;
	}

	/**
	 * Get item decorate from the tag bean defined
	 * @param bean
	 * @param columnName
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static IItemDecorate getDefaultDecorate(String decorateName , String parameters) throws JspException{
		//get he default decorate by the column type.
		IItemDecorate decorate = null;
		
		//get the decorate by keywords
		if(decorateName != null){
			if(decorateName.equalsIgnoreCase("checkbox")){
				decorate = new CheckboxItemDecorate(parameters);
			}
            else if(decorateName.equalsIgnoreCase("select")){
                decorate = new SelectItemDecorate(parameters);
            }
            else if(decorateName.equalsIgnoreCase("radio")){
                decorate = new RadioItemDecorate(parameters);
            }
            else if(decorateName.equalsIgnoreCase("input")){
                decorate = new InputItemDecorate();
            }
            else if(decorateName.equalsIgnoreCase("time")){
                decorate = new TimeItemDecorate(parameters);
            }
		}
		
		return decorate;
	}
	
	/**
	 * Get item decorate from the tag bean defined
	 * @param bean
	 * @param columnName
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static IItemDecorate getDecorateFromJsp(PageContext pageContext , IDataItemDecorate itemDecorate , 
			IDataItem dataItem , SmartItem item) throws Exception{
		String decorateStr = item.getDecorate();
		String parameters = item.getParameters();
		
		//get he default decorate by the column type.
		IItemDecorate decorate = new DefaultItemDecorate();
		
		//get the decorate by keywords
		if(decorateStr != null){
			decorate = getDefaultDecorate(decorateStr , parameters);
		}else{
			decorate = getDecorateFromBean(pageContext , itemDecorate , dataItem , item);
		}
		
		return decorate;
	}
}
