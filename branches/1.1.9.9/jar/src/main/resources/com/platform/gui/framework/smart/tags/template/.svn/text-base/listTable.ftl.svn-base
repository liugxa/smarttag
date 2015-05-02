<#include "common.ftl">

<input type="hidden" name="page" value="${getPage(tableGrid)}">
<input type="hidden" name="sortBy" value="${sortBy}">
<input type="hidden" name="sortOrder" value="${sortOrder}">

<!-- Table Grid Filter Section -->
<#if filter ??><#include "filter.ftl"></#if>

<!-- Table Grid Content Section -->
<#if tableGrid ??>
	<#if tableGrid.dataSize gt context.configure.pageSize>
		<div class="tableNaviLeading-top">
			<#include "pagination.ftl">
		</div>
	</#if>
	
	<#include "tableGrid.ftl">
		
	<#if tableGrid.dataSize gt context.configure.pageSize>
		<div class="tableNaviLeading-bottom">
			<#include "pagination.ftl">
		</div>
	</#if>
</#if>
<!-- Table Grid Preference Section -->
<#if preference??><#include "preferences.ftl"></#if>

<#include "scripts.ftl">