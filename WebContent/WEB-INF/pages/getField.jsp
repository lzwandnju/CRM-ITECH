<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
tr,td,th{
padding:5px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fields</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Field Type</th>
			<tH>Quantity</tH>
			<th>Select</th>
		</tr>
		<c:forEach items="${fields}" var="i">
			<tr>
				<td><c:out value="${i.fieldname}"></c:out></td>
				<td><input type="text" name="quantity" /></td>
				<td><input type="checkbox" name="selected"
					value="${i.fieldname}+selected" />
			</tr>
		</c:forEach>
	</table>
</body>
</html>