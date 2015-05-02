package com.platform.gui.framework.smart.tags.context;

import java.util.Map;

import com.platform.gui.framework.smart.model.FilterData;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.model.SmartResourceBundle;

public class SmartTableContext {
	
	/* the name property */
	private String name;
	
	/* The action's context path*/
	private String contextPath;
	
	/* The action URL*/
	private String action;

	/* The resource bundle object */
    private SmartResourceBundle resource;

    /* The parameters object */
    private Map<String,String> parameters;
    
    /* The preference configure */
	private PreferenceConfigure configure;
	
	private FilterData filterData;
	
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
			PreferenceConfigure configure , SmartResourceBundle resource , FilterData filterData) {
		this.name = name;
		this.contextPath = contextPath;
		
		this.action = action;
		this.configure = configure;
		
		this.parameters = parameters;
		this.resource = resource;
		
		this.filterData = filterData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public SmartResourceBundle getResource() {
		return resource;
	}

	public void setResource(SmartResourceBundle resource) {
		this.resource = resource;
	}
	
	public PreferenceConfigure getConfigure() {
		return configure;
	}

	public void setConfigure(PreferenceConfigure configure) {
		this.configure = configure;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public FilterData getFilterData() {
		return filterData;
	}

	public void setFilterData(FilterData filterData) {
		this.filterData = filterData;
	}
}
