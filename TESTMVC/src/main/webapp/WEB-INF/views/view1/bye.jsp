<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>THANK YOU</h1>
<table border="1">
<tr>
<td>User id</td>
<td>name</td>
<td>salary</td>
</tr>
<c:forEach  items="${employees}" var="employee">  
<tr>
<td>${employee.id}</td>
<td>${employee.name}</td>
<td>${employee.salary}</td>
</tr>
</c:forEach>
</table>
<a href="lastone">LAST CLICK</a> 
</body>
</html>