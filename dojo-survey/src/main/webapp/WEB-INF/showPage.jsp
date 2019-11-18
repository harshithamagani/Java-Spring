<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		Name : <c:out value="${user.name} "></c:out><br>
		Dojo Location : <c:out value="${user.location}"></c:out><br>
		Favorite Language : <c:out value="${user.lang}"></c:out><br>
		Comment : <c:out value="${user.comment}"></c:out> <br>
	</div>
	<a href="/">Go Back</a>
</body>
</html>