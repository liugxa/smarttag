<#include "common.ftl">

<table class="tableBasic">
  <tr>
  	<#list tableGrid.cells as cell>
  		<th>
			<#if sortOrder == "asc">
				<#assign cellUrl="${url}sortBy=${cell.name}&sortOrder=desc&page=${tableGrid.pagination.currentPage}">
				<#if sortBy == cell.name>
					<#assign cellClass="sortCurrentAscend"/>
				<#else>
					<#assign cellClass=""/>
				</#if>
			<#else>
				<#assign cellUrl="${url}sortBy=${cell.name}&sortOrder=asc&page=${tableGrid.pagination.currentPage}">
				<#if sortBy == cell.name>
					<#assign cellClass="sortCurrentDescend"/>
				<#else>
					<#assign cellClass=""/>
				</#if>    				
			</#if>
    		<a href="${cellUrl}" class="${cellClass}">${cell.value}</a></th>
    </#list>
  </tr>
  
 	<#list tableGrid.rows as row>
		<#-- change the tr's color -->
		<#if row_index%2 == 0>
			<#assign trColor="bgcolorType1">
		<#else>
			<#assign trColor="bgcolorType2">
		</#if>
		<tr class="${trColor}">
	  	
	  	<#-- display the column value -->
	    <#list tableGrid.cells as cell>
	        <#assign cellValue="${row.getColumnValue(row_index , cell)!'-'}">
    		
    		<#-- add the link or not -->
    		<td>${cellValue}</td>
	    </#list>
	  </tr>
  </#list>
</table>

<script>
	<#if context.contextPath??>
		var contextPath = "${context.contextPath}";
	<#else>
		var contextPath = "";
	</#if>
	
	function tableGridRowAction(_select , _bean){
		alert("You Click the row Action and choice " + _select.options[_select.selectedIndex].value);
	}
	
	function tableGridCellAction(_cellValue){
		alert("You Click one of the column and its value is " + _cellValue);
	}

	function tableGridMultiple(_check , _primaryKey){
		var ajax = new JSAjax();
		
		if(_check.checked){
			//add the value into the checked record list
			ajax.postData(contextPath + "/doCheckRecords.action?" + "records=" + _primaryKey , null , false);
		}else{
			//remove the value from the checked record list
			ajax.postData(contextPath + "/doUnCheckRecords.action?" + "records=" + _primaryKey , null , false);
		}
	}
	
	function getCheckedRecords(){
		var ajax = new JSAjax();
		
		//get the checked record list by use ajax
		var checkedRecords = ajax.loadData(contextPath + "/doGetCheckedRecords.action" , null , false);
		return checkedRecords;
	}
	
	function doCheckedRecords(_records){
		if(_records != null){
			var rsValue = "";
			var rs = _records.split(",")
			for(var i=0;i<rs.length;i++){
				var checkbox = document.getElementById(rs[i]);
				if(checkbox != null){
					checkbox.checked = true;
					if(i < rs.length){
						rsValue = rsValue + checkbox.value + ",";
					}else{
						rsValue = rsValue + checkbox.value;
					}
				}
			}
			
			//send the ajax request
			var ajax = new JSAjax();
			ajax.postData(contextPath + "/doCheckRecords.action?" + "records=" + rsValue , null , false);
		}
	}
	
	function doUnCheckedRecords(_records){
		if(_records != null){
			var rsValue = "";
			var rs = _records.split(",")
			for(var i=0;i<rs.length;i++){
				var checkbox = document.getElementById(rs[i]);
				if(checkbox != null){
					checkbox.checked = false;
					if(i < rs.length){
						rsValue = rsValue + checkbox.value + ",";
					}else{
						rsValue = rsValue + checkbox.value;
					}
				}
			}
			
			//send the ajax request
			var ajax = new JSAjax();
			ajax.postData(contextPath + "/doUnCheckRecords.action?" + "records=" + rsValue , null , false);
		}
	}
	
	  
</script>
