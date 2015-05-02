package com.platform.gui.demo.request.service;

import java.util.List;

import junit.framework.TestCase;

import com.platform.gui.demo.request.model.Request;
import com.platform.gui.demo.request.service.MockRequestService;


public class TestMockRequestService extends TestCase{

	public void testGetRequests(){
		try{
			MockRequestService service = new MockRequestService();
			List<Request> requests = service.getRequests();
			assertNotNull(requests);
			assertEquals(51, requests.size());
		}catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
		}
	}
}
