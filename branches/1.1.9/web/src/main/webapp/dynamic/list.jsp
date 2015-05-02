<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<pf:header/>
</head>
	
<title>Smart Tag Example</title>

<body>
	<s:include value="navigation.jsp"/>

	<script>
		function changeType(_select){
			var type = _select.options[_select.selectedIndex];
			window.location.href = "../dynamic/toList.action?type=" + type.value; 
		}
	</script>
	
	<div class="globalAction">
		Browse the service offerings by type:		
		<s:select name="type"
	       	list="#{
	       	'0':'Application Running Environments (VM)' , 
	       	'1':'Packaged Computing Capacity (VM)' , 
	       	'2':'Raw Computing Capacity (VM)' , 
	       	'3':'Physical Machines'}" 
	       	required="true" onchange="changeType(this);"/>
    </div>
    
    <br>
    <pf:list name="dynamic_${type}" action="/dynamic/toList.action?type=${type}" 
    		dataRecords="${dataRecords}" dataColumn="${dataColumn}" dataColumnDecorate="${dataColumnDecorate}">
    	
    	<pf:filter label="filter">
			<pf:section name="section0" label="Find this host">
				<pf:item label="Request Name" name="name" decorate="input"/>
				<pf:button label="Find"/>
			</pf:section>
			
			<pf:section name="section1" label="Filter hosts by" isDefault="true">
				<pf:item label="filter.request.state" name="state" decorate="select" parameters="{'aa':'AA','bb':'BB'}" value="Any"/>
				<pf:item label="Request Date"  name="date" decorate="select" parameters="{'cc':'CC','ee':'EE'}" value="Any"/>
				<pf:item label="# of Machines" name="machines" decorate="input" value="Any"/>
				<pf:button label="Filter"/>
			</pf:section>
		</pf:filter>
				
	</pf:list>
	
	

</body>
</html>