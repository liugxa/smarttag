<#include "common.ftl">

<table class="tableBasic" id="st_table" name="st_table">
	<tr>
		<#list tableGrid.cells as cell>
			<th class="${getThClass(context , cell)}" style="${getColumnStyle(cell)}" title="${getText(context , cell.title)}">
				<#if cell.disable?? && cell.disable>
					${getText(context , cell.label)}   		
				<#else>
					<#if cell.decorate?? && cell.decorate == "checkbox-all">
						<input type="checkbox" id="st_checkbox_all_${context.name}" name="st_checkbox_all_${context.name}" onClick="st_checkbox_all_onClick('${context.name}' , this , '${cell.name}');st_checkbox_all_onClick_after('${context.name}' , this);"/>${getText(context , cell.label)}
					<#else>
						<div  class="${getColumnClass(context , cell)}"><a href="${getColumnUrl(context , tableGrid , cell)}">${getText(context , cell.label)}</a></div>
					</#if>
				</#if>
			</th>
		</#list>
	</tr>

	<#list tableGrid.rows as row>
		<tr class="${getTrClass(row_index)}">
		    <#list tableGrid.cells as cell>
	    		<td class="${getTdClass(context , row_index , cell)}" style="${getColumnStyle(cell)}">${row.getColumnValue(context , row_index , cell)!'-'}</td>
		    </#list>
		</tr>
	</#list>
</table>