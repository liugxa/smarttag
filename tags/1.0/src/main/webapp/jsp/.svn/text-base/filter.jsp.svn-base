<div class="filterBaseArea">
	<!--Filter Begin-->
	<div class="filterRange">

		<!--Position is absolute Begin-->
		<div class="filterEntranceClose">
			<a class="close" onclick="displayFilter(this)" href="javascript:;">Filter Setting</a>
		</div>
		
		<!--Filter entrance-->
		<div id="filter" class="filterNoDisplay">
		
			<!--Filter content Begin-->
			<div id="contentoffsetHeight" class="filterInnerContent">
				<!--The layer which over iframe Begin -->
				<fieldset id="">
					<legend>Find this host</legend>
					<label for="hostName">Host name:</label>
					<input type="text"  value="" maxlength="120" name="findHostName" size="15"/>
					<button type="button">Find</button>
				</fieldset>
			
				<fieldset id="">
					<legend>Filter hosts by</legend>
					<label for="hostType">Host type:</label>
					<select name="">
					    <option selected="selected" value="Any">Any</option>
					    <option value="---">---</option>
					    <option value="LINUX86">LINUX86</option>
					</select>
					<label for="hostState">Host state:</label>
					<select name="">
					    <option value="Any">Any</option>
					    <option value="---">---</option>
					    <option value="closed">Closed</option>
					    <option selected="selected" value="ok">OK</option>
					    <option value="unavail">Unavailable</option>
					</select>
					<label for="hostPriority">Process priority:</label>
					<select name="">
					    <option selected="selected" value="Any">Any</option>
					    <option value="---">---</option>
					    <option value="normal">Normal</option>
					    <option value="lowest">Lowest</option>
					</select>
					<label for="cpuUT">CPU Utilization:</label>
					<select name="">
					    <option selected="selected" value="Any">Any</option>
					    <option value="---">---</option>
					    <option value="10"><= 10%</option>
					    <option value="20"><= 20%</option>
					    <option value="30"><= 30%</option>
					    <option value="40"><= 40%</option>
					    <option value="50"><= 50%</option>
					    <option value="60"><= 60%</option>
					    <option value="70"><= 70%</option>
					    <option value="80"><= 80%</option>
					    <option value="90"><= 90%</option>
					    <option value="100"><= 100%</option>
					    <option value="---">---</option>
					    <option value="-10">>= 10%</option>
					    <option value="-20">>= 20%</option>
					    <option value="-30">>= 30%</option>
					    <option value="-40">>= 40%</option>
					    <option value="-50">>= 50%</option>
					    <option value="-60">>= 60%</option>
					    <option value="-70">>= 70%</option>
					    <option value="-80">>= 80%</option>
					    <option value="-90">>= 90%</option>
					</select>
					<button type="button">Filter</button>
				</fieldset>
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