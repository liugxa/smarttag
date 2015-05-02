<#include "common.ftl">
<div class="filterBaseArea">
	<!--Filter Begin-->
	<div class="filterRange">

		<!--Position is absolute Begin-->
		<div class="filterEntranceClose">
			<a class="close" onClick="displayFilter(this)" href="javascript:;">${getText(filter.label)}</a>
		</div>
		
		<!--Filter entrance-->
		<div id="filter" class="filterNoDisplay">
		
			<!--Filter content Begin-->
			<div id="contentoffsetHeight" class="filterInnerContent">
				<#list filter.sections as section>
					<!--The layer which over iframe Begin -->
					<fieldset id="">
						<legend>${section.label}</legend>
						<#list section.elements as element>
							<input id="s_${section_index}_e_${element_index}_l" type="hidden"  value="${element.label}" name="filterData.conditions[${element_index}].label"/>
							<input id="s_${section_index}_e_${element_index}_n" type="hidden"  value="${element.name}" name="filterData.conditions[${element_index}].name"/>
							<#if element.type == "input">
								<label>${element.label}:</label>
								<input id="s_${section_index}_e_${element_index}_v" type="text"  value="" maxlength="120"  name="filterData.conditions[${element_index}].value" size="15"/>
							</#if>
							
							<#if element.type == "select">
								<label>${element.label}:</label>
								<select id="s_${section_index}_e_${element_index}_v" name="filterData.conditions[${element_index}].value">
								    <option selected="selected" value="Any">Any</option>
								    <option value="---">---</option>
								    <option value="LINUX86">LINUX86</option>
								</select>
							</#if>
						</#list>
						<button type="button" onClick="filterData('st_form_${name}' , '${section_index}')">${section.button.label}</button>
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
<#include "filterResult.ftl">