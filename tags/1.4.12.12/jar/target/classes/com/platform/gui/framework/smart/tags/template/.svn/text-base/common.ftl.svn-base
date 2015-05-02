<#function getSortBy _context>
	<#local r = "">
	<#if _context.parameters.st_sortBy??>
		<#-- Get sort from the context parameters -->
		<#local r = _context.parameters.st_sortBy>
	<#else>
		<#-- Get sort from the configure object -->
		<#if _context.configure?? && _context.configure.sortBy??>
			<#local r = _context.configure.sortBy>
		</#if>
	</#if>
	<#return r>
</#function>

<#function getSortOrder _context>
	<#local r = "desc">
	<#if _context.parameters.st_sortOrder??>
		<#-- Get sort from the context parameters -->
		<#local r = _context.parameters.st_sortOrder>
	<#else>
		<#-- Get sort from the configure object -->
		<#if _context.configure?? && _context.configure.sortOrder??>
			<#local r = _context.configure.sortOrder>
		</#if>
	</#if>
	<#return r>
</#function>

<#function getPage _context>
	<#local r = "0">
	<#if _context.parameters.st_page??>
		<#-- Get sort from the context parameters -->
		<#local r = _context.parameters.st_page>
	<#else>
		<#-- Get sort from the configure object -->
		<#if _context.configure?? && _context.configure.page??>
			<#local r = _context.configure.page>
		</#if>
	</#if>
	<#return r>
</#function>

<#function getUrl _context>
	<#if _context.action?index_of('?') != -1>
		<#local r = _context.contextPath + _context.action + "&">
	<#else>
		<#local r = _context.contextPath + _context.action + "?">
	</#if>
	<#return r>
</#function>

<#-- free marker functions -->
<#-- get current page value -->
<#--
<#function getPage _tableGrid>
	<#local r = 0>
	<#if _tableGrid??>
		<#local r = _tableGrid.pagination.currentPage.value>
	</#if>
	<#return r>
</#function>
-->

<#-- get column URL -->
<#function getColumnUrl _context _tableGrid _cell>
	<#local sortBy = getSortBy(_context)>
	<#local sortOrder = getSortOrder(_context)>
	
	<#local parameters = "">
	<#if _tableGrid??>
		<#if sortOrder == "asc">
			<#-- if it sort the current column , set the sort order to desc, Otherwise use the default value -->
			<#if sortBy == _cell.name>
				<#local parameters = "st_name=" + _context.name + "&st_sortBy=" + _cell.name + "&st_sortOrder=desc&st_page=" + _tableGrid.pagination.currentPage.value>
			<#else>
				<#local parameters = "st_name=" + _context.name + "&st_sortBy=" + _cell.name + "&st_sortOrder=asc&st_page=" + _tableGrid.pagination.currentPage.value>
			</#if>
		<#else>
			<#local parameters = "st_name=" + _context.name + "&st_sortBy=" + _cell.name + "&st_sortOrder=asc&st_page=" + _tableGrid.pagination.currentPage.value>
		</#if>
	</#if>
	<#return getUrl(_context) + parameters>
</#function>

<#-- get column class -->
<#function getColumnClass _context _cell>
	<#local sortBy = getSortBy(_context)>
	<#local sortOrder = getSortOrder(_context)>
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
<#function getThClass _context _cell>
	<#local sortBy = getSortBy(_context)>
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
<#function getTdClass _context _rowIndex _cell>
	<#local sortBy = getSortBy(_context)>
	<#local c = "">
	<#-- does the column be selected? -->tableGrid
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
<#function getPageUrl _context _page>
	<#local parameters = "st_name=" + _context.name + "&st_sortBy=" + getSortBy(_context) + "&st_sortOrder=" + getSortOrder(_context) + "&st_page=" + _page.value>
	<#return getUrl(_context) + parameters>
</#function>

<#-- i18n, get text -->
<#function getText _context _label="">
	<#local text = "">
	<#if _label??>
		<#if _context.resource??>
			<#local text = _context.resource.getText(_label)>
		<#else>
			<#local text = _label>
		</#if>
	</#if>
	<#return text>
</#function>

<#-- get sort by value -->
<#function getSortByValue _context _tableGrid>
	<#local sortBy = getSortBy(_context)>
	<#local sortByValue = "">
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