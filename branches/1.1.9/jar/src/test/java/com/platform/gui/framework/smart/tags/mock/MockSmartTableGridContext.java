package com.platform.gui.framework.smart.tags.mock;
import java.util.HashMap;
import java.util.Locale;

import com.platform.gui.framework.smart.tags.config.SmartTableConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;
import com.platform.gui.framework.smart.tags.model.SmartResourceBundle;

public class MockSmartTableGridContext extends SmartTableContext{

	public MockSmartTableGridContext(){
		this.setContextPath("/request");
		this.setAction("toList.action?file=aa");
		this.setName("smart");
		this.setConfigure(this.getSmartConfigure());
		this.setParameters(new HashMap<String,String>());
		this.setResource(new SmartResourceBundle(null , Locale.US));
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
