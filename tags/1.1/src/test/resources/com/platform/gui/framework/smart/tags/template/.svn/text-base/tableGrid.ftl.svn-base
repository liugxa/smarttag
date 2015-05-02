<#include "common.ftl">
<div class="tableNaviLeading-top">
	<#include "pagination.ftl">
</div>
<table class="tableBasic">
  <tr>
  	<th></th>
  	<#list context.cells as cell>  	
    	<th>
			<#if sortOrder == "asc">
				<#assign cellUrl="${url}sortBy=${cell.name}&sortOrder=desc&page=${pagination.currentPage}">
				<#if sortBy == cell.name>
					<#assign cellClass="sortCurrentAscend"/>
				<#else>
					<#assign cellClass=""/>
				</#if>
			<#else>
				<#assign cellUrl="${url}sortBy=${cell.name}&sortOrder=asc&page=${pagination.currentPage}">
				<#if sortBy == cell.name>
					<#assign cellClass="sortCurrentDescend"/>
				<#else>
					<#assign cellClass=""/>
				</#if>    				
			</#if>
    		<a href="${cellUrl}" class="${cellClass}">${cell.value}</a></th>
    </#list>
    
    <#if rowAction?? && rowAction.options??>
    	<th>Actions</th>
    </#if>
  </tr>
  
 	<#list context.rows as row>
		<#-- change the tr's color -->
		<#if row_index%2 == 0>
			<#assign trColor="bgcolorType1">
		<#else>
			<#assign trColor="bgcolorType2">
		</#if>
		<tr class="${trColor}">
	  	
	  	<#-- add the check box/radio or not -->
	  	<td></td>
	  	
	  	<#-- display the column value -->
	    <#list context.cells as cell>
	        <#assign cellValue="${row.getColumnValue(cell)!'-'}">
    		
    		<#-- add the link or not -->
    		<td>${cellValue}</td>
	    </#list>

		<#-- display the row action or not -->
		<#if rowAction?? && rowAction.options??>    
	    <td>
	    	<select name="" onChange="tableGridRowAction(this)">
				<#list rowAction.options as option>
					<option value="${option.name}">${option.label}</option>
				</#list>
			</select>
	    </td>
	    </#if>
	  </tr>
  </#list>
</table>

<script>
	function tableGridRowAction(_select){
		alert("You Click the row Action and choice " + _select.options[_select.selectedIndex].value);
	}
	
	function tableGridCellAction(_cellValue){
		alert("You Click one of the column and its value is " + _cellValue);
	}

</script>
<div class="tableNaviLeading-bottom">
	<#include "pagination.ftl">
</div>

<#include "preferences.ftl">