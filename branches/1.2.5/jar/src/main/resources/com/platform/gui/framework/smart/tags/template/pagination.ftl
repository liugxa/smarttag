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
			<a class="firstDisabled">${getText(context , tableGrid.pagination.firstPage.label)}</a> | 
		<#else>
			<a class="first" href="${getPageUrl(context , tableGrid.pagination.firstPage)}">${getText(context , tableGrid.pagination.firstPage.label)}</a> |  
		</#if>
		
		<!-- Previous Page -->
		<#if tableGrid.pagination.previousPage.value lt 0 || tableGrid.pagination.previousPage.value gt tableGrid.pagination.lastPage.value>
			<a class="previousDisabled">${getText(context , tableGrid.pagination.previousPage.label)}</a> | 
		<#else>
			<a class="previous" href="${getPageUrl(context , tableGrid.pagination.previousPage)}">${getText(context , tableGrid.pagination.previousPage.label)}</a> | 
		</#if>
	
		<!-- Current Page -->
			<span class="needBold">${currentBegin}-${currentEnd}</span> | 
			
		<!-- Next Page -->
		<#if tableGrid.pagination.nextPage.value lt 0 || tableGrid.pagination.nextPage.value gt tableGrid.pagination.lastPage.value>
			${getText(context , tableGrid.pagination.nextPage.label)} | 
		<#else>
		
			<a class="next" href="${getPageUrl(context , tableGrid.pagination.nextPage)}">${getText(context , tableGrid.pagination.nextPage.label)}</a> | 
		</#if>
		
		<!-- Last Page -->
		<#if tableGrid.pagination.currentPage.value == tableGrid.pagination.lastPage.value>
			<a class="lastDisabled">${getText(context , tableGrid.pagination.lastPage.label)}</a>
		<#else>
			<a class="last" href="${getPageUrl(context , tableGrid.pagination.lastPage)}">${getText(context , tableGrid.pagination.lastPage.label)}</a>
		</#if>
	</div>
</center>