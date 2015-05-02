<#assign sortBy="${context.parameters.sortBy!context.cells[0].name}">
<#assign sortOrder="${context.parameters.sortOrder!'asc'}">

<#if context.parameters.action?index_of('?') != -1>
	<#assign url="${context.parameters.contextPath}${context.parameters.action}&">
<#else>
	<#assign url="${context.parameters.contextPath}${context.parameters.action}?">
</#if>