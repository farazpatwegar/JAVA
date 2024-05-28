<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="err_handler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test page</title>
</head>
<body>

<%
/* int result=100/12; */
int result=100/0;
pageContext.setAttribute("nm", result);//result:
%>
<%--diplay the value of page scoped attribute (result)--%>
<h5>Result: ${nm}</h5>
</body>
</html>