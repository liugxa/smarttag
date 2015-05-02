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
import com.platform.gui.framework.smart.inter.impl.InputColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.NumberColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.PrecentColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.RadioColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.SelectColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.SummaryColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.URLColumnDecorate;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;

public class SmartColumnDecorateUtil {

	public static IColumnDecorate getDecorateFromBean(SmartTableContext context , IDataColumnDecorate columnDecorate , 
			IDataColumn dataColumn, SmartCell cell) throws Exception{
		PageContext pageContext = context.getPageContext();
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
			String name = cell.getName();
			decorate = dcd.getColumnDecorate(name);
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
            else if(decorateName.equalsIgnoreCase("input")){
            	decorate = new InputColumnDecorate(parameters);
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
	public static IColumnDecorate getDecorateFromJsp(SmartTableContext context , IDataColumnDecorate columnDecorate , 
			IDataColumn dataColumn , SmartCell cell) throws Exception{
		String cellDecorate = cell.getDecorate();
		String parameters = cell.getParameters();
		
		//get he default decorate by the column type.
		IColumnDecorate decorate = new DefaultColumnDecorate();
		
		//get the decorate by keywords
		if(cellDecorate != null){
			decorate = getDefaultDecorate(cellDecorate , parameters);
		}else{
			decorate = getDecorateFromBean(context , columnDecorate , dataColumn , cell);
		}
		
		return decorate;
	}
}
