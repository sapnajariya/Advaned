<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="extra.css" type="text/css" rel="stylesheet">
<style>

a{
color:white;}
</style>
</head>
<body>

<%String name=(String)session.getAttribute("user"); %>
<%if(name!=null) {%>
<%=name %>
<%} %>

<header><a href="Registration.jsp">Registration</a>||
<a href="Login.jsp">Login</a>
<% if(name!=null) {%>
<a href="userlist">UserList</a>


<a href="user">Logout</a>
<%} %>
<a href="student">Add student</a>



</header>
</body>
</html>