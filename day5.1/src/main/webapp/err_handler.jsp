<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error handling page</title>
</head>
<body>
<h5 style="color:red;">Error message:<%=exception %></h5>

<h3 align="center">Via EL syntax</h3>
<h5 style="color:red;">Error details: ${pageContext.exception}</h5>
<h3 align="center">Via EL syntax printing only message and not fully qualified name</h3>
<h5 style="color:red;">Error details: ${pageContext.exception.message}</h5>
</body>
</html>