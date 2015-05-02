<#include "common.ftl">
<div class="filterBaseArea">
	<!--Filter Begin-->
	<div class="filterRange">

		<!--Position is absolute Begin-->
		<div class="filterEntranceClose">
			<a class="close" onclick="displayFilter(this)" href="javascript:;">Filter Settings:</a>
		</div>
		
		<!--Filter entrance-->
		<div id="filter" class="filterNoDisplay">
		
			<!--Filter content Begin-->
			<div id="contentoffsetHeight" class="filterInnerContent">
				<#list sections as section>
					<!--The layer which over iframe Begin -->
					<fieldset id="">
						<legend>${section.label}</legend>
						
						<#list section.elements as element>
							<#if element.type == "input">
								<label>${element.label}:</label>
								<input type="text"  value="" maxlength="120" name="${element.name!''}" size="15"/>
							</#if>
							
							<#if element.type == "select">
								<label>${element.label}:</label>
								<select name="">
								    <option selected="selected" value="Any">Any</option>
								    <option value="---">---</option>
								    <option value="LINUX86">LINUX86</option>
								</select>
							</#if>
						</#list>
						<button type="button">${section.button.label}</button>
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
	
</script>

<#include "filterResult.ftl">