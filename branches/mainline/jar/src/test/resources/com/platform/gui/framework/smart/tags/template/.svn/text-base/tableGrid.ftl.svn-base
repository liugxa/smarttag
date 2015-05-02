<#include "common.ftl">

<table class="tableBasic" id="st_table_${self.name!''}" name="${self.name!''}">
	<tr>
 		<#list self.cells as cell>
			${cell.html}
		</#list>
	</tr>
  
	<#list self.rows as row>
		<#-- change the tr's color -->
		<#if row_index%2 == 0>
			<#assign trColor="bgcolorType1">
		<#else>
			<#assign trColor="bgcolorType2">
		</#if>
		
		<tr class="${trColor}">  	
		  	<#-- display the column value -->
		    <#list self.cells as cell>
		        <#assign cellValue="${row.getColumnValue(row_index , cell)!'-'}">
	    		<td>${cellValue}</td>
		    </#list>
		</tr>
  </#list>
</table>