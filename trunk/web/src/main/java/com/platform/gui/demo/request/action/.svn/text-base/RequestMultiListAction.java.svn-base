package com.platform.gui.demo.request.action;

import com.opensymphony.xwork2.interceptor.annotations.BeforeResult;
import com.platform.gui.demo.request.model.Request;
import com.platform.gui.demo.request.model.RequestDataItem;
import com.platform.gui.demo.request.model.RequestDataRecordList;
import com.platform.gui.framework.smart.action.AbstractAction;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataItem;
import com.platform.gui.framework.smart.inter.IDataItemDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;
import com.platform.gui.framework.smart.model.FilterData;

public class RequestMultiListAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	//table 1
	private IDataRecordList<Request> dataRecords1;
	
	private IDataColumnDecorate dataColumnDecorate1;
	
	//table 2
	private IDataRecordList<Request> dataRecords2;
	
	private IDataItem dataItem2;
	
	private IDataItemDecorate dataItemDecorate2;	
	
	//filter data
	private FilterData filterData;
	
	public String toMultiList() throws Exception{
		return SUCCESS;
	}
	
	@BeforeResult
	public void afterExecute(){
		try{
			//table 1
			dataRecords1 = new RequestDataRecordList();
			dataColumnDecorate1 = new Request();
			
			//table 2
			dataRecords2 = new RequestDataRecordList();
			dataItem2 = new RequestDataItem();
			//dataItemDecorate = new RequestItemDecorate();
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
		}
	}

	public IDataRecordList<Request> getDataRecords1() {
		return dataRecords1;
	}

	public void setDataRecords1(IDataRecordList<Request> dataRecords1) {
		this.dataRecords1 = dataRecords1;
	}

	public IDataColumnDecorate getDataColumnDecorate1() {
		return dataColumnDecorate1;
	}

	public void setDataColumnDecorate1(IDataColumnDecorate dataColumnDecorate1) {
		this.dataColumnDecorate1 = dataColumnDecorate1;
	}

	public IDataRecordList<Request> getDataRecords2() {
		return dataRecords2;
	}

	public void setDataRecords2(IDataRecordList<Request> dataRecords2) {
		this.dataRecords2 = dataRecords2;
	}

	public IDataItem getDataItem2() {
		return dataItem2;
	}

	public void setDataItem2(IDataItem dataItem2) {
		this.dataItem2 = dataItem2;
	}

	public IDataItemDecorate getDataItemDecorate2() {
		return dataItemDecorate2;
	}

	public void setDataItemDecorate2(IDataItemDecorate dataItemDecorate2) {
		this.dataItemDecorate2 = dataItemDecorate2;
	}

	public FilterData getFilterData() {
		return filterData;
	}

	public void setFilterData(FilterData filterData) {
		this.filterData = filterData;
	}
}
