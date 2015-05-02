package com.platform.gui.framework.smart.tags;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartCell;
import com.platform.gui.framework.smart.tags.model.SmartPagination;
import com.platform.gui.framework.smart.tags.model.SmartRow;
import com.platform.gui.framework.smart.tags.model.SmartRowAction;
import com.platform.gui.framework.smart.tags.model.SmartTableGrid;
import com.platform.gui.framework.smart.tags.util.SmartTableGridUtil;

public class SmartTableGridTag extends SmartElementTag{
	
	private Logger logger = Logger.getLogger(SmartTableGridTag.class);
	
	private static final long serialVersionUID = 1L;

	// Tag's Private objects
	/* Cell list of the table */
	private List<SmartCell> cells;

	/* Row list of the table */
	private List<SmartRow> rows;
	
	/* Row actions */
	private SmartRowAction rowAction;
	
	private SmartTableGrid table;
	
	/**
	 * doStartTag() method!
	 */
	public int doStartTag() throws JspException {
		cells = new ArrayList<SmartCell>();
		rows = new ArrayList<SmartRow>();
		
		rowAction = new SmartRowAction();
		table = new SmartTableGrid();
		
		return super.doStartTag();
	}

	/**
	 * doEndTag() method!
	 */

	public int doEndTag() throws JspException {
		try{
			SmartListTableTag parent = (SmartListTableTag)this.getParent();			
			SmartTableContext context = parent.getContext();
			
			// if can not get the cells from the JSP, get it from the bean
			if(cells.size() == 0) cells = SmartTableGridUtil.getSmartCellList(pageContext , context , parent.getDataColumn() , parent.getDataColumnDecorate());
			
			// get the row data from the context
			rows = SmartTableGridUtil.getSmartRowList(pageContext, context , parent.getDataRecords());
			
			// get data size
			Integer dataSize = context.getDataSize();
			
			// list table object
			table.setId(0);
			table.setName(name);
			table.setLabel(label);

			table.setValue(value);
			table.setContext(context);

			table.setCells(cells);	
			table.setRows(rows);
			
			SmartPagination pagination = new SmartPagination(context , dataSize);
			pagination.getFirstPage().setLabel(this.getText("st.list.table.pagination.first"));
			pagination.getCurrentPage().setLabel(this.getText("st.list.table.pagination.current"));
			pagination.getPreviousPage().setLabel(this.getText("st.list.table.pagination.previous"));
			pagination.getNextPage().setLabel(this.getText("st.list.table.pagination.next"));
			pagination.getLastPage().setLabel(this.getText("st.list.table.pagination.last"));
			table.setPagination(pagination);
			
			table.setTemplate(template);
			table.setTemplatePath(templatePath);
			
			table.setParent(parent.getList());
			parent.setTableGrid(table);
			return EVAL_PAGE;
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new JspException(e);
		}
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

	public SmartTableGrid getTable() {
		return table;
	}

	public void setTable(SmartTableGrid table) {
		this.table = table;
	}
}
