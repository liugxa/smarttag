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

function st_checkbox_onClick_after(_this , _bean){

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

function filterData(_formId , _section){
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
	var form = document.getElementById(_formId);
	form.submit();
}
</script>