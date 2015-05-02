<#include "common.ftl">
<div id="filterBaseArea" class="filterBaseArea">
	<!--Filter Begin-->
	<div class="filterRange">

		<!--Position is absolute Begin-->
		<div class="filterEntranceClose">
			<a class="close" onClick="displayFilter(this)" href="javascript:;">${getText(context , filter.label)}</a>
		</div>
		
		<!--Filter entrance-->
		<div id="filter" class="filterNoDisplay">
			<div id="contentoffsetHeight" class="filterInnerContent">
				<#list filter.sections as section>
					<fieldset id="st_filter_section_${section_index}">
						<legend>${getText(context , section.label)}</legend>
						<#list section.items as item>
							<label>${getText(context , item.label)}</label>
							${section.getItemValue(item_index , context.filterData , item)!'-'}
						</#list>
						<button type="button" onClick="st_filter_onsubmit(${section_index} , ${filter.sections?size} , '${context.name}')">${getText(context , section.button.label)}</button>
					</fieldset>
				</#list>				
			</div>
			<!--The layer which over iframe End -->
			<iframe id="forIEbug1" frameborder="0" marginheight="0" marginwidth="0"></iframe><!--For IE's bug-->
		</div>
		<!--Filter content End-->
	</div>
	<!--Position is absolute End-->
</div>


<div id="filterSettingInfo" class="filterSettingInfo">
	<#if filter.filterData??>
		<#list filter.filterData.items as item>
			${getText(context , item.label)} = <em>${item.value!""}</em>;
		</#list>
		
		<#if tableGrid??>
			Sort by:  <em>${getSortByValue(context , tableGrid)}</em>;   
			Filter Result:  <em>${tableGrid.dataSize} found.</em>
		</#if>
	</#if>	 
</div>