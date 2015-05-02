<#include "common.ftl">

<table class="tableBasic">
  <tr>
  	<#list tableGrid.cells as cell>
  		<th>
			<#if sortOrder == "asc">
				<#assign cellUrl="${url}sortBy=${cell.name}&sortOrder=desc&page=${tableGrid.pagination.currentPage.value}">
				<#if sortBy == cell.name>
					<#assign cellClass="sortCurrentAscend"/>
				<#else>
					<#assign cellClass=""/>
				</#if>
			<#else>
				<#assign cellUrl="${url}sortBy=${cell.name}&sortOrder=asc&page=${tableGrid.pagination.currentPage.value}">
				<#if sortBy == cell.name>
					<#assign cellClass="sortCurrentDescend"/>
				<#else>
					<#assign cellClass=""/>
				</#if>    				
			</#if>
    		<a href="${cellUrl}" class="${cellClass}">${cell.label!'-'}</a></th>
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

function st_select_onChange(_select , _bean){}

function st_check_onClick(_checkbox , _index){}

</script>
