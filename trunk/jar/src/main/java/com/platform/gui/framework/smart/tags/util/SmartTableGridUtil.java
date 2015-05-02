package com.platform.gui.framework.smart.tags.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.comparator.SortOrder;
import com.platform.gui.framework.smart.inter.IColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.inter.IEnableFilter;
import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;
import com.platform.gui.framework.smart.util.FilterDataUtil;
import com.platform.gui.framework.smart.util.SortOrderUtil;

public class SmartTableGridUtil {
	
	private static Logger logger = Logger.getLogger(SmartTableGridUtil.class);
	/**
	 * Get Smart table if user do not define <pf:table/> in JSP file
	 * @param pageContext
	 * @param context
	 * @param dataRecords
	 * @param dataColumn
	 * @param columnDecorate
	 * @return
	 * @throws Exception
	 */
	public static SmartTableGrid getSmartTable(SmartTableContext context , IDataRecordList<?> dataRecords , IDataColumn dataColumn , IDataColumnDecorate columnDecorate) throws Exception{
		SmartTableGrid table = null;
		if(dataColumn != null){
			// if can not get the cells from the JSP, get it from the bean
			List<SmartCell> cells = getSmartCellList(context , dataColumn , columnDecorate);
			
			// get the row data from the context
			List<SmartRow> rows = getSmartRowList(context , dataRecords);
			
			// list table object
			table = new SmartTableGrid(context , rows , cells);
		}
		return table;
	}
	
