package com.platform.gui.framework.smart.model;

import java.util.List;
import java.util.Locale;

public class PreferenceConfigure {
	
	/* the page size*/
	public int pageSize;

	/* the page name */
	private String name;
	
	/* the page number */
	private Integer page;
	
	/* the page sort by */
	public String sortBy;
	
	/* the page sort order */
	public String sortOrder;
	
	/* all of the columns which will be display on the page. */
	public List<String> columns;
	
	/* the columns which do not display on the page.*/
	public List<String> unColumns;
	
	/* the location object */
	public Locale locale;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public List<String> getUnColumns() {
		return unColumns;
	}

	public void setUnColumns(List<String> unColumns) {
		this.unColumns = unColumns;
	}
	
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setPage(String page){
		if(page != null && !page.equals("")){
			this.page = Integer.parseInt(page);
		}else{
			this.page = 0;
		}
	}	
}
