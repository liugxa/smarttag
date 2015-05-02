package com.platform.gui.framework.smart.tags.context;

import java.util.Map;

import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.model.SmartResourceBundle;

public class SmartTableContext {
	
	/* the name property */
	private String name;
	
	/* The action URL*/
	private String action;

	/* The resource bundle object */
    private SmartResourceBundle resource;

    /* The parameters object */
    private Map<String,String> parameters;
    
    /* The preference configure */
	private PreferenceConfigure configure;
	
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
	public SmartTableContext(String name , String action , PreferenceConfigure configure , Map<String,String> parameters , SmartResourceBundle resource) {
		this.name = name;
		this.action = action;
		
		this.configure = configure;
		this.parameters = parameters;
		this.resource = resource;
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
}
