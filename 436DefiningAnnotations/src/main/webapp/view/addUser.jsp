<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<form:form modelAttribute="user" action="addUser">
		<tr><td>
			Name: <form:input path="name"/>
			<form:errors path="name" cssStyle="color:red"></form:errors>
		</td></tr>
		<tr><td>
			Email: <form:input path="email"/>
			<form:errors path="email" cssStyle="color:red"></form:errors>
		</td></tr>
		<tr><td>
			<input type="submit" value="Submit">		
		</td></tr>
	</form:form>
</table>
</body>
</html>