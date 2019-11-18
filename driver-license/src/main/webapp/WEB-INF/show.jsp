<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Profile Page</title>
	<style type="text/css">
		#wrapper{
			text-align:center;
		}
	</style>
</head>
	<body>
		<div id="wrapper">
			<h1><c:out value="${person.firstName}"></c:out> <c:out value="${person.lastName}"></c:out></h1>
		</div>
	</body>
</html>