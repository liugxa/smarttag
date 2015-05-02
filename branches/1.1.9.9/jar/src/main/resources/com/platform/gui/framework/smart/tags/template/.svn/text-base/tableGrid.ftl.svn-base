<#include "common.ftl">

<table class="tableBasic" id="st_table" name="st_table">
	<tr>
		<#list tableGrid.cells as cell>
			<th class="${getThClass(cell)}" style="${getColumnStyle(cell)}">
				<#if cell.disable?? && cell.disable>
					${getText(cell.label)}   		
				<#else>
					<#if cell.decorate?? && cell.decorate == "checkbox-all">
						<input type="checkbox" id="st_checkbox_all" name="st_checkbox_all_${cell.name}" onClick="st_checkbox_all_onClick(this)"/>${getText(cell.label)}
					<#else>
						<div  class="${getColumnClass(cell)}"><a href="${getColumnUrl(tableGrid , cell)}">${getText(cell.label)}</a></div>
					</#if>
				</#if>
			</th>
		</#list>
	</tr>

	<#list tableGrid.rows as row>
		<tr class="${getTrClass(row_index)}">
		    <#list tableGrid.cells as cell>
	    		<td class="${getTdClass(row_index , cell)}" style="${getColumnStyle(cell)}">${row.getColumnValue(row_index , cell)!'-'}</td>
		    </#list>
		</tr>
	</#list>
</table>