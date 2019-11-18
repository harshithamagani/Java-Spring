<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Time</title>
</head>
<body>
	<div id="wrapper">
		<h1>Display Time</h1>
		<h2><c:out value="${time}"></c:out></h2>
	</div>
</body>
</html>