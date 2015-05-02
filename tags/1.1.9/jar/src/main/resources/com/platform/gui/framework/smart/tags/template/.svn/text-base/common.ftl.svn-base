<#if context.parameters.st_sortBy??>
	<#-- Get sort from the context parameters -->
	<#assign sortBy="${context.parameters.st_sortBy!''}">
	<#assign sortOrder="${context.parameters.st_sortOrder!''}">
<#else>
	<#-- Get sort from the configure object -->
	<#if context.configure??>
		<#assign sortBy="${context.configure.sortBy!''}">
		<#assign sortOrder="${context.configure.sortOrder!'asc'}">
	</#if>
</#if>


<#-- Get the sort display name -->
<#assign sortByValue=sortBy>
<#if sortBy?? && tableGrid.cells??>
	<#list tableGrid.cells as cell>
		<#if cell.name == sortBy>
			<#assign sortByValue=cell.label>
			<#break>
		</#if>
	</#list>
</#if>

<#if context.action?index_of('?') != -1>
	<#assign url="${context.action}&">
<#else>
	<#assign url="${context.action}?">
</#if>