<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index page</title>
</head>
<body>

<h1 align="center">Session id: <%=session.getId() %></h1>

	<h4>
		Welcome to JSP , Server time is:
		<%=LocalDateTime.now()%></h4>

	<h5>
		<a href="comments11.jsp">Test Comments</a>
	</h5>
	
	<h5>
	<a href="login00.jsp">Login</a>
	</h5>
	
	<h5>
	<a href="login11.jsp">Testing scriplets and EL syntax form</a>
	</h5>

</body>
</html>