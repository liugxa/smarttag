<#include "common.ftl">

<#assign firstPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.firstPage.value}">
<#assign previousPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.previousPage.value}">
<#assign nextPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.nextPage.value}">
<#assign lastPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.lastPage.value}">

<#if context.configure??>
	<#assign currentBegin="${tableGrid.pagination.currentPage.value * context.configure.pageSize + 1}">
	<#assign currentEnd="${context.configure.pageSize * (tableGrid.pagination.currentPage.value + 1)}">
<#else>
	<#assign currentBegin="${tableGrid.pagination.currentPage.value * 6 + 1}">
	<#assign currentEnd="${tableGrid.pagination.currentPage.value * 6 + 6}">
</#if>

<div class="forIE">
	<!-- First Page -->
	<#if tableGrid.pagination.currentPage.value == 0>
		<a class="firstDisabled">${tableGrid.pagination.firstPage.label}</a> | 
	<#else>
		<a class="first" href="${firstPageUrl}">${tableGrid.pagination.firstPage.label}</a> |  
	</#if>
	
	<!-- Previous Page -->
	<#if tableGrid.pagination.previousPage.value lt 0 || tableGrid.pagination.previousPage.value gt tableGrid.pagination.lastPage.value>
		<a class="previousDisabled">${tableGrid.pagination.previousPage.label}</a> | 
	<#else>
		<a class="previous" href="${previousPageUrl}">${tableGrid.pagination.previousPage.label}</a> | 
	</#if>
	
	<!-- Current Page -->
		<span class="needBold">${currentBegin}-${currentEnd}</span> | 
		
	<!-- Next Page -->
	<#if tableGrid.pagination.nextPage.value lt 0 || tableGrid.pagination.nextPage.value gt tableGrid.pagination.lastPage.value>
		${tableGrid.pagination.nextPage.label} | 
	<#else>
	
	<!-- Last Page -->
		<a class="next" href="${nextPageUrl}">${tableGrid.pagination.nextPage.label}</a> | 
	</#if>
	
	<#if tableGrid.pagination.currentPage.value == tableGrid.pagination.lastPage.value>
		<a class="lastDisabled">${tableGrid.pagination.lastPage.label}</a>
	<#else>
		<a class="last" href="${lastPageUrl}">${tableGrid.pagination.lastPage.label}</a>
	</#if>
</div>
