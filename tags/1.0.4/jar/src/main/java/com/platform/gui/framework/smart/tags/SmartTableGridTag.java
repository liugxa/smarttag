package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.BeanUtils;

import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartRowAction;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;

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
	@SuppressWarnings("unchecked")
	public int doEndTag() throws JspException {
		try{
			SmartListTableTag parent = (SmartListTableTag)this.getParent();
			SmartTableGridContext context = parent.getContext();
			
			// get the row data from the context
			List beans = (List) this.pageContext.findAttribute(list);
			if(beans != null){
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
