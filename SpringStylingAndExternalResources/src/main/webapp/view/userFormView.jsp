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
<title>User Form</title>
</head>
<body>
	<h4>Submit your information</h4>
	<hr/>
	<div class="container">
	<form:form action="displayUserInfo" modelAttribute="user">
	
		Name:<form:input path="name" required="true" placeholder="Enter name"/>
		<p/>
		Gender: <form:radiobuttons path="gender" required="true" items="${genderMap }" />				
				<p/>
		Country: <form:select path="country" required="true" items="${countryMap}"/>
				<p/>				
		Introduction: <form:textarea path="introduction" />
				<p/>				
				
		Visited countries:
				China: <form:checkbox path="visitedCountries" value="China"/>
				Taiwan: <form:checkbox path="visitedCountries" value="Taiwan"/>
				Germany: <form:checkbox path="visitedCountries" value="Germany"/>
				Bhutan: <form:checkbox path="visitedCountries" value="Bhutan"/>
				<p/>
				Accept agreement: <form:checkbox path="" value="accept" required="true"/>
				<p/>
		<input type="submit" value="submit">
	</form:form>
	</div>
</body>
</html>