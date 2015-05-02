package com.platform.gui.demo.mock.action;

import com.platform.gui.framework.smart.action.ListTableAction;
import com.platform.gui.framework.smart.inter.IDataColumn;
import com.platform.gui.framework.smart.inter.IDataRecordList;

public class MockTableGridAction extends ListTableAction<Object>{

	private static final long serialVersionUID = 1L;
	
	private String type;
	
	public String toList() throws Exception{
		return SUCCESS;
	}

	@Override
	public IDataRecordList<Object> registRecordDataList() throws Exception {
		String fileName = this.getFilePath() + "/" + "type" + type + ".txt";
		return new MockDataRecordList(fileName);
	}
	

	@Override
	public IDataColumn registDataColumn() throws Exception {
		String fileName = this.getFilePath() + "/" + "columns.txt";
		return new MockDataColumn(fileName , type);
	}
	
	/**
	 * Get all of the data by its type
	 * @param dataType
	 * @return
	 * @throws Exception
	 */
	private String getFilePath() throws Exception{
		return this.getServletContext().getRealPath("/jsp/demo/mock/data/");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
