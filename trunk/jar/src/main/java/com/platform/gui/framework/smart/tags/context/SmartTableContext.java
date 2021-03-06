package com.platform.gui.framework.smart.tags.context;

import java.util.Map;

import javax.servlet.jsp.PageContext;

import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.model.TableContext;
import com.platform.gui.framework.smart.tags.model.SmartResourceBundle;

public class SmartTableContext extends TableContext{
	
	private PageContext pageContext;
	
	/**
	 * SmartTableGridContext
	 */
	public SmartTableContext(){}
	
	/**
	 * SmartTableGridContext
	 * @param cells
	 * @param rows
	 * @param parameters
	 * @param action
	 */
	public SmartTableContext(String name , String contextPath , String action , Map<String,String> parameters , 
			PreferenceConfigure configure , SmartResourceBundle resource , FilterData filterData , Integer dataSize , PageContext pageContext) {
		super(name , contextPath , action , parameters , configure , resource , filterData , dataSize);
		this.pageContext = pageContext;
	}

	public PageContext getPageContext() {
		return pageContext;
	}

	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}
}
