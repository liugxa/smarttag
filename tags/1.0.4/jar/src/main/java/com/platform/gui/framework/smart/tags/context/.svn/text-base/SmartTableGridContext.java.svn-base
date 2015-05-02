package com.platform.gui.framework.smart.tags.context;

import java.util.Map;
import java.util.Set;

import com.platform.gui.framework.smart.model.PreferenceConfigure;

public class SmartTableGridContext {
	
	private String contextPath;
	
	private String action;

	private Integer dataSize;
	
	/* The smart tag configure object */
	private PreferenceConfigure configure;
	
	/* All of the parameters in the request */
	private Map<String, String> parameters;

	/* The checked record set */	
	private Set<String> checkedRecords;
	
	/**
	 * SmartTableGridContext
	 */
	public SmartTableGridContext(){}
	
	/**
	 * SmartTableGridContext
	 * @param cells
	 * @param rows
	 * @param parameters
	 * @param action
	 */
	public SmartTableGridContext(String contextPath , String action , Integer dataSize , Map<String , String> parameters , 
			PreferenceConfigure configure , Set<String> checkedRecords) {
		this.contextPath = contextPath;
		this.action = action;
		this.dataSize = dataSize;
		
		this.parameters = parameters;
		this.configure = configure;
		
		this.checkedRecords = checkedRecords;
	}
	
	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public PreferenceConfigure getConfigure() {
		return configure;
	}

	public void setConfigure(PreferenceConfigure configure) {
		this.configure = configure;
	}

	public Set<String> getCheckedRecords() {
		return checkedRecords;
	}

	public void setCheckedRecords(Set<String> checkedRecords) {
		this.checkedRecords = checkedRecords;
	}
}
