<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="<s:url value="/css/list-table.css"/>" rel="stylesheet" type="text/css"/>
</head>
	
<title>Smart Tag Example</title>

<body>
	<s:include value="navigation.jsp"/>

	<script>
		function changeType(_select){
			var type = _select.options[_select.selectedIndex];
			window.location.href = "/smarttag/dynamic/toList.action?type=" + type.value; 
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
		<pf:table/>
	</pf:list>
	
	

</body>
</html>