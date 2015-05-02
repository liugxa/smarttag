<#if context.parameters??>
	<#-- Get sort from the context parameters -->
	<#assign page="${context.parameters.st_page!0}">
	<#assign sortBy="${context.parameters.st_sortBy!''}">
	<#assign sortOrder="${context.parameters.st_sortOrder!''}">
<#else>
	<#-- Get sort from the configure object -->
	<#if context.configure??>
		<#assign sortBy="${context.configure.page!0}">
		<#assign sortBy="${context.configure.sortBy!''}">
		<#assign sortOrder="${context.configure.sortOrder!'asc'}">
	</#if>
</#if>

<#if context.url?index_of('?') != -1>
	<#assign url="${context.url}&">
<#else>
	<#assign url="${context.url}?">
</#if>