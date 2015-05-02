package com.platform.gui.framework.smart.tags.model;

import java.util.Map;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;


public class SmartPagination{
	
	private SmartPage firstPage = new SmartPage("first" , "First");
	
	private SmartPage previousPage = new SmartPage("previous" , "Previous");
	
	private SmartPage currentPage = new SmartPage("current" , "Current");
	
	private SmartPage nextPage = new SmartPage("next" , "Next");
	
	private SmartPage lastPage = new SmartPage("last" , "Last");

	public SmartPagination(){}
	
	public SmartPagination(SmartTableContext context , Integer dataSize){
		PreferenceConfigure configure = context.getConfigure();
		Map<String,String> parameters = context.getParameters();
		
		//set the first/current/next/last parameter
		firstPage.setValue(0);

		String page = parameters.get(SmartConstants.PARAMS_PAGE);
		Integer currentValue = (page != null)?Integer.parseInt(page):0;
		currentPage.setValue(currentValue);
		
		previousPage.setValue(currentValue - 1);
		nextPage.setValue(currentValue + 1) ;

		//set the first/current/next/last parameter
		lastPage.setValue(0);
		if(configure.getPageSize() != 0) lastPage.setValue(dataSize / configure.getPageSize());	
	}

	public SmartPage getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(SmartPage firstPage) {
		this.firstPage = firstPage;
	}

	public SmartPage getPreviousPage() {
		return previousPage;
	}

	public void setPreviousPage(SmartPage previousPage) {
		this.previousPage = previousPage;
	}

	public SmartPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(SmartPage currentPage) {
		this.currentPage = currentPage;
	}

	public SmartPage getNextPage() {
		return nextPage;
	}

	public void setNextPage(SmartPage nextPage) {
		this.nextPage = nextPage;
	}

	public SmartPage getLastPage() {
		return lastPage;
	}

	public void setLastPage(SmartPage lastPage) {
		this.lastPage = lastPage;
	}
}

