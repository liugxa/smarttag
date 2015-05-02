<#include "common.ftl">

<#if self??>
	<!-- Table Grid Hidden Section -->
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="sortBy" value="${sortBy}">
	<input type="hidden" name="sortOrder" value="${sortOrder}">
	
	<!-- Table Grid Filter Section -->
	<#if self.filter ??>${self.filter.html}</#if>
	
	<!-- Table Grid Pagination Section -->
	<div class="tableNaviLeading-top">
		<#include "pagination.ftl">
	</div>
	
	<!-- Table Grid Content Section -->
	${self.tableGrid.html}
	
	<!-- Table Grid Pagination Section -->
	<div class="tableNaviLeading-bottom">
		<#include "pagination.ftl">
	</div>
	
	<!-- Table Grid Preference Section -->
	<#if self.preference??>${self.preference.html}</#if>
</#if>