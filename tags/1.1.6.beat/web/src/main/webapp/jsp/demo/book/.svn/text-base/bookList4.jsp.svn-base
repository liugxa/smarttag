<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pf" uri="http://www.platform.com/tags" %>
<html>
<head>
	<title>File Upload Example</title>
	<link href="<s:url value="/styles/list-table.css"/>" rel="stylesheet" type="text/css"/>
</head>

<body>
<s:form action="" method="POST">
	<pf:table list="books" action="/toList4.action">
		<pf:column name="id" value="ID"/>
		<pf:column name="name" value="Name"/>
		<pf:column name="author" value="Author" url="/toAuthor.action"/>
		<pf:column name="publisher" value="Publisher"/>
		<pf:column name="price" value="Price($)"/>
		<pf:action>
			<pf:option name="Action" value="Action"/>
			<pf:option name="Remove" value="Remove"/>
			<pf:option name="------" value="------"/>
			<pf:option name="Clone"  value="Clone"/>
		</pf:action>
	</pf:table>
</s:form>
</body>
</html>