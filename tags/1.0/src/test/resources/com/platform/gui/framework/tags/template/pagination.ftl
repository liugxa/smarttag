<#include "common.ftl">

<#assign firstPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${pagination.firstPage}">
<#assign previousPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${pagination.previousPage}">
<#assign nextPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${pagination.nextPage}">
<#assign lastPageUrl="${url}sortBy=${sortBy}&sortOrder=${sortOrder}&page=${pagination.lastPage}">

<#if context.configure??>
	<#assign currentBegin="${pagination.currentPage * context.configure.pageSize + 1}">
	<#assign currentEnd="${context.configure.pageSize * (pagination.currentPage + 1)}">
<#else>
	<#assign currentBegin="${pagination.currentPage * 6 + 1}">
	<#assign currentEnd="${pagination.currentPage * 6 + 6}">
</#if>

<div class="forIE">
	
	<!-- First Page -->
	<#if pagination.currentPage == 0>
		<a class="firstDisabled">First</a> | 
	<#else>
		<a class="first" href="${firstPageUrl}">First</a> |  
	</#if>
	
	<!-- Previous Page -->
	<#if pagination.previousPage lt 0 || pagination.previousPage gt pagination.lastPage>
		<a class="previousDisabled">Previous</a> | 
	<#else>
		<a class="previous" href="${previousPageUrl}">Previous</a> | 
	</#if>
	
	<!-- Current Page -->
		<span class="needBold">${currentBegin}-${currentEnd}</span> | 
		
	<!-- Next Page -->
	<#if pagination.nextPage lt 0 || pagination.nextPage gt pagination.lastPage>
		Next | 
	<#else>
	
	<!-- Last Page -->
		<a class="next" href="${nextPageUrl}">Next</a> | 
	</#if>
	
	<#if pagination.currentPage == pagination.lastPage>
		<a class="lastDisabled">Last</a>
	<#else>
		<a class="last"href="${lastPageUrl}">Last</a>
	</#if>
</div>