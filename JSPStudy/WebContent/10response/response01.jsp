<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>response01</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setIntHeader("Refresh", 2);
	out.println("data is : "+ new java.util.Date().toString()+"<br/>");

%>
</body>
</html>