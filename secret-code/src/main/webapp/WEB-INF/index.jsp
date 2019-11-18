<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Secret code</title>
</head>
	<body>
		<div id="wrapper">
		<c:out value="${error}"></c:out>
			<form action="/index" method="post">
					<input name="code" type="text">
					<input name="submit" value="Submit" type="submit">		
			</form>
		</div>
	</body>
</html>