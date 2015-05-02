package com.platform.gui.framework.smart.tags.model;

import java.util.Map;

import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;

public class SmartPagination {

	private Integer firstPage = 0;

	private Integer previousPage;

	private Integer currentPage;

	private Integer nextPage;

	private Integer lastPage;
	
	private SmartTableGridContext context;

	public SmartPagination(){}
	
	public SmartPagination(SmartTableGridContext context){
		this.context = context;
		PreferenceConfigure configure = context.getConfigure();
			
		//set the first/current/next/last parameter
		lastPage = context.getDataSize() / configure.getPageSize();

		Map<String , String> parameters = context.getParameters();
		String obj = parameters.get("page");
		currentPage = (obj != null)?Integer.parseInt(obj):0;		
		
		previousPage = currentPage - 1;
		nextPage = currentPage + 1 ;
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

