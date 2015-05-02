package com.platform.gui.framework.smart.tags.context;

import java.util.Locale;
import java.util.Map;

import com.platform.gui.framework.smart.model.PreferenceConfigure;

public class SmartTableGridContext {
	
	private String contextPath;
	
	private String action;

	private Integer dataSize;

	/* All of the parameters in the request */
	private Map<String, String> parameters;

	/* The smart tag configure object */
	private PreferenceConfigure configure;
	
	private Locale locale;
	
	/* The resource bundle object */
	private String resource;	
	
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
			PreferenceConfigure configure , Locale locale , String resource) {
		this.contextPath = contextPath;
		this.action = action;
		this.dataSize = dataSize;
		
		this.parameters = parameters;
		this.configure = configure;
		
		this.locale = locale;
		this.resource = resource;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
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

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}
