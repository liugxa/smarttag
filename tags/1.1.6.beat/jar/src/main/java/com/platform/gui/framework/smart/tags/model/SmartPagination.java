package com.platform.gui.framework.smart.tags.model;

import java.util.Locale;
import java.util.Map;

import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableGridContext;
import com.platform.gui.framework.smart.util.I18NUtil;

public class SmartPagination {
	
	private SmartPage firstPage = new SmartPage("first");
	
	private SmartPage previousPage = new SmartPage("previous");
	
	private SmartPage currentPage = new SmartPage("current");
	
	private SmartPage nextPage = new SmartPage("next");
	
	private SmartPage lastPage = new SmartPage("last");
	
	private SmartTableGridContext context;

	public SmartPagination(){}
	
	public SmartPagination(SmartTableGridContext context){
		this.context = context;
		
		PreferenceConfigure configure = context.getConfigure();
		Map<String , String> parameters = context.getParameters();
		String resource = context.getResource();
		Locale locale = context.getLocale();
		
		//set the first/current/next/last parameter
		firstPage.setValue(0);
		firstPage.setLabel(I18NUtil.getResourceValue(locale , resource , "st.list.table.pagination.first"));

		String obj = parameters.get("page");
		Integer currentValue = (obj != null)?Integer.parseInt(obj):0;
		currentPage.setValue(currentValue);
		currentPage.setLabel(I18NUtil.getResourceValue(locale ,resource , "st.list.table.pagination.current"));
		
		previousPage.setValue(currentValue - 1);
		previousPage.setLabel(I18NUtil.getResourceValue(locale ,resource , "st.list.table.pagination.previous"));
		
		nextPage.setValue(currentValue + 1) ;
		nextPage.setLabel(I18NUtil.getResourceValue(locale ,resource , "st.list.table.pagination.next"));

		//set the first/current/next/last parameter
		lastPage.setValue(context.getDataSize() / configure.getPageSize());
		lastPage.setLabel(I18NUtil.getResourceValue(locale ,resource , "st.list.table.pagination.last"));	
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

	public SmartTableGridContext getContext() {
		return context;
	}

	public void setContext(SmartTableGridContext context) {
		this.context = context;
	}
}

