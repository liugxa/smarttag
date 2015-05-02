package com.platform.gui.framework.smart.tags.context;

import java.util.Map;

import javax.servlet.ServletContext;

import com.platform.gui.framework.smart.model.PreferenceConfigure;

public class SmartTableContext {
	
	/* the context name property */
	private String name;
	
	/* the data size property */
	private Integer dataSize;
	
	/* The action URL*/
	private String url;

    /* The parameters object */
    private Map<String,String> parameters;
    
    /* The preference configure */
	private PreferenceConfigure configure;
	
	/* The context object */
	private ServletContext servletContext;
	
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
	public SmartTableContext(String name ,String url , Integer dataSize ,  
			PreferenceConfigure configure , Map<String,String> parameters , ServletContext servletContext) {
		this.name = name;
		this.url = url;
		this.dataSize = dataSize;
		
		this.configure = configure;
		this.parameters = parameters;
		
		this.servletContext = servletContext;
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

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PreferenceConfigure getConfigure() {
		return configure;
	}

	public void setConfigure(PreferenceConfigure configure) {
		this.configure = configure;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}	
}
