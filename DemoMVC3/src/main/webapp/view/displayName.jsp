<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Name view</title>
</head>
<body>
Today is ${date } <br/>
Hello ${ name } <br/>
---------

<c:forEach var="temp" items = "${team}">
${temp}
</c:forEach>

</body>
</html>