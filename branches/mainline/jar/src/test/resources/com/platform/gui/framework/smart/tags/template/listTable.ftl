<#include "common.ftl">

<#if self??>
	<!-- Table Grid Hidden Section -->
	<input type="hidden" name="page" value="${context.parameters.page}">
	<input type="hidden" name="sortBy" value="${sortBy}">
	<input type="hidden" name="sortOrder" value="${sortOrder}">
	<input type="hidden" name="clearSession" value="true">
	
	<!-- Table Grid Filter Section -->
	<#if self.filter ??>${self.filter.html}</#if>
	
	<!-- Table Grid Pagination Section -->
	<#if self.dataSize gt context.configure.pageSize>
		<div class="tableNaviLeading-top">
			<#include "pagination.ftl">
		</div>
	</#if>
	
	<!-- Table Grid Content Section -->
	${self.tableGrid.html}
	
	<!-- Table Grid Pagination Section -->
	<#if self.tableGrid.dataSize gt context.configure.pageSize>
		<div class="tableNaviLeading-bottom">
			<#include "pagination.ftl">
		</div>
	</#if>
	
	<!-- Table Grid Preference Section -->
	<#if self.preference??>${self.preference.html}</#if>
</#if>