package com.platform.gui.framework.smart.tags.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

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
import com.platform.gui.framework.smart.inter.impl.SummaryColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.URLColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;

public class SmartColumnDecorateUtil {

	public static IColumnDecorate getDecorateFromBean(PageContext pageContext, IDataColumnDecorate columnDecorate , 
			IDataColumn dataColumn, SmartCell cell){
		IDataColumnDecorate dcd = columnDecorate;
		if(dcd == null){
			//get decorate from data column object
			if(dataColumn != null && dataColumn instanceof IDataColumnDecorate){
				dcd = (IDataColumnDecorate)dataColumn;
			}else{
				//get decorate from the request
				Object obj = pageContext.getRequest().getAttribute(SmartConstants.DATA_COLUMN_DECORATE);
				if(obj != null && obj instanceof IDataColumnDecorate){
					dcd = (IDataColumnDecorate)obj;
				}else{
					//get from data column
					Object column = pageContext.getRequest().getAttribute(SmartConstants.DATA_COLUMN);
					if(column != null && column instanceof IDataColumnDecorate){
						dcd = (IDataColumnDecorate)column;
					}
				}
			}
		}
		
		IColumnDecorate decorate = new DefaultColumnDecorate();
		if(dcd != null){
			//if user define the key property, send the key value. Otherwise, send cell's name.
			String key = cell.getKey();
			if(key != null){
				decorate =  dcd.getColumnDecorate(key);
			}else{
				String name = cell.getName();
				decorate = dcd.getColumnDecorate(name);
			}
		}
		return decorate;
	}

	/**
	 * Get decorate from the tag bean defined
	 * @param bean
	 * @param columnName
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static IColumnDecorate getDefaultDecorate(String decorateName , String parameters) throws JspException{
		//get he default decorate by the column type.
		IColumnDecorate decorate = null;
		
		//get the decorate by keywords
		if(decorateName != null){
			if(decorateName.equalsIgnoreCase("percent")){
				decorate = new PrecentColumnDecorate(parameters);
			}
			else if(decorateName.equalsIgnoreCase("date")){
				decorate = new DateColumnDecorate(parameters);
			}
			else if(decorateName.equalsIgnoreCase("number")){
				decorate = new NumberColumnDecorate(parameters);
			}
			else if(decorateName.equalsIgnoreCase("link")){
				decorate = new URLColumnDecorate(parameters);
			}
			else if(decorateName.equalsIgnoreCase("checkbox")){
				decorate = new CheckboxColumnDecorate(parameters);
			}
			else if(decorateName.equalsIgnoreCase("checkbox-all")){
				decorate = new CheckboxColumnDecorate(parameters);
			}
            else if(decorateName.equalsIgnoreCase("select")){
                decorate = new SelectColumnDecorate(parameters);
            }
            else if(decorateName.equalsIgnoreCase("radio")){
                decorate = new RadioColumnDecorate(parameters);
            }
            else if(decorateName.equalsIgnoreCase("summary")){
                decorate = new SummaryColumnDecorate(parameters);
            }
		}
		
		return decorate;
	}
	
	/**
	 * Get decorate from the tag bean defined
	 * @param bean
	 * @param columnName
	 * @param pattern
	 * @return
	 * @throws Exception
	 */
	public static IColumnDecorate getDecorateFromJsp(PageContext pageContext , IDataColumnDecorate columnDecorate , 
			IDataColumn dataColumn , SmartCell cell) throws JspException{
		String cellDecorate = cell.getDecorate();
		String parameters = cell.getParameters();
		
		String cellFormat = cell.getFormat();
		String cellUrl = cell.getUrl();
		
		//get he default decorate by the column type.
		IColumnDecorate decorate = new DefaultColumnDecorate();
		
		//get the decorate by keywords
		if(cellDecorate != null){
			if(cellDecorate.equalsIgnoreCase("percent")){
				decorate = new PrecentColumnDecorate(parameters);
			}
			else if(cellDecorate.equalsIgnoreCase("date")){
				if(cellFormat != null){
					decorate = new DateColumnDecorate(cellFormat);
				}else{
					decorate = new DateColumnDecorate(parameters);
				}
			}
			else if(cellDecorate.equalsIgnoreCase("number")){
				if(cellFormat != null){
					decorate = new NumberColumnDecorate(cellFormat);
				}else{
					decorate = new NumberColumnDecorate(parameters);
				}
			}
			else if(cellDecorate.equalsIgnoreCase("link")){
				if(cellUrl != null){
					decorate = new URLColumnDecorate(cellUrl);
				}else{
					decorate = new URLColumnDecorate(parameters);
				}
			}
			else if(cellDecorate.equalsIgnoreCase("checkbox")){
				decorate = new CheckboxColumnDecorate(parameters);
			}
			else if(cellDecorate.equalsIgnoreCase("checkbox-all")){
				decorate = new CheckboxColumnDecorate(parameters);
			}
            else if(cellDecorate.equalsIgnoreCase("select")){
                decorate = new SelectColumnDecorate(parameters);
            }
            else if(cellDecorate.equalsIgnoreCase("radio")){
                decorate = new RadioColumnDecorate(parameters);
            }
            else if(cellDecorate.equalsIgnoreCase("summary")){
                decorate = new SummaryColumnDecorate(parameters);
            }
		}else{
			decorate = getDecorateFromBean(pageContext , columnDecorate , dataColumn , cell);
		}
		
		return decorate;
	}
}
