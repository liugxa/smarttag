package com.platform.gui.framework.smart.tags.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IEnableDecorate;
import com.platform.gui.framework.smart.inter.impl.CheckboxColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.DateColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.DefaultColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.NumberColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.PrecentColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.SelectColumnDecorate;
import com.platform.gui.framework.smart.inter.impl.URLColumnDecorate;
import com.platform.gui.framework.smart.tags.model.SmartCell;

public class SmartColumnDecorateUtil {

	public static IColumnDecorate getColumnDecorateFromBean(PageContext pageContext , String columnName){
		IColumnDecorate decorate = new DefaultColumnDecorate();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		
		//get the decorate from the JSP file

        //get the decorate from the IColumnDecorate object
		Object cd = request.getAttribute(SmartConstants.DATA_COLUMN_DECORATE);
		if(cd != null && cd instanceof IEnableDecorate){
			decorate = ((IEnableDecorate)cd).getColumnDecorate(columnName);
		}
        else{
    		//get the decorate from the IDataColumn object
    		Object obj = request.getAttribute(SmartConstants.DATA_COLUMN);
        	if(obj != null && obj instanceof IEnableDecorate){
    			decorate = ((IEnableDecorate)obj).getColumnDecorate(columnName);
    		}
            else{
        		//get the decorate from the IDataRecordList object
        		Object data = request.getAttribute(SmartConstants.DATA);
        		if(data != null && data instanceof IEnableDecorate){
        			decorate = ((IEnableDecorate)data).getColumnDecorate(columnName);
        		}
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
	public static IColumnDecorate getColumnDecorateFromJSP(PageContext pageContext , SmartCell cell) throws JspException{
		String cellDecorate = cell.getDecorate();
		String cellFormat = cell.getFormat();
		String cellUrl = cell.getUrl();
		
		//get he default decorate by the column type.
		IColumnDecorate decorate = new DefaultColumnDecorate();
		
		//get the decorate by keywords
		if(cellDecorate != null){
			if(cellDecorate.equalsIgnoreCase("percent")){
				decorate = new PrecentColumnDecorate();
			}
			else if(cellDecorate.equalsIgnoreCase("date")){
				decorate = new DateColumnDecorate(cellFormat);
			}
			else if(cellDecorate.equalsIgnoreCase("number")){
				decorate = new NumberColumnDecorate(cellFormat);
			}
			else if(cellDecorate.equalsIgnoreCase("link")){
				decorate = new URLColumnDecorate(cellUrl);
			}
			else if(cellDecorate.equalsIgnoreCase("checkbox")){
				decorate = new CheckboxColumnDecorate();
			}
            else if(cellDecorate.equalsIgnoreCase("select")){
                decorate = new SelectColumnDecorate();
            }
		}else{
			decorate = getColumnDecorateFromBean(pageContext, cell.getName());
		}
		
		return decorate;
	}
}
