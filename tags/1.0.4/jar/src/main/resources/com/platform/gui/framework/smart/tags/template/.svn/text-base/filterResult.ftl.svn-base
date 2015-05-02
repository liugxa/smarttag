<#-- Get the sort display name -->
<#if context.parameters.sortBy?? && cells??>
	<#list cells as cell>
		<#if cell.name == context.parameters.sortBy>
			<#assign sortByValue=cell.value>
		</#if>
	</#list>
</#if>

<div class="filterSettingInfo">
	<#if filter.result?? && filter.result.elements??>
		<#list filter.result.elements?keys as key>
			${key} = <em>${filter.result.elements[key]!""}</em>;
		</#list>
		Sort by:  <em>${sortByValue!""}</em>;   
		Filter Result:  <em>${context.dataSize} found.</em>
	</#if> 
</div>