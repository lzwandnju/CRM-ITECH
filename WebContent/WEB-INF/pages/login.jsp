

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<c:url var="loginUrl" value="/home/login"/>
	<form:form method="POST" action="${loginUrl}" modelAttribute="user">
		<table>
		<tr>
		<td><form:label path="username">UserName</form:label></td>
		<td><form:input path="username"/></td>
		</tr>
		
		<tr>
		<td><form:label path="password">Password</form:label></td>
		<td><form:password path="password"/></td>
		</tr>
		</table>
		<input type="submit" value="Login"/> 
	</form:form>

</body>
</html>