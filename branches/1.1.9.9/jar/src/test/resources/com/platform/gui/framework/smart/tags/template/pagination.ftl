<#include "common.ftl">

<#assign firstPageUrl="${url}st_name=${name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${tableGrid.pagination.firstPage.value}">
<#assign previousPageUrl="${url}st_name=${name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${tableGrid.pagination.previousPage.value}">
<#assign nextPageUrl="${url}st_name=${name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${tableGrid.pagination.nextPage.value}">
<#assign lastPageUrl="${url}st_name=${name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=${tableGrid.pagination.lastPage.value}">

<#assign firstPageLable="${context.resource.getText(tableGrid.pagination.firstPage.label)!''}">
<#assign previousPageLable="${context.resource.getText(tableGrid.pagination.previousPage.label)!''}">
<#assign nextPageLable="${context.resource.getText(tableGrid.pagination.nextPage.label)!''}">
<#assign lastPageLable="${context.resource.getText(tableGrid.pagination.lastPage.label)!''}">

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
		<a class="firstDisabled">${firstPageLable}</a> | 
	<#else>
		<a class="first" href="${firstPageUrl}">${firstPageLable}</a> |  
	</#if>
	
	<!-- Previous Page -->
	<#if tableGrid.pagination.previousPage.value lt 0 || tableGrid.pagination.previousPage.value gt tableGrid.pagination.lastPage.value>
		<a class="previousDisabled">${previousPageLable}</a> | 
	<#else>
		<a class="previous" href="${previousPageUrl}">${previousPageLable}</a> | 
	</#if>
	
	<!-- Current Page -->
		<span class="needBold">${currentBegin}-${currentEnd}</span> | 
		
	<!-- Next Page -->
	<#if tableGrid.pagination.nextPage.value lt 0 || tableGrid.pagination.nextPage.value gt tableGrid.pagination.lastPage.value>
		${nextPageLable} | 
	<#else>
	
	<!-- Last Page -->
		<a class="next" href="${nextPageUrl}">${nextPageLable}</a> | 
	</#if>
	
	<#if tableGrid.pagination.currentPage.value == tableGrid.pagination.lastPage.value>
		<a class="lastDisabled">${lastPageLable}</a>
	<#else>
		<a class="last" href="${lastPageUrl}">${lastPageLable}</a>
	</#if>
</div>
