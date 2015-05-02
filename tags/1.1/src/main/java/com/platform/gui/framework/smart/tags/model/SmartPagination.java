package com.platform.gui.framework.smart.tags.model;

import java.util.HashMap;
import java.util.Map;

import com.platform.gui.framework.smart.tags.config.SmartTableGridConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.tags.inter.IEnableHtml;
import com.platform.gui.framework.smart.tags.util.FreeMarkerUtil;

public class SmartPagination implements IEnableHtml{

	private Integer firstPage = 0;

	private Integer previousPage;

	private Integer currentPage;

	private Integer nextPage;

	private Integer lastPage;
	
	private SmartTableGridContext context;

	public SmartPagination(){}
	
	public SmartPagination(SmartTableGridContext context){
		this.context = context;
		SmartTableGridConfigure configure = context.getConfigure();
			
		//set the first/current/next/last parameter
		Map<String , String> parameters = context.getParameters();
		String dataSize = parameters.get("dataSize");
		
		lastPage = Integer.parseInt(dataSize) / configure.getPageSize();
		
		String obj = parameters.get("page");
		currentPage = (obj != null)?Integer.parseInt(obj):0;		
		
		previousPage = currentPage - 1;
		nextPage = currentPage + 1 ;
	}

	/**
	 * Get HTML code
	 */
	public String getHtml() throws Exception {
		HashMap<String, Object> root = new HashMap<String, Object>();
		
		//set table configure object
		root.put("context", this.context);
		
		//set pagination and preference object
		root.put("pagination", this);
		
		//print the table header
		String templatePath = "/com/platform/gui/framework/smart/tags/template/";
		return FreeMarkerUtil.getTemplateHtml(templatePath , "pagination.ftl", root);
	}
	
	public Integer getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(Integer firstPage) {
		this.firstPage = firstPage;
	}

	public Integer getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getNextPage() {
		return nextPage;
	}

	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public SmartTableGridContext getContext() {
		return context;
	}

	public void setContext(SmartTableGridContext context) {
		this.context = context;
	}
	
}

