<#include "common.ftl">

<input type="hidden" id="st_name_${context.name}" name="st_name" value="${context.name}"/>
<input type="hidden" id="st_sortBy_${context.name}" name="st_sortBy" value="${getSortBy(context)}"/>
<input type="hidden" id="st_sortOrder_${context.name}" name="st_sortOrder" value="${getSortOrder(context)}"/>
<input type="hidden" id="st_page_${context.name}" name="st_page" value="${getPage(context)}"/>
	
<table class="tableBasic" id="st_table" name="st_table">
	<tr>
		<#list tableGrid.cells as cell>
			<th class="${getThClass(context , cell)}" style="${getColumnStyle(cell)}" title="${getText(context , cell.title)}">
				<#if cell.disable?? && cell.disable>
					${getText(context , cell.label)}
				<#else>
					<#if cell.decorate?? && cell.decorate == "checkbox-all">
						<ul>
							<li>${getText(context , cell.label)}</li>
							<li><input type="checkbox" id="st_checkbox_all_${context.name}" name="st_checkbox_all_${context.name}" onClick="st_checkbox_all_onClick('${context.name}' , this , '${cell.name}');st_checkbox_all_onClick_after('${context.name}' , this);"/></li>
						</ul>
					<#else>
						<div  class="${getColumnClass(context , cell)}">
							<a href="${getColumnUrl(context , tableGrid , cell)}">${getText(context , cell.label)}</a>
						</div>
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