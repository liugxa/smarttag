<#list context.cells as cell>
	<#if cell.name == sortBy>
		<#assign sortByValue="${cell.value}">
	</#if>
</#list>
<div class="filterSettingInfo">
	<#if result??>
		<#list result.elements as element>
			${element.label} = <em>${element.value!""}</em>;
		</#list>
	<#else>
		<#list sections as section>
			<#if section.isDefault>
				<#list section.elements as element>
					${element.label} = <em>${element.defaultValue!""}</em>;
				</#list>
			</#if>
		</#list>
	</#if>
	Sort by:  <em>${sortByValue}</em>;   
	Filter Result:  <em>1 found.</em> 
</div>