<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="/smarttag/styles/list-table.css" rel="stylesheet" type="text/css"/>
	
</head>
	
<title>Smart Tag Example</title>

<body>
	<s:include value="../navigation.jsp"/>

	<div class="globalAction">
		<s:select name="gaction" headerKey="-1" headerValue="Global Actions"
	       	list="#{'---':'---' , 'action0':'action0' , 'action2':'action2'}" required="true" onchange="displayCheckedRecords();"/>
    </div>
    
	<pf:list name="request" action="/request/toList.action" resource="com.platform.gui.demo.request.application">
		<pf:filter label="filter">
			<pf:section label="Find this host" name="find">
				<pf:input label="Request Name" name="name"/>
				<pf:button label="Find"/>
			</pf:section>
			
			<pf:section label="Filter hosts by" isDefault="true" name="filter">
				<pf:select label="#{filter.request.state}" name="state" value="any">
					<pf:option label="Any" name="any"/>
					<pf:option label="----" name="----"/>
					<pf:option label="Start" name="start"/>
					<pf:option label="Stop" name="stop"/>
				</pf:select>
				
				<pf:select label="Request Date"  name="date" value="start">
					<pf:option label="Any" name="any"/>
					<pf:option label="----" name="----"/>
					<pf:option label="Start" name="start"/>
					<pf:option label="Stop" name="stop"/>
				</pf:select>	
				
				<pf:select label="# of Machines" name="machines" value="stop">
					<pf:option label="Any" name="any"/>
					<pf:option label="----" name="----"/>
					<pf:option label="Start" name="start"/>
					<pf:option label="Stop" name="stop"/>
				</pf:select>
				<pf:button label="Filter"/>
			</pf:section>
		</pf:filter>
	    
		<pf:table>
			<pf:column name="id" label="request.id" decorate="checkbox" disable="true"/>
			<pf:column name="date" label="Date" decorate="date" parameters="MM/dd/yyyy"/>
			<pf:column name="name" label="Request Name" decorate="link" parameters="/request/toRequest.action"/>
			<pf:column name="user" label="User" disable="true"/>
			<pf:column name="status" label="Status" template="/status.ftl" templatePath="/WEB-INF/classes"/>
			<pf:column name="machines" label="# of Machines"/>
			<pf:column name="memory" label="Memory Usage"/>
			<pf:column name="desc" label="Description"/>
			<pf:action name="action" label="Actions" disable="true" value="----">
				<pf:option label="Action" name="action"/>
				<pf:option label="----" name="----"/>
				<pf:option label="Start" name="start"/>
				<pf:option label="Stop" name="stop"/>
			</pf:action>
		</pf:table>
		
		<pf:preference label="Preferences"/>
	</pf:list>
</body>
</html>