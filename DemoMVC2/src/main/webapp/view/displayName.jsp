<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Name view</title>
</head>
<body>
Hello <%= request.getAttribute("firstName") %>
</body>
</html>