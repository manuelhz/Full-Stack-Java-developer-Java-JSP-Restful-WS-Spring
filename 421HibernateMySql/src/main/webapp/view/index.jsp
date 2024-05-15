<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/files/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<h4>Home Page : List of users in the project</h4>
	<hr/>
	<table border="1" align="left">
		<tr>
			<th>User ID</th>
			<th>Name</th>
			<th>Email</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.userId }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>