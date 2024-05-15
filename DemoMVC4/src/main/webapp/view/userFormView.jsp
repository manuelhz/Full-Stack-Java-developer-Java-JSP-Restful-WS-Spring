<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body>
	<form:form action="displayUserInfo" modelAttribute="user">
		Name:<form:input path="name" />
		<p/>
		Gender: <form:radiobuttons path="gender" items="${genderMap }" />				
				<p/>
		Country: <form:select path="country" items="${countryMap}"/>
				<p/>				
		Introduction: <form:textarea path="introduction" />
				<p/>
				
		Visited countries:
				China: <form:checkbox path="visitedCountries" value="China"/>
				Taiwan: <form:checkbox path="visitedCountries" value="Taiwan"/>
				Germany: <form:checkbox path="visitedCountries" value="Germany"/>
				Bhutan: <form:checkbox path="visitedCountries" value="Bhutan"/>
				<p/>
		<input type="submit" value="submit">
	</form:form>
</body>
</html>