<#include "common.ftl">

<table id="st_${context.name}_navigation" class="pagination">
	<tr>
		<td class="alginedCtrl">
			<div class="forIE">
				<!-- First Page -->
				<#if tableGrid.pagination.currentPage.value == 0>
					<a class="firstDisabled">${getText(context , tableGrid.pagination.firstPage.label)}</a> | 
				<#else>
					<a class="first" href="#" onClick="st_pagination_onClick('${context.name}' , this , '${getPageUrl(context , tableGrid.pagination.firstPage)}');return false;">${getText(context , tableGrid.pagination.firstPage.label)}
					(${getPageBegin(context , tableGrid.pagination.firstPage)}-${getPageEnd(context , tableGrid.pagination.firstPage)})</a> | 
				</#if>
				
				<!-- Previous Page -->
				<#if tableGrid.pagination.previousPage.value lt 0 || tableGrid.pagination.previousPage.value gt tableGrid.pagination.lastPage.value>
					<a class="previousDisabled">${getText(context , tableGrid.pagination.previousPage.label)}</a> | 
				<#else>
					<a class="previous" href="#" onClick="st_pagination_onClick('${context.name}' , this , '${getPageUrl(context , tableGrid.pagination.previousPage)}');return false;">${getText(context , tableGrid.pagination.previousPage.label)} 
					(${getPageBegin(context , tableGrid.pagination.previousPage)}-${getPageEnd(context , tableGrid.pagination.previousPage)})</a> | 
				</#if>
			
				<!-- Current Page -->
					<span class="needBold">${getPageBegin(context , tableGrid.pagination.currentPage)}-${getPageEnd(context , tableGrid.pagination.currentPage)}</span> | 
					
				<!-- Next Page -->
				<#if tableGrid.pagination.nextPage.value lt 0 || tableGrid.pagination.nextPage.value gt tableGrid.pagination.lastPage.value>
					<a class="nextDisabled">${getText(context , tableGrid.pagination.nextPage.label)}</a> | 
				<#else>
					<a class="next" href="#" onClick="st_pagination_onClick('${context.name}' , this , '${getPageUrl(context , tableGrid.pagination.nextPage)}');return false;">${getText(context , tableGrid.pagination.nextPage.label)}
					(${getPageBegin(context , tableGrid.pagination.nextPage)}-${getPageEnd(context , tableGrid.pagination.nextPage)})</a> | 
				</#if>
				
				<!-- Last Page -->
				<#if tableGrid.pagination.currentPage.value == tableGrid.pagination.lastPage.value>
					<a class="lastDisabled">${getText(context , tableGrid.pagination.lastPage.label)}</a>
				<#else>
					<a class="last" href="#" onClick="st_pagination_onClick('${context.name}' , this , '${getPageUrl(context , tableGrid.pagination.lastPage)}');return false;">${getText(context , tableGrid.pagination.lastPage.label)}
					(${getPageBegin(context , tableGrid.pagination.lastPage)}-${getPageEnd(context , tableGrid.pagination.lastPage)})</a>
				</#if>
			</div>
		</td>
	</tr>
</table>