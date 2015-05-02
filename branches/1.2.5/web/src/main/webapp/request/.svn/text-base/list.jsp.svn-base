<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<pf:header/>
</head>
	
<title>Smart Tag Example</title>

<body>
	<pf:list name="request" action="/request/toList.action" resource="com.platform.gui.demo.request.application" form="">

		<pf:filter label="filter">
			<pf:section name="section0" label="Find this host">
				<pf:item label="Request Name" name="name" decorate="input"/>
				<pf:button label="Find"/>
			</pf:section>
			
			<pf:section name="section1" label="Filter hosts by" isDefault="true">
				<pf:item label="filter.request.state" name="state" decorate="select" parameters="{'aa':'AA','bb':'BB'}" value="aa"/>
				<pf:item label="Request Date"  name="date" decorate="select" parameters="{'cc':'CC','ee':'EE'}" value="cc"/>
				<pf:item label="# of Machines" name="machines" decorate="input" value="Any"/>
				<pf:button label="Filter"/>
			</pf:section>
			
			<pf:section name="section2" label="The others" isDefault="true">				
				<pf:item label="Status"  name="status" decorate="radio" parameters="{'active':'Active','suspend':'Suspend'}" value=""/>
				<pf:item label="Users"  name="user" decorate="checkbox" parameters="{'user1':'user1','user2':'user2'}" value="user2"/>
				<pf:item label="Date"  name="date" decorate="time" parameters="%Y-%m-%d" value=""/>
				<pf:button label="Search"/>
			</pf:section>
			
		</pf:filter>
	    
		<pf:table>
			<pf:column key="id" name="ids" label="request.id" decorate="checkbox-all" parameters="['0' , '1']" style="width:100" title="title.request.id"/>
			<pf:column name="date" label="Date" decorate="date" parameters="MM/dd/yyyy"/>
			<pf:column name="name" label="Request Name" decorate="link" parameters="/request/toRequest.action" align="right"/>
			<pf:column name="user" label="User" disable="true"/>
			<pf:column name="status" label="Status"/>
			<pf:column name="machines" label="# of Machines" align="right"/>
			<pf:column name="memory" label="Memory Usage"/>
			<pf:column name="desc" label="Description" escape="true" decorate="summary" parameters="100"/>
			<pf:column name="action" label="Actions" decorate="select" parameters="{'action':'Action','----':'----','start':'Start','stop':'Stop'}"/>
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