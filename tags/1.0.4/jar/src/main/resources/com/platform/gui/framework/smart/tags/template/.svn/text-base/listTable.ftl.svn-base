<#include "common.ftl">
<form action="${context.action}" method="post" class="tableGridForm" id="tableGridForm">
	<input type="hidden" name="page" value="${tableGrid.pagination.currentPage}">
	<input type="hidden" name="sortBy" value="${sortBy}">
	<input type="hidden" name="sortOrder" value="${sortOrder}">
	<input type="hidden" name="removeRecords" value="true">
	
	<!-- Table Grid Filter Section -->
	<#if filter ??><#include "filter.ftl"></#if>
	
	<!-- Table Grid Content Section -->
	<div class="tableNaviLeading-top">
		<#include "pagination.ftl">
	</div>
	
	<#include "tableGrid.ftl">

	<div class="tableNaviLeading-bottom">
		<#include "pagination.ftl">
	</div>
	<!-- Table Grid Preference Section -->
	<#if preference??><#include "preferences.ftl"></#if>
</form>