<script language="JavaScript">
/**
 * SummaryColumnDecorate's js functions
 * on mouse over
 */
function st_summary_onClick(_divId , _state){
	var s = document.getElementById("st_summary_s_" + _divId);
	var c = document.getElementById("st_summary_c_" + _divId);	
 	if (_state == "more") {
		s.style.display = "none";	
		s.style.overflow = "";
		
		c.style.overflow = "";
		c.style.display = "";
		c.style.whiteSpace = "normal";
	}else {
		s.style.display = "";
		s.style.overflow = "";
		
		c.style.overflow = "";
		c.style.display = "none";
	}
}

function st_checkbox_all_onClick(_this){
	var name = st_getElementName(_this);
	var checkboxs = document.getElementsByName(name);
	for(var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = _this.checked;
	}
}

function st_checkbox_onClick(_this , _bean) {
	var checkboxAll = document.getElementById("st_checkbox_all");
	if(checkboxAll != null){
		if(_this.checked != true){
			//set check all to unchecked.
			checkboxAll.checked = false;		
		}else{
			//does the other checkbox has been checked?
			var isAllOtherChecked = true;
			var checkboxs = document.getElementsByName(_this.name);			
			for(var i = 0; i < checkboxs.length; i++) {
				if(checkboxs[i].checked != true){
					isAllOtherChecked = false;
					break;
				}
			}
			if(isAllOtherChecked) checkboxAll.checked = true;
		}
	}
}

function st_getElementName(_element){
	var r = null;
	var name = _element.name;
	if(name != null){
		var position = name.lastIndexOf('_');
		r = name.substring(position + 1);
	}
	return r;
}

function st_preference_onClick(){
	alert("Prefernece....");
}

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

function st_filter_onsubmit(_sectionId , _sections , _formId){
	for(var i=0;i<_sections;i++){
		if(_sectionId == i){
			//enable this section
			_st_filter_section_enable(i);
		}else{
			//disable the other sections
			_st_filter_section_disable(i);			
		}
	}
	_st_form_submit(_formId);
}

function _st_form_submit(_formId){
	var form = document.getElementById("st_form_" + _formId);
	if(form != null) form.submit();
}

function _st_filter_section_enable(_sectionId){
	//enable this section
	var sectionDiv = document.getElementById("st_filter_section_" + _sectionId);
	
	//disable the inputs
	var inputs = sectionDiv.getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		inputs[i].disabled = false;
	}
	
	//disable the selects
	var selects = sectionDiv.getElementsByTagName("select");
	for(var i=0;i<selects.length;i++){
		selects[i].disabled = false;
	}
}

function _st_filter_section_disable(_sectionId){
	//disable the other sections
	var sectionDiv = document.getElementById("st_filter_section_" + _sectionId);
	
	//disable the inputs
	var inputs = sectionDiv.getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		inputs[i].disabled = true;
	}
	
	//disable the selects
	var selects = sectionDiv.getElementsByTagName("select");
	for(var i=0;i<selects.length;i++){
		selects[i].disabled = true;
	}
}

//overwriter functions
//the radio button's onClick event
function st_radio_onClick(_this , _bean){}

//the check box's onClick event
function st_checkbox_onClick_after(_this , _bean){}

//the check box all's onClick event
function st_checkbox_all_onClick_after(_this){}

//the radio button's onClick event
function st_radio_onClick_after(_this , _bean){}

//the filter select's onChange event
function st_filter_select_onChange(_this , _item){}
</script>