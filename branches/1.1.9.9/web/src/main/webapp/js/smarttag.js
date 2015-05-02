/**
 * SummaryColumnDecorate's js functions
 * on mouse over
 */
 function st_summary_onClick(_divId , _state){
 	var s = document.getElementById("st_summary_s_" + _divId);
	var c = document.getElementById("st_summary_c_" + _divId);	
 	if (_state == "more") {
		s.style.display = "none";
		c.style.display = "";		
	}else {
		s.style.display = "";
		c.style.display = "none";
	}
 }