	/**
	 * PRIORITY
	 * Preference > JSP file > interface.
	 * TODO		
	 * JSP > interface
	 * if can not get the cells from the JSP, get it from the bean
	 * @return
	 * @throws Exception
	 */
	public static List<SmartCell> getSmartCellList(SmartTableContext context , IDataColumn dataColumn , IDataColumnDecorate columnDecorate) throws Exception{
		PageContext pageContext = context.getPageContext();
		
		List<SmartCell> scs = new ArrayList<SmartCell>();
		List<DataColumn> columns = new ArrayList<DataColumn>();
		
		if(dataColumn != null){		
			//transfer the IDataColumn to SmartCell object
			columns = dataColumn.getDataColumns();
		}else{
			//get data column from request
			
			Object obj = pageContext.getRequest().getAttribute(SmartConstants.DATA_COLUMN);
			if(obj != null) columns = ((IDataColumn)obj).getDataColumns();
		}
		
		for(DataColumn column:columns){
			SmartCell cell = new SmartCell();
			BeanUtils.copyProperties(cell , column);
			
			//get the decorate from the column object directly.
			IColumnDecorate decorate = column.getColumnDecorate();
			if(decorate == null){
				//get the default decorate if the "decorate" column has been defined	
				decorate = SmartColumnDecorateUtil.getDefaultDecorate(column.getDecorate(), column.getParameters());
				
				//still can not find it! So,get it from the interface - IDataColumnDecorate
				if(decorate == null){
					decorate = SmartColumnDecorateUtil.getDecorateFromBean(context , columnDecorate , dataColumn , cell);
				}
				cell.setColumnDecorate(decorate);
			}
			scs.add(cell);
		}
		return scs;
	}
	
		
	/**
	 * PRIORITY:context
	 * JSP file > interface			
	 * if user has define the data by user the "list" attribute, then get it at first
	 * TODO		
	 * get the row data from the context
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static List<SmartRow> getSmartRowList(SmartTableContext context , IDataRecordList<?> dataRecords) throws Exception{
		PageContext pageContext = context.getPageContext();
		List<SmartRow> srs = new ArrayList<SmartRow>();
		
		Map<String,String> parameters = context.getParameters();
		PreferenceConfigure configure = context.getConfigure();
		
		//get dataRecords
		IDataRecordList<?> records = dataRecords;
		if(records == null){
			//get them from the request
			Object obj = pageContext.getRequest().getAttribute(SmartConstants.DATA);
			if(obj != null && obj instanceof IDataRecordList) records = (IDataRecordList<?>)obj;
		}
		
		//get filter data
		//get it from the request
		String filterName = parameters.get(SmartConstants.PARAM_NAME);
		FilterData fd = FilterDataUtil.getFilterData(pageContext , filterName);

		// if can not find the sort by and sort order in the parameters.
		// get the default value from the configure object.
		String sortBy = parameters.get(SmartConstants.PARAMS_SORT_BY);
		if(sortBy == null) sortBy = configure.getSortBy();
		
		String order = parameters.get(SmartConstants.PARAMS_SORT_ORDER);
		if(order == null) order = configure.getSortOrder();
		SortOrder sortOrder = SortOrderUtil.transfer(order);	

		// transfer IDataRecordList to SmartRow object
		// get the row data from the context
		List beans = new ArrayList();
		if(fd != null){
			//if the object implement the IEnableFilter interface. then get the data from the "getFilterRecords" method.
			if(records instanceof IEnableFilter){
				//change to IEnableFilter object
				IEnableFilter<?> filterList = (IEnableFilter<?>)records;
				
				Integer dataSize = filterList.getFilterRecordSize(fd);				
				Integer beginIndex = getBeginIndex(dataSize , context);
				Integer endIndex = getEndIndex(dataSize , context);				
				
				//invoke the getFilterRecords method
				beans = filterList.getFilterRecords(fd , beginIndex , endIndex , sortBy, sortOrder);
			}
		}else{
			Integer dataSize = records.getAllRecordSize();
			Integer beginIndex = getBeginIndex(dataSize , context);
			Integer endIndex = getEndIndex(dataSize , context);
			
			//invoke the getRecords method
			beans = records.getRecords(beginIndex , endIndex , sortBy , sortOrder);
		}
		
		// get the current page smart row object
		for (int i = 0; i < beans.size(); i++) {
			Object bean = beans.get(i);
			SmartRow row = new SmartRow();
			
			row.setObj(bean);
			srs.add(row);
		}
		return srs;
	}

	/**
	 * Get data size
	 * @param pageContext
	 * @param dataRecords
	 * @param filterData
	 * @return
	 * @throws Exception
	 */
	public static Integer getSmartDataSize(PageContext pageContext , Map<String,String> parameters , IDataRecordList<?> dataRecords) throws Exception{
		Integer dataSize = 0;
		
		//get dataRecords
		IDataRecordList<?> records = dataRecords;
		if(records == null){
			//get them from the request
			Object obj = pageContext.getRequest().getAttribute(SmartConstants.DATA);
			if(obj != null && obj instanceof IDataRecordList<?>) records = (IDataRecordList<?>)obj;
		}
		
		//get filter data
		//get it from the request
		String filterName = parameters.get(SmartConstants.PARAM_NAME);
		FilterData fd = FilterDataUtil.getFilterData(pageContext , filterName);
		if(fd != null){
			//if the object implement the IEnableFilter interface. then get the data from the "getFilterRecords" method.
			if(records instanceof IEnableFilter<?>){
				//change to IEnableFilter object
				IEnableFilter<?> filterList = (IEnableFilter<?>)records;
				dataSize = filterList.getFilterRecordSize(fd);
			}
		}else{
			dataSize = records.getAllRecordSize();
		}
		return dataSize;
	}
	
	

	
	/**
	 * Get the begin index point
	 * @return
	 */
	private static Integer getBeginIndex(Integer dataSize , SmartTableContext context) throws Exception{
		PreferenceConfigure configure = context.getConfigure();
		Map<String,String> parameters = context.getParameters();
		
		Locale locale = context.getPageContext().getResponse().getLocale();
		NumberFormat format = NumberFormat.getInstance(locale);
		
		Integer pageSize = configure.getPageSize();   
		String page = parameters.get(SmartConstants.PARAMS_PAGE);
		
		Integer pageIndex = 0;
		if(page != null) pageIndex = format.parse(page).intValue();
		Integer beginIndex = pageIndex * pageSize;
		
		if(pageIndex <= 0) return 0;
		if(beginIndex >= dataSize) return dataSize;
		return beginIndex;
	}
	
	/**
	 * Get the end index point
	 * @return
	 */
	private static Integer getEndIndex(Integer dataSize , SmartTableContext context) throws Exception{
		PreferenceConfigure configure = context.getConfigure();
		Integer toIndex = getBeginIndex(dataSize , context) + configure.getPageSize();
		return (toIndex >= dataSize)?dataSize:toIndex;
	}
}
