<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<s:url value="/styles/list-table.css"/>" rel="stylesheet" type="text/css"/>
</head>
	
<title>Smart Tag Example</title>

<body>
	<s:include value="navigation.jsp"/>

	<div class="globalAction">
		<s:select name="gaction" headerKey="-1" headerValue="Global Actions"
	       	list="#{'sep0':'---' , 'define':'Define New Request' , 'cancel':'Cancel Selected' , 'sep1':'---' , 'selectAll':'Select All' , 'unSelectAll':'Unselect All'}" required="true"/>
    </div>
    
    <pf:list action="/mock/toList.action?file=${file}">
		<pf:filter>
			<pf:section label="Find this Request">
				<pf:element type="input"  label="Request Name"/>
				<pf:button label="Find"/>
			</pf:section>
			
			<pf:section label="Filter Requests by" isDefault="true">
				<pf:element type="select" label="Request Status" value="Any"/>
				<pf:element type="select" label="Request Status1" value="Any"/>
				<pf:button label="Filter"/>
			</pf:section>
		</pf:filter>
		
		<pf:table list="list">
			<pf:column name="id" value="Request ID"/>
			<pf:column name="date" value="Request Date"/>
			<pf:column name="name" value="Request Name"/>
			<pf:column name="startDate" value="Start Date"/>
			<pf:column name="endDate" value="End Date"/>
			<pf:column name="recurring" value="Recurring"/>
			<pf:column name="status" value="Status"/>
			<pf:column name="cpus" value="CPUs Requested"/>
			<pf:column name="desc" value="Description"/>
			<pf:action>
				<pf:option label="Actions" name="actions"/>
				<pf:option label="----" name="----"/>
				<pf:option label="Start" name="start"/>
				<pf:option label="Stop" name="stop"/>
				<pf:option label="----" name="----"/>
				<pf:option label="Delete" name="delete"/>
			</pf:action>
		</pf:table>
	</pf:list>
</body>
</html>