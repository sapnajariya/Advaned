<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<link href="extra.css" type="text/css" rel="stylesheet">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
<%String err=(String)request.getAttribute("err"); %>
<%if(err!=null){ %>
<%=err %>
<%} %>
<%String msg=(String)request.getAttribute("message"); %>
<%if(msg!=null){ %>
<%=msg %>
<%} %>
<%@include file="header.jsp" %>
<header></header>
<form action="LoginCtl" method="post">
<table>
				<tr>
					<th>Login Id</th>
					<td><input type="text" name="login" 
						placeholder="Enter Login ID"></td>
					
				</tr>
				<tr>
					<th>Password
					<td><input type="password" name="password"
						placeholder="Enter Password" ></td>
				
				</tr>
				
				<tr>
					<th></th>
					<td><input type="submit"
						value="Login"> 
				</tr>
				<a herf="forgetPass.jsp">ForgetPassword</a>
				</table>
				
				</form></center>
				
</body>
</html>