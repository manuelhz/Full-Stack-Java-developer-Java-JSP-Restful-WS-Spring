<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User info:</title>
</head>
<body>
<h1>User info:</h1>
Name: ${user.name}<p/>
Gender: ${user.gender}<p/>
Country: ${user.country}<p/>
Introduction: ${user.introduction}</p>
Visited countries:
<ul>
	<c:forEach items="${user.visitedCountries }" var="item">
		<li>${item}</li>
	</c:forEach>
</ul>


</body>
</html>