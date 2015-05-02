package com.platform.gui.demo.request.model;

import java.util.List;

import com.platform.gui.demo.request.service.MockRequestService;
import com.platform.gui.framework.smart.inter.impl.DefaultDataRecordList;

public class RequestDataRecordList extends DefaultDataRecordList<Request>{

	private static final long serialVersionUID = 1L;

	private MockRequestService service = new MockRequestService();
	
	public RequestDataRecordList() throws Exception{
		List<Request> requests = service.getRequests();
		this.setRecords(requests);
	}
}
