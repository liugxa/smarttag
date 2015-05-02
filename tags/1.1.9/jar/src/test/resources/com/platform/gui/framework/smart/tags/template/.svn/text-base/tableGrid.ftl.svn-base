<#include "common.ftl">

<table class="tableBasic" id="st_table" name="st_table">
  <tr>
  	<#list tableGrid.cells as cell>
  		<th>
   			<#if cell.disable?? && cell.disable>
    			<#if context.resource??>
    				${context.resource.getText(cell.label)!""}
    			<#else>
    				${cell.label!""}
    			</#if>    		
    		<#else>
				<#if sortOrder == "asc">
					<#assign cellUrl="${url}st_name=${context.name}&st_sortBy=${cell.name}&st_sortOrder=desc&st_page=${tableGrid.pagination.currentPage.value}">
					<#if sortBy == cell.name>
						<#assign cellClass="sortCurrentAscend"/>
					<#else>
						<#assign cellClass=""/>
					</#if>
				<#else>
					<#assign cellUrl="${url}st_name=${context.name}&st_sortBy=${cell.name}&st_sortOrder=asc&st_page=${tableGrid.pagination.currentPage.value}">
					<#if sortBy == cell.name>
						<#assign cellClass="sortCurrentDescend"/>
					<#else>
						<#assign cellClass=""/>
					</#if>    				
				</#if>
	    		<a href="${cellUrl}" class="${cellClass}">
	    			<#if context.resource??>
	    				${context.resource.getText(cell.label)!""}
	    			<#else>
	    				${cell.label!""}
	    			</#if>
	    		</a>
    		</#if>
    	</th>
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