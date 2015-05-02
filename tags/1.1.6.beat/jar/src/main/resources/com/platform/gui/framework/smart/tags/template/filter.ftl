<#include "common.ftl">
<div class="filterBaseArea">
	<!--Filter Begin-->
	<div class="filterRange">

		<!--Position is absolute Begin-->
		<div class="filterEntranceClose">
			<a class="close" onClick="displayFilter(this)" href="javascript:;">${filter.label!'-'}</a>
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
						<button type="button" onClick="filterData(${section_index})">${section.button.label}</button>
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


<script>
function displayFilter(a){
	var filter = document.getElementById("filter");
	if(filter.className == "filterNoDisplay"){
			filter.className = "filterDisplay";
			a.parentNode.className = "filterEntranceOpen";
			a.className = "open";
			a.blur();
		}else{
			filter.className = "filterNoDisplay";
			a.parentNode.className = "filterEntranceClose";
			a.className = "close";
			a.blur();
		}
	//For IE's bug that the drop-down lists are not blocked by layer. 
	var contentoffsetHeight = document.getElementById("contentoffsetHeight");	
	var IEbugID1 = document.getElementById("forIEbug1");
	//alert(contentoffsetHeight.offsetHeight);
	IEbugID1.style.height = contentoffsetHeight.offsetHeight + "px"; 
	IEbugID1.parentNode.style.height = 	(contentoffsetHeight.offsetHeight + 20) + "px";	
}

function filterData(_section){
	var form = document.getElementById("tableGridForm");
	//disable the other element
	var filterSectionsDiv = document.getElementById("contentoffsetHeight");
	
	//disable the inputs
	var inputs = filterSectionsDiv.getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		var inputId = inputs[i].id;
		if(inputId.indexOf("s_" + _section) == -1){
			inputs[i].disabled = true;
		}
	}
	
	//disable the selects
	var selects = filterSectionsDiv.getElementsByTagName("select");
	for(var i=0;i<selects.length;i++){
		var selectId = selects[i].id;
		if(selectId.indexOf("s_" + _section) == -1){
			selects[i].disabled = true;
		}
	}
	
	//change the page paramete to 0
	form.page.value = 0;
	form.submit();
}
</script>

<#include "filterResult.ftl">