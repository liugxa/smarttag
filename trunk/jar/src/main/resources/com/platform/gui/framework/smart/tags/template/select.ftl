	
	<div id="st_select_div_${select.id!''}" class="baseDiv">
		<#if select.readonly?? && select.readonly == true>
		<input id="st_select_input_${select.id!''}" name="${select.name!''}" value="${select.value!select.options[0].value}" class="myinput-disable" onkeydown="${select.onkeydown!''}" readonly/>
		<#else>
		<input id="st_select_input_${select.id!''}" name="${select.name!''}" value="${select.value!select.options[0].value}" class="myinput" onkeydown="${select.onkeydown!''}"/>
		</#if>
		<div class="iconInput" onclick="st_select_display('${select.id!''}');"></div>
		
		<div id="st_select_div2_${select.id!''}" class="divClose">
			<select id="st_select_${select.id!''}" class="myselectClose" size="${select.options?size + 1}" 
				onclick="${select.onclick!'st_select_onClick(this)'};" onblur="${select.onblur!'st_select_onBlur(this)'};" 
				onchange="${select.onchange!'st_select_onChange(this)'}"
				onmouseup="st_select_onMouseUp(event,this);" onkeyup="st_select_onKeyUp(event,this);">
				<#list select.options as option>
					<#if select.value??>
						<#if select.value == option.value>
							<option value="${option.key}" selected>${option.value}</option>
						<#else>
							<option value="${option.key}">${option.value}</option>
						</#if>
					<#else>
						<#if option_index == 0>
							<option value="${option.key}" selected>${option.value}</option>
						<#else>
							<option value="${option.key}">${option.value}</option>
						</#if>
					</#if>
				</#list>
			</select>
		</div>
	</div>
		
	<script>
		function st_select_display(_selectId){
			var divName = "st_select_div_" + _selectId;
			var divs = document.getElementsByTagName("div");
			for(var i=0;i<divs.length;i++){
				if(divs[i].id != null && divs[i].id == divName){
					divs[i].style.zIndex = 1;
				}else{
					divs[i].style.zIndex = 0;
				}
			}
			
			//close/open the drop-down list
			var div2 = document.getElementById("st_select_div2_" + _selectId);
			var select = document.getElementById("st_select_" + _selectId);
			if(select.className == "myselectClose"){
				div2.className = "divOpen";
				select.className = "myselectOpen";
			}else{
				div2.className = "divClose";
				select.className = "myselectClose";
			}
			
			//if the input be omitted, un-select the drop-down list
			var input = document.getElementById("st_select_input_" + _selectId);
			if(select.selectedIndex != -1){
				var selectValue = select.options[select.selectedIndex].text;
				if(input.value != selectValue) select.options[select.selectedIndex].selected = false;
			}
			
			//focus on the select 
			select.focus();
		}
		
		function st_select_onClick(_this){
			st_select_onBlur(_this);
		}
		
		function st_select_onChange(_this){
			st_select_onBlur(_this);
		}
		function st_select_onBlur(_this){
			var selectId = _this.id.substring("st_select_".length);
			
			var div2 = document.getElementById("st_select_div2_" + selectId);
			var input = document.getElementById("st_select_input_" + selectId);
			
			if(_this.selectedIndex != -1){
				var selectValue = _this.options[_this.selectedIndex].text;
				input.value = selectValue;
			}
			
			div2.className = "divClose";
			_this.className = "myselectClose";
		}
		
		function st_select_onMouseUp(_event,_this){
			var agent = window.navigator.userAgent.toLowerCase();
			if(agent.indexOf("msie") < 0){
				if(_event.target.tagName == "OPTION"){
					st_select_onBlur(_this);
				}
			}else{
				st_select_onBlur(_this);
			}
		}
		
		function st_select_onKeyUp(_event,_this){
			var Key = (window.event) ? event.keyCode : _event.keyCode;
			if(Key == 13) st_select_onBlur(_this);
		}
	</script>
