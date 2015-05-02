<#assign sortBy="${context.parameters.sortBy!''}">
<#assign sortOrder="${context.parameters.sortOrder!'asc'}">

<#if context.action?index_of('?') != -1>
	<#assign url="${context.action}&">
<#else>
	<#assign url="${context.action}?">
</#if>