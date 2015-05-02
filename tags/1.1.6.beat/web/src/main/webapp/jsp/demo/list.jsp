<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags/demo" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="<s:url value="/styles/list-table.css"/>" rel="stylesheet" type="text/css"/>
	</head>
	<title>Smart Tag Example</title>
	
	<body>
		<s:include value="navigation.jsp"/>
		<s:include value="filter.jsp"/>
		
		<s:include value="globalAction.jsp"/>
	 	<s:include value="filterResult.jsp"/>
	 	    		
		<s:form action="" method="POST">
			<pf:table action="/toList.action"/>
		</s:form>
	</body>
</html>