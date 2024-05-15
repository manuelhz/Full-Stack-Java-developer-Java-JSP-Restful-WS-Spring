<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/files/css/style.css">
<title>User info:</title>
</head>
<body>
<div class="container">
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
</div>

</body>
</html>