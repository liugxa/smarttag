<#include "common.ftl">

<#if form ?? && form == "none">
<#else>
	<form id="st_form_${context.name}" name="${context.name}" class="tableGridForm" method="post" action="${getUrl(context)}">
</#if>

<!-- Table Grid Filter Section -->
<#if filter ??><#include "filter.ftl"></#if>

<!-- Table Grid Content Section -->
<#if tableGrid ??>
	<table class="myListTable">
	<#if context.dataSize gt context.configure.pageSize>
		<tr>
			<td><#include "pagination.ftl"></td>
		</tr>
	</#if>
	
	<tr>
		<td><#include "tableGrid.ftl"></td>
	</tr>
	
	<#if context.dataSize gt context.configure.pageSize>
		<tr>
			<td><#include "pagination.ftl"></td>
		</tr>
	</#if>
	
	<!-- Table Grid Preference Section -->
	<#if preference??>
		<tr>
			<td><#include "preferences.ftl"></td>
		</tr>
	</#if>
	</table>
</#if>

<#if form ?? && form == "none">
<#else>
	</form>
</#if>

<#include "scripts.ftl">