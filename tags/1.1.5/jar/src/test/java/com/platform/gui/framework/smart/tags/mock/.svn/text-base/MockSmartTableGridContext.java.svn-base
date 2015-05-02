package com.platform.gui.framework.smart.tags.mock;
import java.util.HashMap;
import java.util.Map;

import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;

public class MockSmartTableGridContext extends SmartTableGridContext{

	public MockSmartTableGridContext(){
		this.setContextPath("/request");
		this.setAction("/request/toList.action?file=aa");
		this.setDataSize(6);
		
		this.setParameters(this.getSmartParameters());
		this.setConfigure(this.getSmartConfigure());
	}
	
	public Map<String , String> getSmartParameters(){
		Map<String , String> parameters = new HashMap<String , String>();
		parameters.put("page", "0");
		parameters.put("sortBy", "name");
		parameters.put("sortOrder", "asc");
		return parameters;
	}
	
	public 	SmartTableGridConfigure getSmartConfigure(){
		SmartTableGridConfigure configure = new SmartTableGridConfigure();
		configure.setPageSize(9);
		return configure;
	}
}
