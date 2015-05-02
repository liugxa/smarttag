package com.platform.gui.framework.smart.tags.model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;

import org.apache.log4j.Logger;

import com.platform.gui.framework.smart.SmartConstants;
import com.platform.gui.framework.smart.model.PreferenceConfigure;
import com.platform.gui.framework.smart.tags.context.SmartTableContext;


public class SmartPagination {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	private SmartPage firstPage = new SmartPage("first");
	
	private SmartPage previousPage = new SmartPage("previous");
	
	private SmartPage currentPage = new SmartPage("current");
	
	private SmartPage nextPage = new SmartPage("next");
	
	private SmartPage lastPage = new SmartPage("last");

	public SmartPagination(){}
	
	public SmartPagination(SmartTableContext context){
		Integer dataSize = context.getDataSize();
		PreferenceConfigure configure = context.getConfigure();
		Map<String,String> parameters = context.getParameters();
		
		//get the current locale
		Locale locale = context.getPageContext().getResponse().getLocale();
		NumberFormat format = NumberFormat.getInstance(locale);
		
		//set the first/current/next/last parameter
		firstPage.setValue(0);
		firstPage.setLabel("st.list.table.pagination.first");
		
		//get the page number(Integer) by locale
		Integer currentValue = 0;
		try{
			String page = parameters.get(SmartConstants.PARAMS_PAGE);
			if(page != null) currentValue = format.parse(page).intValue();
		}catch(ParseException e){
			logger.error("Parse the page value error," + e.getMessage());
		}
		
		currentPage.setValue(currentValue);
		currentPage.setLabel("st.list.table.pagination.current");
		
		previousPage.setValue(currentValue - 1);
		previousPage.setLabel("st.list.table.pagination.previous");
		
		nextPage.setValue(currentValue + 1) ;
		nextPage.setLabel("st.list.table.pagination.next");

		//set the first/current/next/last parameter
		lastPage.setValue(0);
		if(configure.getPageSize() != 0) lastPage.setValue((dataSize - 1) / configure.getPageSize());
		lastPage.setLabel("st.list.table.pagination.last");	
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

