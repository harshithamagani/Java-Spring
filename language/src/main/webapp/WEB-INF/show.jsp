<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Details Page</title>
	<style type="text/css">
		#wrapper{
		 	text-align: center;
		}
	</style>
</head>
<body>
	<div id="wrapper">
	<a href="/languages">Dashboard</a>
		<p><c:out value="${lang.name}"></c:out></p>
		<p><c:out value="${lang.creator}"></c:out></p>
		<p><c:out value="${lang.version}"></c:out></p>
		<p><a href="#">Edit</a></p>
		<a href="#">Delete</a>
	</div>
</body>
</html>