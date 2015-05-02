<#include "common.ftl">

<#assign firstPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.firstPage}">
<#assign previousPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.previousPage}">
<#assign nextPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.nextPage}">
<#assign lastPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${tableGrid.pagination.lastPage}">

<#if context.configure??>
	<#assign currentBegin="${tableGrid.pagination.currentPage * context.configure.pageSize + 1}">
	<#assign currentEnd="${context.configure.pageSize * (tableGrid.pagination.currentPage + 1)}">
<#else>
	<#assign currentBegin="${tableGrid.pagination.currentPage * 6 + 1}">
	<#assign currentEnd="${tableGrid.pagination.currentPage * 6 + 6}">
</#if>

<#if context.dataSize gt context.configure.pageSize>
	<div class="forIE">
		<!-- First Page -->
		<#if tableGrid.pagination.currentPage == 0>
			<a class="firstDisabled">First</a> | 
		<#else>
			<a class="first" href="${firstPageUrl}">First</a> |  
		</#if>
		
		<!-- Previous Page -->
		<#if tableGrid.pagination.previousPage lt 0 || tableGrid.pagination.previousPage gt tableGrid.pagination.lastPage>
			<a class="previousDisabled">Previous</a> | 
		<#else>
			<a class="previous" href="${previousPageUrl}">Previous</a> | 
		</#if>
		
		<!-- Current Page -->
			<span class="needBold">${currentBegin}-${currentEnd}</span> | 
			
		<!-- Next Page -->
		<#if tableGrid.pagination.nextPage lt 0 || tableGrid.pagination.nextPage gt tableGrid.pagination.lastPage>
			Next | 
		<#else>
		
		<!-- Last Page -->
			<a class="next" href="${nextPageUrl}">Next</a> | 
		</#if>
		
		<#if tableGrid.pagination.currentPage == tableGrid.pagination.lastPage>
			<a class="lastDisabled">Last</a>
		<#else>
			<a class="last" href="${lastPageUrl}">Last</a>
		</#if>
	</div>
</#if>