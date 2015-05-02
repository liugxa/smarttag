package com.platform.gui.framework.smart.tags.context;

import java.util.Map;

import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;

public class SmartTableGridContext {
	
	private String action;

	/**
	 * The smart tag configure object
	 */
	private SmartTableGridConfigure configure;
	
	/**
	 * All of the parameters in the request
	 */
	private Map<String, String> parameters;

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
	public SmartTableGridContext(String action , Map<String , String> parameters , SmartTableGridConfigure configure) {
		this.action = action;
		
		this.parameters = parameters;
		this.configure = configure;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public SmartTableGridConfigure getConfigure() {
		return configure;
	}

	public void setConfigure(SmartTableGridConfigure configure) {
		this.configure = configure;
	}
}
