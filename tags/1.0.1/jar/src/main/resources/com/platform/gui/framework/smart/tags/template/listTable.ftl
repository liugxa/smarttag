<#include "common.ftl">
<form action="${context.action}" method="post" class="tableGridForm">
	<input type="hidden" name="page" value="${pagination.currentPage}">
	<input type="hidden" name="sortBy" value="${sortBy}">
	<input type="hidden" name="sortOrder" value="${sortOrder}">
	
	<!-- Table Grid Filter Section -->
	<#if filter ??><#include "filter.ftl"></#if>
	
	<!-- Table Grid Content Section -->
	<#include "tableGrid.ftl">
	
	<!-- Table Grid Preference Section -->
	<#if preference??><#include "preferences.ftl"></#if>
</form>