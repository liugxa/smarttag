<#include "common.ftl">

<th>
	<#if self.disable?? && self.disable>
		status:${self.label!""} 	
	<#else>
	    <#assign columnClass="">
		<#if sortOrder == "asc">
			<#assign columnUrl="${url}st_name=${context.name}&st_sortBy=${self.name}&st_sortOrder=desc&st_page=${page}">
			<#if sortBy == self.name>
				<#assign columnClass="sortCurrentAscend"/>
			</#if>
		<#else>
			<#assign columnUrl="${url}st_name=${context.name}&st_sortBy=${self.name}&st_sortOrder=asc&st_page=${page}">
			<#if sortBy == self.name>
				<#assign columnClass="sortCurrentDescend"/>
			</#if>   				
		</#if>
		<a href="${columnUrl}" class="${columnClass}">
			status:${self.label!""}
		</a>
	</#if>
</th>
