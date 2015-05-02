package com.platform.gui.demo.request.action;

import com.platform.gui.demo.request.model.Request;
import com.platform.gui.demo.request.model.RequestDataRecordList;
import com.platform.gui.framework.smart.action.ListTableAction;
import com.platform.gui.framework.smart.inter.IDataColumnDecorate;
import com.platform.gui.framework.smart.inter.IDataRecordList;

public class RequestAction extends ListTableAction<Request>{

	private static final long serialVersionUID = 1L;
	
	private Request request;
	
	public String toList() throws Exception{
		return SUCCESS;
	}
	
	@Override
	public IDataRecordList<Request> registRecordDataList() throws Exception{
		return new RequestDataRecordList();
	}

    public IDataColumnDecorate registDataColumnDecorate() throws Exception{
        return new Request();
    }

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
