<#include "common.ftl">

<div class="filterBaseArea">
	<div class="filterRange">
		<div class="filterEntranceClose">
			<a class="close" onClick="st_filter_display(this);return false;" href="#">${self.label!""}</a>
		</div>
		
		<div id="st_filter" class="filterNoDisplay">
			<div id="contentoffsetHeight" class="filterInnerContent">
				<#list self.sections as section>
					${section.html}
				</#list>				
			</div>
			<!--The layer which over iframe End -->
			<iframe id="forIEbug1" frameborder="0" marginheight="0" marginwidth="0"></iframe>
		</div>
	</div>
</div>

<script>
	var sections = [];
	<#list self.sections as section>
		sections.push("${section.id}");
	</#list>
	
	function st_filter_display(a){
		var filter = document.getElementById("st_filter");
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

		IEbugID1.style.height = contentoffsetHeight.offsetHeight + "px"; 
		IEbugID1.parentNode.style.height = 	(contentoffsetHeight.offsetHeight + 20) + "px";	
	}
	
	function initilize(){
		for(var i=0;i<sections.length;i++){
			_st_section(sections[i] , false);
		}
	}
	
	function st_section_disable(_sectionId){
		_st_section_(_sectionId , true);
		
		//set the others's status to enable
		for(var i=0;i<sections.length;i++){
			if(sections[i] != _sectionId){
				_st_section_(sections[i] , false);
			}
		}
	}

	function st_section_enable(_sectionId){
		_st_section_(_sectionId , false);
		
		//set the others's status to disable	
		for(var i=0;i<sections.length;i++){
			if(sections[i] != _sectionId){
				_st_section_(sections[i] , true);
			}
		}
	}
	
	function _st_section_(_sectionId , _disabled){
		var section = document.getElementById("st_section_" + _sectionId);
		if(section != null){
			//disable all of the element in this section
			var inputs = section.getElementsByTagName("input");
			for(var i=0;i<inputs.length;i++){
				inputs[i].disabled = _disabled;
			}
		
			//disable the selects
			var selects = section.getElementsByTagName("select");
			for(var i=0;i<selects.length;i++){
				selects[i].disabled = _disabled;
			}
		}
	}
</script>

<div class="filterSettingInfo">
	<#if self.result?? && self.result.elements??>
		<#list self.result.elements?keys as key>
			${key} = <em>${self.result.elements[key]!""}</em>;
		</#list>
		Filter Result:  <em>${context.dataSize!''} found.</em>
	</#if> 
</div>