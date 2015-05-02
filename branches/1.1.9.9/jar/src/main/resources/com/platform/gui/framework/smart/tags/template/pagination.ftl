<#include "common.ftl">

<#if context.configure??>
	<#assign currentBegin="${tableGrid.pagination.currentPage.value * context.configure.pageSize + 1}">
	<#assign currentEnd="${context.configure.pageSize * (tableGrid.pagination.currentPage.value + 1)}">
<#else>
	<#assign currentBegin="${tableGrid.pagination.currentPage.value * 6 + 1}">
	<#assign currentEnd="${tableGrid.pagination.currentPage.value * 6 + 6}">
</#if>

<center>
	<div class="forIE">
		<!-- First Page -->
		<#if tableGrid.pagination.currentPage.value == 0>
			<a class="firstDisabled">${getText(tableGrid.pagination.firstPage.label)}</a> | 
		<#else>
			<a class="first" href="${getPageUrl(tableGrid.pagination.firstPage)}">${getText(tableGrid.pagination.firstPage.label)}</a> |  
		</#if>
		
		<!-- Previous Page -->
		<#if tableGrid.pagination.previousPage.value lt 0 || tableGrid.pagination.previousPage.value gt tableGrid.pagination.lastPage.value>
			<a class="previousDisabled">${getText(tableGrid.pagination.previousPage.label)}</a> | 
		<#else>
			<a class="previous" href="${getPageUrl(tableGrid.pagination.firstPage)}">${getText(tableGrid.pagination.previousPage.label)}</a> | 
		</#if>
	
		<!-- Current Page -->
			<span class="needBold">${currentBegin}-${currentEnd}</span> | 
			
		<!-- Next Page -->
		<#if tableGrid.pagination.nextPage.value lt 0 || tableGrid.pagination.nextPage.value gt tableGrid.pagination.lastPage.value>
			${getText(tableGrid.pagination.nextPage.label)} | 
		<#else>
		
			<a class="next" href="${getPageUrl(tableGrid.pagination.nextPage)}">${getText(tableGrid.pagination.nextPage.label)}</a> | 
		</#if>
		
		<!-- Last Page -->
		<#if tableGrid.pagination.currentPage.value == tableGrid.pagination.lastPage.value>
			<a class="lastDisabled">${getText(tableGrid.pagination.lastPage.label)}</a>
		<#else>
			<a class="last" href="${getPageUrl(tableGrid.pagination.lastPage)}">${getText(tableGrid.pagination.lastPage.label)}</a>
		</#if>
	</div>
</center>