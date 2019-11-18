<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Counter</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<div id="wrapper">
	<p>You have visited the <a href="/">http://localhost:8080/</a> <c:out value="${counter}"></c:out> times. </p>
	<a href="/">Test another visit?</a>
</div>
</body>
</html>