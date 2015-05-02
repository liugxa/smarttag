package com.platform.gui.framework.smart.tags.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnableFilter;
import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.util.I18NUtil;
import com.platform.gui.framework.smart.util.SortOrderUtil;

public class SmartTableGridUtil {
	/**
	 * PRIORITY
	 * Preference > JSP file > interface.
	 * TODO		
	 * JSP > interface
	 * if can not get the cells from the JSP, get it from the bean
	 * @return
	 * @throws Exception
	 */
	public static List<SmartCell> getSmartCellList(PageContext pageContext) throws Exception{
		List<SmartCell> scs = new ArrayList<SmartCell>();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		Object obj = request.getAttribute(SmartConstants.DATA_COLUMN);
		if(obj != null){
			IDataColumn dataRecord = (IDataColumn)obj;
			List<DataColumn> columns = dataRecord.getDataColumns();
			for(DataColumn column:columns){
				SmartCell cell = new SmartCell();
				cell.setName(column.getName());
				cell.setLabel(I18NUtil.getCellValue(pageContext, column.getLabel()));
				cell.setValue(column.getValue());
				
				IColumnDecorate decorate = SmartColumnDecorateUtil.getColumnDecorateFromBean(pageContext, column.getName());
				cell.setColumnDecorate(decorate);
				
				scs.add(cell);
			}
		}else{
			//can not get the columns, display all of the property of throw exception?
			//i choice to throw an exception
			throw new JspException("plase define the column in JSP file or register a DataColumn object which implement the IDataColumn interface.");
		}
		return scs;
	}
		
	/**
	 * PRIORITY:
	 * JSP file > interface			
	 * if user has define the data by user the "list" attribute, then get it at first
	 * TODO		
	 * get the row data from the context
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static List<SmartRow> getSmartRowList(PageContext pageContext , SmartTableGridContext context) throws Exception{
		List<SmartRow> srs = new ArrayList<SmartRow>();
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpSession session = pageContext.getSession();
		
		// PRIORITY:
		// JSP file > interface			
		// if user has define the data by user the "list" attribute, then get it at first
		// TODO
		
		// get the row data from the context
		Object data = request.getAttribute(SmartConstants.DATA); 
		if(data != null){
			IDataRecordList recordList = (IDataRecordList)data;
			PreferenceConfigure configure = context.getConfigure();

			String page = context.getParameters().get(SmartConstants.PAGE);
			String sortBy = context.getParameters().get(SmartConstants.SORTBY);
			String sortOrder = context.getParameters().get(SmartConstants.SORTORDER);
			
			List beans = new ArrayList();
			Object filter = session.getAttribute(SmartConstants.FILTER_DATA);
			if(filter != null){
				//if the object implement the IEnableFilter interface. then get the data from the "getFilterRecords" method.
				if(recordList instanceof IEnableFilter){
					//change to IEnableFilter object
					IEnableFilter filterList = (IEnableFilter)recordList;
					
					FilterData filterData = (FilterData)filter;
					Integer dataSize = filterList.getFilterRecordSize(filterData);
					
					Integer beginIndex = getBeginIndex(page , dataSize , configure);
					Integer endIndex = getEndIndex(page , dataSize , configure);				
					
					beans = filterList.getFilterRecords(filterData , beginIndex , endIndex , sortBy, SortOrderUtil.transfer(sortOrder));
				}
			}else{
				Integer dataSize = recordList.getAllRecordSize();
				
				Integer beginIndex = getBeginIndex(page , dataSize , configure);
				Integer endIndex = getEndIndex(page , dataSize , configure);
				
				beans = recordList.getRecords(beginIndex , endIndex , sortBy , SortOrderUtil.transfer(sortOrder));
			}
			
			// get the current page smart row object
			for (int i = 0; i < beans.size(); i++) {
				Object bean = beans.get(i);
				SmartRow row = new SmartRow();
				
				row.setObj(bean);
				srs.add(row);
			}
		}
		return srs;
	}
	
	
	/**
	 * Get the begin index point
	 * @return
	 */
	private static Integer getBeginIndex(String page , Integer dataSize , PreferenceConfigure configure) throws Exception{
		Integer pageIndex = (page != null)?Integer.parseInt(page):0;
		Integer beginIndex = pageIndex * configure.getPageSize();
		
		if(pageIndex <= 0) return 0;
		if(beginIndex >= dataSize) return dataSize;
		return beginIndex;
	}
	
	/**
	 * Get the end index point
	 * @return
	 */
	private static Integer getEndIndex(String page , Integer dataSize , PreferenceConfigure configure) throws Exception{
		Integer toIndex = getBeginIndex(page , dataSize , configure) + configure.getPageSize();
		return (toIndex >= dataSize)?dataSize:toIndex;
	}	
}
