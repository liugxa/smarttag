<#if context.parameters.st_sortBy??>
	<#-- Get sort from the context parameters -->
	<#assign sortBy="${context.parameters.st_sortBy!''}">
	<#assign sortOrder="${context.parameters.st_sortOrder!''}">
<#else>
	<#-- Get sort from the configure object -->
	<#if context.configure??>
		<#assign sortBy="${context.configure.sortBy!''}">
		<#assign sortOrder="${context.configure.sortOrder!'desc'}">
	</#if>
</#if>

<#if context.action?index_of('?') != -1>
	<#assign address="${context.contextPath}${context.action}&">
<#else>
	<#assign address="${context.contextPath}${context.action}?">
</#if>

<#-- free marker functions -->
<#-- get current page value -->
<#function getPage _tableGrid>
	<#local r = 0>
	<#if _tableGrid??>
		<#local r = _tableGrid.pagination.currentPage.value>
	</#if>
	<#return r>
</#function>

<#-- get column URL -->
<#function getColumnUrl _tableGrid _cell>
	<#local parameters = "">
	<#if _tableGrid??>
		<#if sortOrder == "asc">
			<#local parameters = "st_name=${context.name}&st_sortBy=${_cell.name}&st_sortOrder=desc&st_page=${_tableGrid.pagination.currentPage.value}">
		<#else>
			<#local parameters = "st_name=${context.name}&st_sortBy=${_cell.name}&st_sortOrder=asc&st_page=${_tableGrid.pagination.currentPage.value}">
		</#if>
	</#if>
	<#return address + parameters>
</#function>

<#-- get column class -->
<#function getColumnClass _cell>
	<#local c = "">
	<#if sortOrder == "asc">
		<#if sortBy == _cell.name>
			<#local c = "sortCurrentAscend"/>
		</#if>	
	<#else>
		<#if sortBy == _cell.name>
			<#local c = "sortCurrentDescend"/>
		</#if>
	</#if>
	<#return c>
</#function>

<#-- get column's style -->
<#function getColumnStyle _cell>
	<#local s = "">
	<#if _cell.style??>
		<#local s = _cell.style/>
	</#if>
	<#return s>
</#function>

<#-- get th's class -->
<#function getThClass _cell>
	<#local c = "">
	<#if sortBy == _cell.name>
		<#local c = "highLight"/>
	</#if>	
	<#return c>
</#function>

<#-- get the tr's color -->
<#function getTrClass _rowIndex>
	<#local c = "bgcolorType2">
	<#if _rowIndex%2 == 0>
		<#local c = "bgcolorType1">
	</#if>
	<#return c>
</#function>

<#-- get td's class -->
<#function getTdClass _rowIndex _cell>
	<#local c = "">
	<#-- does the column be selected? -->
	<#if sortBy == _cell.name>
		<#if _rowIndex%2 == 0>
			<#local c = "columnHighLight1">
		<#else>
			<#local c = "columnHighLight2">
		</#if>
	</#if>
	
	<#-- set its align by cell.align -->
	<#local a = "tdCenterAlign">
	<#if _cell.align??>
		<#if _cell.align == 'left'>
			<#local a = "tdLeftAlign">
		<#else>
			<#local a = "tdRightAlign">
		</#if>
	</#if>
	
	<#if c != "">
		<#return c + " " + a>
	<#else>
		<#return a>
	</#if>
</#function>

<#-- get page URL -->
<#function getPageUrl _page>
	<#local parameters = "st_name=${context.name}&st_sortBy=${sortBy}&st_sortOrder=${sortOrder}&st_page=" + _page.value>
	<#return address + parameters>
</#function>

<#-- i18n, get text -->
<#function getText _label="">
	<#local text = "">
	<#if _label?? && context.resource??>
		<#local text = "${context.resource.getText(_label)!''}">
	</#if>
	<#return text>
</#function>

<#-- get sort by value -->
<#function getSortByValue _tableGrid>
	<#local sortByValue = "${sortBy}">
	<#if sortBy?? && _tableGrid.cells??>
		<#list _tableGrid.cells as cell>
			<#if cell.name == sortBy>
				<#local sortByValue = cell.label>
				<#break>
			</#if>
		</#list>
	</#if>
	<#return sortByValue>
</#function>