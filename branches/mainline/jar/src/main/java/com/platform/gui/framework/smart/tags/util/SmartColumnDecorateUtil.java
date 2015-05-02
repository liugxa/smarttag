package com.platform.gui.framework.smart.tags.util;

import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.CheckboxColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.DateColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.DefaultColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.NumberColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.PrecentColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.RadioColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.SelectColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.URLColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;

public class SmartColumnDecorateUtil {

	private static Logger logger = Logger.getLogger(SmartColumnDecorateUtil.class);
	
	public static IColumnDecorate getDecorate(PageContext pageContext , IDataColumnDecorate columnDecorate , 
			IDataColumn dataColumn, String columnName) throws Exception{
		try{
			IDataColumnDecorate dcd = columnDecorate;
			if(dcd == null){
				//get decorate from data column object
				if(dataColumn != null && dataColumn instanceof IDataColumnDecorate){
					dcd = (IDataColumnDecorate)dataColumn;
				}else{
					//get decorate from the request
					Object obj = pageContext.findAttribute(SmartConstants.DATA_COLUMN_DECORATE);
					if(obj != null && obj instanceof IDataColumnDecorate){
						dcd = (IDataColumnDecorate)obj;
					}else{
						//get from data column
						Object column = pageContext.findAttribute(SmartConstants.DATA_COLUMN);
						if(column != null && column instanceof IDataColumnDecorate){
							dcd = (IDataColumnDecorate)column;
						}
					}
				}
			}
			
			IColumnDecorate decorate = new DefaultColumnDecorate();
			if(dcd != null) decorate =  dcd.getColumnDecorate(columnName);
			return decorate;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * Get decorate from the tag bean defined
	 * @param bean
	 * @param columnName
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static IColumnDecorate getDecorate(PageContext pageContext , IDataColumnDecorate columnDecorate , 
			IDataColumn dataColumn , SmartCell cell) throws Exception{
		try{
			IColumnDecorate decorate = new DefaultColumnDecorate();
			
			if(cell != null){
				String cellDecorate = cell.getDecorate();
				String parameters = cell.getParameters();
				
				//get the decorate by keywords
				if(cellDecorate != null){
					if(cellDecorate.equalsIgnoreCase("percent")){
						decorate = new PrecentColumnDecorate();
					}
					else if(cellDecorate.equalsIgnoreCase("date")){
						decorate = new DateColumnDecorate(parameters);
					}
					else if(cellDecorate.equalsIgnoreCase("number")){
						decorate = new NumberColumnDecorate(parameters);
					}
					else if(cellDecorate.equalsIgnoreCase("link")){
						decorate = new URLColumnDecorate(parameters);
					}
					else if(cellDecorate.equalsIgnoreCase("checkbox")){
						decorate = new CheckboxColumnDecorate();
					}
		            else if(cellDecorate.equalsIgnoreCase("select")){
		                decorate = new SelectColumnDecorate();
		            }
		            else if(cellDecorate.equalsIgnoreCase("radio")){
		                decorate = new RadioColumnDecorate();
		            }
				}else{
					decorate = getDecorate(pageContext , columnDecorate , dataColumn , cell.getName());
				}
			}
			return decorate;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw e;
		}
	}
}
