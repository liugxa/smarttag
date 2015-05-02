<div class="filterSettingInfo">
	<#if filter.result?? && filter.result.elements??>
		<#list filter.result.elements?keys as key>
			${key} = <em>${filter.result.elements[key]!""}</em>;
		</#list>
		Sort by:  <em>${sortByValue!""}</em>;   
		Filter Result:  <em>${tableGrid.dataSize} found.</em>
	</#if> 
</div>