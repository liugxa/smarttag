<#include "common.ftl">
<div id="filterBaseArea" class="filterBaseArea">
	<!--Filter Begin-->
	<div class="filterRange">

		<!--Position is absolute Begin-->
		<div class="filterEntranceClose">
			<a class="close" onClick="st_filter_display('${context.name}' , this)" href="javascript:;">
				<#if filter.label??>
					${getText(context , filter.label)}
				<#else>
					${getText(context , 'st.list.table.filter')}
				</#if>
			</a>
		</div>
		
		<!--Filter entrance-->
		<div id="st_filter_${context.name}" class="filterNoDisplay">
			<div id="st_offset_${context.name}" class="filterInnerContent">
				<#list filter.sections as section>
					<fieldset id="st_filter_section_${section_index}_${context.name}">
						<legend>${getText(context , section.label)}</legend>
						<#list section.items as item>
							<label>${getText(context , item.label)}</label>
							${section.getItemValue(context , item_index , context.filterData , item)!'-'}
						</#list>
						<button type="button" onClick="st_filter_onsubmit('${context.name}' , ${section_index} , ${filter.sections?size} , '${context.name}')">${getText(context , section.button.label)}</button>
					</fieldset>
				</#list>				
			</div>
			
			<!--The layer which over iframe End -->
			<iframe id="st_iframe_${context.name}" frameborder="0" marginheight="0" marginwidth="0" class="filterFrame"></iframe><!--For IE's bug-->
		</div>
		<!--Filter content End-->
	</div>
	<!--Position is absolute End-->
</div>


<div id="filterSettingInfo" class="filterSettingInfo">
	<#if context.filterData??>
		<#list context.filterData.items as item>
			${getText(context , item.label)}=<em>${getItemValue(context , item)}</em>;
		</#list>
		
		<#if tableGrid??>
			${getText(context , 'st.list.table.filter.sortBy')}: <em>${getSortByValue(context , tableGrid)}</em>;
			${getText(context , 'st.list.table.filter.result')}: <em>${context.dataSize} ${getText(context , 'st.list.table.filter.found')}.</em>
		</#if>
	</#if>	 
</div>