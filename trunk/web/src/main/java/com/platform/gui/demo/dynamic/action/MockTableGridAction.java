package com.platform.gui.demo.dynamic.action;

import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.framework.smart.action.AbstractAction;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.model.FilterData;

public class MockTableGridAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	private String type;
	
	private IDataRecordList<Object> dataRecords;

	private IDataColumn dataColumn;
	
	private IDataColumnDecorate dataColumnDecorate;
	
	private FilterData filterData;
	
	public String toList() throws Exception{	
		return SUCCESS;
	}

	@BeforeResult
	public void setData() throws Exception {
		String fileName = this.getFilePath() + "/" + "type" + type + ".txt";
		this.dataRecords = new MockDataRecordList(fileName);

		String columnName = this.getFilePath() + "/" + "columns.txt";
		this.dataColumn = new MockDataColumn(columnName , type);
		this.dataColumnDecorate = new MockDataColumn(columnName , type);
	}
    
	public IDataRecordList<Object> getDataRecords() {
		return dataRecords;
	}

	public void setDataRecords(IDataRecordList<Object> dataRecords) {
		this.dataRecords = dataRecords;
	}

	public IDataColumn getDataColumn() {
		return dataColumn;
	}

	public void setDataColumn(IDataColumn dataColumn) {
		this.dataColumn = dataColumn;
	}

	public IDataColumnDecorate getDataColumnDecorate() {
		return dataColumnDecorate;
	}

	public void setDataColumnDecorate(IDataColumnDecorate dataColumnDecorate) {
		this.dataColumnDecorate = dataColumnDecorate;
	}

	/**
	 * Get all of the data by its type
	 * @param dataType
	 * @return
	 * @throws Exception
	 */
	private String getFilePath() throws Exception{
		return this.getServletContext().getRealPath("/dynamic/data/");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FilterData getFilterData() {
		return filterData;
	}

	public void setFilterData(FilterData filterData) {
		this.filterData = filterData;
	}
	
	
}
