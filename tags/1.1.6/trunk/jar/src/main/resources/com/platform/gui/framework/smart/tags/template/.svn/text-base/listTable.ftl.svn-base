<#include "common.ftl">
<form action="${context.action}" method="post" class="tableGridForm" id="tableGridForm">
	<#if tableGrid??>
		<input type="hidden" name="page" value="${tableGrid.pagination.currentPage.value}">
	<#else>
		<input type="hidden" name="page" value="0">
	</#if>
	
	<input type="hidden" name="sortBy" value="${sortBy}">
	<input type="hidden" name="sortOrder" value="${sortOrder}">
	<input type="hidden" name="clearSession" value="true">
	
	<!-- Table Grid Filter Section -->
	<#if filter ??><#include "filter.ftl"></#if>
	
	<!-- Table Grid Content Section -->
	<#if tableGrid ??>
		<#if context.dataSize gt context.configure.pageSize>
			<div class="tableNaviLeading-top">
				<#include "pagination.ftl">
			</div>
		</#if>
		
		<#include "tableGrid.ftl">
			
		<#if context.dataSize gt context.configure.pageSize>
			<div class="tableNaviLeading-bottom">
				<#include "pagination.ftl">
			</div>
		</#if>
	</#if>
	<!-- Table Grid Preference Section -->
	<#if preference??><#include "preferences.ftl"></#if>
</form>