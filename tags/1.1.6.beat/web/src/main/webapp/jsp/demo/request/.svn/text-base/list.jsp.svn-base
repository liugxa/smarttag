<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="/smarttag/js/xmlextras.js" type="text/javascript"></script>
	<script src="/smarttag/js/ajax.js" type="text/javascript"></script>
	
	<link href="/smarttag/styles/list-table.css" rel="stylesheet" type="text/css"/>
	
</head>
	
<title>Smart Tag Example</title>

<body>
	<s:include value="../navigation.jsp"/>

	<div class="globalAction">
		<s:select name="gaction" headerKey="-1" headerValue="Global Actions"
	       	list="#{'---':'---' , 'action0':'action0' , 'action2':'action2'}" required="true" onchange="displayCheckedRecords();"/>
    </div>
    
	<pf:list action="/request/toList.action" resource="com.platform.gui.demo.request.application">	
		<pf:filter label="filter">
			<pf:section label="Find this host">
				<pf:element label="Request Name" name="name" type="input"/>
				<pf:button label="Find"/>
			</pf:section>
			
			<pf:section label="Filter hosts by" isDefault="true">
				<pf:element label="#{filter.request.state}" name="state" type="select" value="Any"/>
				<pf:element label="Request Date"  name="date" type="select" value="Any"/>
				<pf:element label="# of Machines" name="machines" type="input" value="Any"/>
				<pf:button label="Filter"/>
			</pf:section>
		</pf:filter>
	    
		<pf:table>
			<pf:column name="id" label="#{request.id}" decorate="checkbox"/>
			<pf:column name="date" label="Date" decorate="date" format="MM/dd/yyyy"/>
			<pf:column name="name" label="Request Name" decorate="link" url="/request/toRequest.action"/>
			<pf:column name="user" label="User"/>
			<pf:column name="status" label="Status"/>
			<pf:column name="machines" label="# of Machines"/>
			<pf:column name="memory" label="Memory Usage" decorate="percent"/>
			<pf:column name="desc" label="Description"/>
			<pf:action name="action" label="Actions">
				<pf:option label="Action" name="action"/>
				<pf:option label="----" name="----"/>
				<pf:option label="Start" name="start"/>
				<pf:option label="Stop" name="stop"/>
			</pf:action>
		</pf:table>
		
		<pf:preference label="Preferences"/>
	</pf:list>
	
	<script>
		function displayCheckedRecords(){
			doCheckedRecords("3,4,5,");
			alert("This records has been checked, ids - " + getCheckedRecords() + "!");
		}
	</script>
</body>
</html>