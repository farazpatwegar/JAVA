<%@page import="java.time.LocalDateTime"%>
<%@page import="com.app.core.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validate page</title>
</head>
<%----------creating a JSP declaration block to initialize a instance valiable to store the details send via form------%>
<%!

	public void jspInit()
	{
		HashMap<String,User> users=new HashMap<>();
		
		//populte data
		users.put("abcd@gmail.com",new User("abcd@gmail.com","abcd@12","abcd",25));
		users.put("abcd1@gmail.com",new User("abcd1@gmail.com","abcd1@12","abcd1",30));
		System.out.println("Map populated successfully");
	}
%>
<body>

<h5>Session ID: <%=LocalDateTime.now() %></h5>

</body>
</html>