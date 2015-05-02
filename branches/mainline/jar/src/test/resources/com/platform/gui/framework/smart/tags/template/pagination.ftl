<#include "common.ftl">

<#assign firstPageUrl="${url}st_name=${context.name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${self.tableGrid.pagination.firstPage.value}">
<#assign previousPageUrl="${url}st_name=${context.name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${self.tableGrid.pagination.previousPage.value}">
<#assign nextPageUrl="${url}st_name=${context.name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${self.tableGrid.pagination.nextPage.value}">
<#assign lastPageUrl="${url}st_name=${context.name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${self.tableGrid.pagination.lastPage.value}">

<#if context.configure??>
	<#assign currentBegin="${self.tableGrid.pagination.currentPage.value * context.configure.pageSize + 1}">
	<#assign currentEnd="${self.context.configure.pageSize * (self.tableGrid.pagination.currentPage.value + 1)}">
</#if>

<div class="forIE">
	<!-- First Page -->
	<#if self.tableGrid.pagination.currentPage.value == 0>
		<a class="firstDisabled">${self.tableGrid.pagination.firstPage.label}</a> | 
	<#else>
		<a class="first" href="${firstPageUrl}">${self.tableGrid.pagination.firstPage.label}</a> |  
	</#if>
	
	<!-- Previous Page -->
	<#if self.tableGrid.pagination.previousPage.value lt 0 || self.tableGrid.pagination.previousPage.value gt self.tableGrid.pagination.lastPage.value>
		<a class="previousDisabled">${self.tableGrid.pagination.previousPage.label}</a> | 
	<#else>
		<a class="previous" href="${previousPageUrl}">${self.tableGrid.pagination.previousPage.label}</a> | 
	</#if>
	
	<!-- Current Page -->
	<span class="needBold">${currentBegin}-${currentEnd}</span> | 
		
	<!-- Next Page -->
	<#if self.tableGrid.pagination.nextPage.value lt 0 || self.tableGrid.pagination.nextPage.value gt self.tableGrid.pagination.lastPage.value>
		${self.tableGrid.pagination.nextPage.label} | 
	<#else>
		<a class="next" href="${nextPageUrl}">${self.tableGrid.pagination.nextPage.label}</a> | 
	</#if>
	
	<!-- Last Page -->
	<#if self.tableGrid.pagination.currentPage.value == self.tableGrid.pagination.lastPage.value>
		<a class="lastDisabled">${self.tableGrid.pagination.lastPage.label}</a>
	<#else>
		<a class="last" href="${lastPageUrl}">${self.tableGrid.pagination.lastPage.label}</a>
	</#if>
</div>
