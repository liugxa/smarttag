/**
 * SummaryColumnDecorate's js functions
 * on mouse over
 */
function st_summary_onClick(_formId , _divId , _state){
	var s = document.getElementById("st_summary_s_" + _divId + "_" + _formId);
	var c = document.getElementById("st_summary_c_" + _divId + "_" + _formId);	
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

/**
 * the check box all button's on click event
 * @param {Object} _formId
 * @param {Object} _this
 * @param {Object} _cellName
 */
function st_checkbox_all_onClick(_formId , _this , _cellName){
	var checkboxs = document.getElementsByName("st_checkbox_" + _cellName + "_" + _formId);
	for(var i = 0; i < checkboxs.length; i++) {
		checkboxs[i].checked = _this.checked;
	}
}

/**
 * the check box button's on click event
 * @param {Object} _formId
 * @param {Object} _this
 * @param {Object} _bean
 */
function st_checkbox_onClick(_formId , _this , _bean) {
	var checkboxAll = document.getElementById("st_checkbox_all_" + _formId);
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

/**
 * the preference link event
 * TODO: the preference function do not support.
 * @param {Object} _formId
 */
function st_preference_onClick(_formId){
	alert("Prefernece....");
}

/**
 * display the filter or not
 * TODO: it can not work fine in multi-table page.
 * @param {Object} _formId
 * @param {Object} _div
 */
function st_filter_display(_formId , _div){
	var filter = document.getElementById("st_filter_" + _formId);
	if(filter.className == "filterNoDisplay"){
			filter.className = "filterDisplay";
			_div.parentNode.className = "filterEntranceOpen";
			_div.className = "open";
			_div.blur();
		}else{
			filter.className = "filterNoDisplay";
			_div.parentNode.className = "filterEntranceClose";
			_div.className = "close";
			_div.blur();
		}
	//For IE's bug that the drop-down lists are not blocked by layer. 
	var offset = document.getElementById("st_offset_" + _formId);	
	var iframe = document.getElementById("st_iframe_" + _formId);
	
	iframe.style.height = offset.offsetHeight + "px"; 
	iframe.parentNode.style.height = (offset.offsetHeight + 20) + "px";	
}

/**
 * the filter button's on submit event
 * @param {Object} _formId
 * @param {Object} _sectionId
 * @param {Object} _sections
 * @param {Object} _formId
 */
function st_filter_onsubmit(_formId , _sectionId , _sections , _formId){
	for(var i=0;i<_sections;i++){
		if(_sectionId == i){
			//enable this section
			st_filter_section_enable(_formId , i);
		}else{
			//disable the other sections
			st_filter_section_disable(_formId , i);			
		}
	}
	
	//set the page value to 0
	var st_page = document.getElementById("st_page_" + _formId);
	if(st_page != null) st_page.value = 0;
	
	
	_st_form_submit(_formId);
}

/**
 * if u want to submit the form, u should invoke this method.
 * when submit the form, the filter should be disabled at first.
 * @param {Object} _formId
 */
function st_form_submit(_formId){
	//disable the filter 
	_st_filter_enable(_formId , false);
	
	//submit the form
	_st_form_submit(_formId);
}

/**
 * enable the filter 
 * @param {Object} _formId
 */
function st_filter_enable(_formId){
	_st_filter_enable(_formId , true);	
}

/**
 * disable the fitler
 * @param {Object} _formId
 */
function st_filter_disable(_formId){
	_st_filter_enable(_formId , false);	
}

/**
 * enable the filter's section
 * @param {Object} _formId
 * @param {Object} _sectionId
 */
function st_filter_section_enable(_formId , _sectionId){
	_st_filter_section_enable(_formId , _sectionId , true);
}

/**
 * disable the filter's section
 * @param {Object} _formId
 * @param {Object} _sectionId
 */
function st_filter_section_disable(_formId , _sectionId){
	_st_filter_section_enable(_formId , _sectionId , false);
}

/**
 * to get all of the "hidden" parameters
 * @param {Object} _formId
 */
function st_getParameters(_formId){
	var r = "";
	var parameters = ['st_name' , 'st_sortBy' , 'st_sortOrder' , 'st_page'];
	for(var i=0;i<parameters.length;i++){
		var parameter = document.getElementById(parameters[i] + "_" + _formId);
		if(i == parameters.length - 1){
			r = r + parameters[i] + "=" + parameter.value;
		}else{
			r = r + parameters[i] + "=" + parameter.value + "&";
		}
	}
	return r;
}

//private methods
function _st_filter_enable(_formId , _enable){
	var filterDiv = document.getElementById("st_filter_" + _formId);
	
	//disable the inputs
	var inputs = filterDiv.getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		inputs[i].disabled = !_enable;
	}
	
	//disable the selects
	var selects = filterDiv.getElementsByTagName("select");
	for(var i=0;i<selects.length;i++){
		selects[i].disabled = !_enable;
	}	
}

function _st_filter_section_enable(_formId , _sectionId , _enable){
	//disable the other sections
	var sectionDiv = document.getElementById("st_filter_section_" + _sectionId + "_" + _formId);
	
	//disable the inputs
	var inputs = sectionDiv.getElementsByTagName("input");
	for(var i=0;i<inputs.length;i++){
		inputs[i].disabled = !_enable;
	}
	
	//disable the selects
	var selects = sectionDiv.getElementsByTagName("select");
	for(var i=0;i<selects.length;i++){
		selects[i].disabled = !_enable;
	}
}

function _st_form_submit(_formId){
	//submit the form
	var form = document.getElementById("st_form_" + _formId);
	if(form != null) form.submit();
}

//the radio button's onClick event
function st_radio_onClick(_formId , _this , _bean){}

function st_select_onChange(_formId , _this , _bean){}

//overwriter functions
//the radio button's onClick event
function st_radio_onClick_after(_formId , _this , _bean){}

//the check box's onClick event
function st_checkbox_onClick_after(_formId , _this , _bean){}

//the check box all's onClick event
function st_checkbox_all_onClick_after(_formId , _this){}

//the filter select's onChange event
function st_filter_select_onChange(_formId , _this , _item){}
