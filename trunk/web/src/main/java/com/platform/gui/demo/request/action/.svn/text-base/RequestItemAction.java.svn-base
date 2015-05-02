package com.platform.gui.demo.request.action;

import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.demo.request.model.Request;
import com.platform.gui.demo.request.model.RequestDataItem;
import com.platform.gui.demo.request.model.RequestDataRecordList;
import com.platform.gui.framework.smart.action.ListTableAction;
import com.platform.gui.framework.smart.inter.IDataItem;
import com.platform.gui.framework.smart.inter.IDataItemDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;

public class RequestItemAction extends ListTableAction<Request>{

	private static final long serialVersionUID = 1L;
	
	private IDataRecordList<Request> dataRecords;
	
	private IDataItem dataItem;
	
	private IDataItemDecorate dataItemDecorate;
	
	public String toList() throws Exception{
		return SUCCESS;
	}
	
	@BeforeResult
	public void afterExecute(){
		try{
			dataRecords = new RequestDataRecordList();
			dataItem = new RequestDataItem();
			//dataItemDecorate = new RequestItemDecorate();
		}catch(Exception e){
			this.addActionError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Override
	public IDataRecordList<Request> registRecordDataList() throws Exception{
		return new RequestDataRecordList();
	}

	public IDataRecordList<Request> getDataRecords() {
		return dataRecords;
	}

	public void setDataRecords(IDataRecordList<Request> dataRecords) {
		this.dataRecords = dataRecords;
	}

	public IDataItem getDataItem() {
		return dataItem;
	}

	public void setDataItem(IDataItem dataItem) {
		this.dataItem = dataItem;
	}

	public IDataItemDecorate getDataItemDecorate() {
		return dataItemDecorate;
	}

	public void setDataItemDecorate(IDataItemDecorate dataItemDecorate) {
		this.dataItemDecorate = dataItemDecorate;
	}

}
