package com.platform.gui.demo.mock.action;

import java.util.List;

import com.platform.gui.framework.action.ListTableAction;
import com.platform.gui.framework.tags.inter.DefaultDataRecordList;
import com.platform.gui.framework.tags.inter.IDataRecordList;
import com.platform.gui.framework.util.DataTableUtils;

public class MockTableGridAction extends ListTableAction<Object>{

	private static final long serialVersionUID = 1L;
	
	private String file;

	public String toList() throws Exception{
		return SUCCESS;
	}

	@Override
	public IDataRecordList<Object> registRecordDataList() throws Exception {
		List<Object> list = DataTableUtils.getTableDataFromFile(this.getFileName());
		return new DefaultDataRecordList<Object>(list);
	}

	@Override
	public String registRecordDataName() throws Exception {
		return "list";
	}
	
	private String getFileName() throws Exception{
		String file = this.getServletRequest().getParameter("file");
		if(file == null) throw new Exception("Please input the file name!");
		
		return this.getServletContext().getRealPath("/jsp/demo/mock/data/" + file + ".txt");
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

}
