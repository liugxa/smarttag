package com.platform.gui.framework.smart.model;

import java.util.Map;
import java.util.ResourceBundle;

public class TableContext {

	/* the name property */
	private String name;
	
	/* The action's context path*/
	private String contextPath;
	
	/* The action URL*/
	private String action;

	/* The resource bundle object */
    private ResourceBundle resource;

    /* The parameters object */
    private Map<String,String> parameters;
    
    /* The preference configure */
	private PreferenceConfigure configure;
	
	/* The filter data*/
	private FilterData filterData;
	
	/* The data size */
	private Integer dataSize;
	
	/**
	 * TableGridContext
	 */
	public TableContext(){}
	
	/**
	 * TableGridContext
	 * @param cells
	 * @param rows
	 * @param parameters
	 * @param action
	 */
	public TableContext(String name , String contextPath , String action , Map<String,String> parameters , 
			PreferenceConfigure configure , ResourceBundle resource , FilterData filterData , Integer dataSize) {
		this.name = name;
		this.contextPath = contextPath;
		
		this.action = action;
		this.configure = configure;
		
		this.parameters = parameters;
		this.resource = resource;
		
		this.filterData = filterData;
		this.dataSize = dataSize;
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

	public ResourceBundle getResource() {
		return resource;
	}

	public void setResource(ResourceBundle resource) {
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

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}
}
