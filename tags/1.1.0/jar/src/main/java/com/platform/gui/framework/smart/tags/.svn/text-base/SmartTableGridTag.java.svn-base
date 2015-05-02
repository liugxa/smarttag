package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.model.DataColumn;
import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartRowAction;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;
import com.platform.gui.framework.smart.util.SortOrderUtil;

@SuppressWarnings("unchecked")
public class SmartTableGridTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	
	// Tag Attributes
	/* the name of the list bean */
	private String list;

	/* the default sort by column */
	private String sortBy;

	/* display the radio/check or not none(default) */
	private String multiple;

	/* the table's primary key */
	private String primaryKey;

	// Tag's Private objects
	/* Cell list of the table */
	private List<SmartCell> cells;

	/* Row list of the table */
	private List<SmartRow> rows;
	
	/* Row actions */
	private SmartRowAction rowAction;

	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		// new instance the cells and rows object, because the object of the tag
		// will be shared in every time.
		cells = new ArrayList<SmartCell>();
		rows = new ArrayList<SmartRow>();
		rowAction = new SmartRowAction();
		
		return EVAL_BODY_INCLUDE;
	}

	/**
	 * doEndTag() method!
	 */

	public int doEndTag() throws JspException {
		try{
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			HttpSession session = pageContext.getSession();
			
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			SmartTableGridContext context = parent.getContext();
			
			// PRIORITY
			// Preference > JSP file > interface.
			// TODO
			
			// JSP > interface
			// if can not get the cells from the JSP, get it from the bean
			if(cells.size() == 0){
				Object obj = request.getAttribute(SmartConstants.DATA_COLUMN);
				if(obj != null){
					IDataColumn dataColumn = (IDataColumn)obj;
					List<DataColumn> columns = dataColumn.getDataColumn();
					for(DataColumn column:columns){
						SmartCell cell = new SmartCell();
						cell.setName(column.getName());
						cell.setValue(column.getValue());
						cell.setColumnDecorate(dataColumn.getColumnDecorate(column.getName()));
						cells.add(cell);
					}
				}else{
					//can not get the columns, display all of the property of throw exception?
					//i choice to throw an exception
					throw new JspException("plase define the column in JSP file or register a DataColumn object which implement the IDataColumn interface.");
				}
			}
			
			// PRIORITY:
			// JSP file > interface			
			// if user has define the data by user the "list" attribute, then get it at first
			// TODO
			
			// get the row data from the context
			Object data = request.getAttribute(SmartConstants.DATA); 
			if(data != null){
				IDataRecordList recordList = (IDataRecordList)data;
				PreferenceConfigure configure = context.getConfigure();

				String page = context.getParameters().get("page");
				String sortBy = context.getParameters().get("sortBy");
				String sortOrder = context.getParameters().get("sortOrder");
				
				List beans = new ArrayList();
				Object filter = session.getAttribute(SmartConstants.FILTER_DATA);
				if(filter != null){
					FilterData filterData = (FilterData)filter;
					Integer dataSize = recordList.getFilterRecordSize(filterData);
					
					Integer beginIndex = this.getBeginIndex(page , dataSize , configure);
					Integer endIndex = this.getEndIndex(page , dataSize , configure);				
					
					beans = recordList.getFilterRecords(filterData , beginIndex , endIndex , sortBy, SortOrderUtil.transfer(sortOrder));	
				}else{
					Integer dataSize = recordList.getAllRecordSize();
					
					Integer beginIndex = this.getBeginIndex(page , dataSize , configure);
					Integer endIndex = this.getEndIndex(page , dataSize , configure);
					
					beans = recordList.getRecords(beginIndex , endIndex , sortBy , SortOrderUtil.transfer(sortOrder));
				}
				
				// get the current page smart row object
				for (int i = 0; i < beans.size(); i++) {
					Object bean = beans.get(i);
					SmartRow row = new SmartRow();
					
					//set it's checked or not
					Set<String> checkedRecords = context.getCheckedRecords();
					if(checkedRecords != null){
						String primaryValue = BeanUtils.getProperty(bean, primaryKey);
						if(checkedRecords.contains(primaryValue)) row.setIsChecked(true);
					}
					row.setObj(beans.get(i));
					rows.add(row);
				}
				
				// list table object
				SmartTableGrid tableGrid = new SmartTableGrid(context , rows , cells , rowAction , multiple , primaryKey);
	
				// transfer the parameters to its parent
				parent.setTableGrid(tableGrid);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new JspException(e);
		}
		return EVAL_PAGE;
	}
	
	
	/**
	 * Get the begin index point
	 * @return
	 */
	public Integer getBeginIndex(String page , Integer dataSize , PreferenceConfigure configure) throws Exception{
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
	public Integer getEndIndex(String page , Integer dataSize , PreferenceConfigure configure) throws Exception{
		Integer toIndex = this.getBeginIndex(page , dataSize , configure) + configure.getPageSize();
		return (toIndex >= dataSize)?dataSize:toIndex;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getMultiple() {
		return multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}
	
	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public List<SmartCell> getCells() {
		return cells;
	}

	public void setCells(List<SmartCell> cells) {
		this.cells = cells;
	}

	public List<SmartRow> getRows() {
		return rows;
	}

	public void setRows(List<SmartRow> rows) {
		this.rows = rows;
	}

	public SmartRowAction getRowAction() {
		return rowAction;
	}

	public void setRowAction(SmartRowAction rowAction) {
		this.rowAction = rowAction;
	}
}
