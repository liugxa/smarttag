<#include "common.ftl">

<table class="tableBasic">
  <tr>
  	<#if tableGrid.multiple??>
  		<th></th>
  	</#if>
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
    
    <#if tableGrid.rowAction?? && tableGrid.rowAction.options??>
    	<th>Actions</th>
    </#if>
  </tr>
  
 	<#list tableGrid.rows as row>
		<#-- change the tr's color -->
		<#if row_index%2 == 0>
			<#assign trColor="bgcolorType1">
		<#else>
			<#assign trColor="bgcolorType2">
		</#if>
		<tr class="${trColor}">
	  	
	  	<#-- add the check box/radio or not -->
	  	<#if tableGrid.multiple??>
	  		<#assign primaryValue="${row.getPrimaryValue(tableGrid.primaryKey)}">
	  		<td>
	  			<#if row.isChecked>
	  				<input name="checkboxs" type="${tableGrid.multiple}" onChange="tableGridMultiple(this , '${url}' , '${primaryValue}')" checked>
	  			<#else>
	  				<input name="checkboxs" type="${tableGrid.multiple}" onChange="tableGridMultiple(this , '${url}' , '${primaryValue}')">
	  			</#if>
	  		</td>
	  	</#if>
	  	
	  	<#-- display the column value -->
	    <#list tableGrid.cells as cell>
	        <#assign cellValue="${row.getColumnValue(cell)!'-'}">
    		
    		<#-- add the link or not -->
    		<td>${cellValue}</td>
	    </#list>

		<#-- display the row action or not -->
		<#if tableGrid.rowAction?? && tableGrid.rowAction.options??>    
	    <td>
	    	<select name="" onChange="tableGridRowAction(this)">
				<#list tableGrid.rowAction.options as option>
					<option value="${option.name}">${option.label}</option>
				</#list>
			</select>
	    </td>
	    </#if>
	  </tr>
  </#list>
</table>

<script>
	<#if context.contextPath??>
		var contextPath = "${context.contextPath}";
	<#else>
		var contextPath = "";
	</#if>
	function tableGridRowAction(_select){
		alert("You Click the row Action and choice " + _select.options[_select.selectedIndex].value);
	}
	
	function tableGridCellAction(_cellValue){
		alert("You Click one of the column and its value is " + _cellValue);
	}

	function tableGridMultiple(_check , _url , _primaryKey){
		var ajax = new JSAjax();
		if(_check.checked){
			//add the value into the checked record list
			ajax.postData(contextPath + "/doCheckRecord.action?" + "record=" + _primaryKey , null , null);
		}else{
			//remove the value from the checked record list
			ajax.postData(contextPath + "/doUnCheckRecord.action?" + "record=" + _primaryKey , null , null);
		}
	}
	
	function getCheckedRecords(){
		var ajax = new JSAjax();
		//get the checked record list by use ajax
		var checkedRecords = ajax.loadData(contextPath + "/doGetCheckedRecords.action" , null , null);
		return checkedRecords;
	}
</script>
