<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Authenticate</title>
</head>
<body>
<form action="dev.do" method="POST">
	<label for="pass">Password:</label>
	<input type="password" id="pass" name="password"/>
	<input type="submit" value="Log In"/>
</form>
<c:if test="${not empty message }">
	<c:out value="${message }"/>
</c:if>
</body>
</html>