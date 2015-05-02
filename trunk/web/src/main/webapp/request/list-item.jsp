<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<pf:header/>
	<link href="./css/dropdown.css" rel="stylesheet" type="text/css"/>
</head>
	
<title>Smart Tag Example</title>

<body>
	<pf:list name="request" action="/request/toItemList.action" resource="com.platform.gui.demo.request.application" dataItem="${dataItem}">

		<pf:table>
			<pf:column key="id" name="ids" label="request.id" decorate="checkbox-all" parameters="['0' , '1']" style="width:100"/>
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