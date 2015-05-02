package com.platform.gui.framework.smart.tags.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;

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
	public static List<SmartCell> getSmartCellList(ServletRequest request , IDataColumn dataColumn , IDataColumnDecorate columnDecorate) throws Exception{
		List<SmartCell> scs = new ArrayList<SmartCell>();
		List<DataColumn> columns = new ArrayList<DataColumn>();
		
        if(dataColumn != null){		
			//transfer the IDataColumn to SmartCell object
	        columns = dataColumn.getDataColumns();
        }else{
        	//get data column from request
        	Object obj = request.getAttribute(SmartConstants.DATA_COLUMN);
        	if(obj != null) columns = ((IDataColumn)obj).getDataColumns();
        }
        
        for(DataColumn column:columns){
            SmartCell cell = new SmartCell();
            cell.setName(column.getName());
            cell.setLabel(column.getLabel());
            cell.setValue(column.getValue());
            cell.setDisable(column.getDisable());
            
            IColumnDecorate decorate = SmartColumnDecorateUtil.getDecorate(request , columnDecorate , dataColumn , column.getName());
            cell.setColumnDecorate(decorate);

            scs.add(cell);
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
	public static Integer dataSize;
	
	@SuppressWarnings("unchecked")
	public static List<SmartRow> getSmartRowList(ServletRequest request , SmartTableContext context , IDataRecordList dataRecords  , FilterData filterData) throws Exception{
		List<SmartRow> srs = new ArrayList<SmartRow>();
		Map<String,String> parameters = context.getParameters();
		PreferenceConfigure configure = context.getConfigure();
		
		//get dataRecords
		IDataRecordList records = dataRecords;
		if(records == null){
			//get them from the request
			Object obj = request.getAttribute(SmartConstants.DATA);
			if(obj != null && obj instanceof IDataRecordList) records = (IDataRecordList)obj;
		}
		
		//get filter data
		FilterData fd = filterData;
		if(fd == null){
			//get it from the request
			Object obj = request.getAttribute(SmartConstants.FILTER_DATA);
			if(obj != null) fd = (FilterData)obj;
		}

		// if can not find the sort by and sort order in the parameters.
		// get the default value from the configure object.
		String sortBy = parameters.get(SmartConstants.PARAMS_SORT_BY);
		if(sortBy == null) sortBy = configure.getSortBy();
		
		String order = parameters.get(SmartConstants.PARAMS_SORT_ORDER);
		SortOrder sortOrder = SortOrderUtil.transfer(order);	

		// transfer IDataRecordList to SmartRow object
		// get the row data from the context
		List beans = new ArrayList();
		if(fd != null){
			//if the object implement the IEnableFilter interface. then get the data from the "getFilterRecords" method.
			if(records instanceof IEnableFilter){
				//change to IEnableFilter object
				IEnableFilter filterList = (IEnableFilter)records;
				
				dataSize = filterList.getFilterRecordSize(fd);				
				Integer beginIndex = getBeginIndex(dataSize , context);
				Integer endIndex = getEndIndex(dataSize , context);				
				
				//invoke the getFilterRecords method
				beans = filterList.getFilterRecords(fd , beginIndex , endIndex , sortBy, sortOrder);
			}
		}else{
			dataSize = records.getAllRecordSize();
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
	 * Get the begin index point
	 * @return
	 */
	private static Integer getBeginIndex(Integer dataSize , SmartTableContext context) throws Exception{
		PreferenceConfigure configure = context.getConfigure();
		Map<String,String> parameters = context.getParameters();
		
		Integer pageSize = configure.getPageSize();   
		String page = parameters.get(SmartConstants.PARAMS_PAGE);
        
		Integer pageIndex = (page != null)?Integer.parseInt(page):0;
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
