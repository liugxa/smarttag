package com.platform.gui.framework.smart.tags.mock;
import java.util.HashMap;

import com.platform.gui.framework.smart.tags.config.SmartTableConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;

public class MockSmartTableGridContext extends SmartTableContext{

	public MockSmartTableGridContext(){
		this.setName("smart");
		this.setUrl("/request/toList.action?file=aa");
		
		this.setConfigure(this.getSmartConfigure());
		this.setParameters(new HashMap<String,String>());
		this.setDataSize(20);
	}
	
	public 	SmartTableConfigure getSmartConfigure(){
		SmartTableConfigure configure = new SmartTableConfigure();
		configure.setPageSize(2);
		configure.setPage(0);
		configure.setSortBy("name");
		configure.setSortOrder("desc");
		return configure;
	}
}
