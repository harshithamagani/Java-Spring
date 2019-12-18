<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
	#wrapper{
		text-align: center;
		margin-top: 10%;
		margin-left: 43%;
		display: inline-block;
		padding: 20px;
		border-radius: 10px;
	}
</style>
</head>
<body>
	<div id="wrapper">
	    <c:if test="${logoutMessage != null}">
	        <c:out value="${logoutMessage}"></c:out>
	    </c:if>
	    <h1>Login</h1>
	    <c:if test="${errorMessage != null}">
	        <c:out value="${errorMessage}"></c:out>
	    </c:if>
	    <form class="form" method="POST" action="/login">
	        <p>
	            <label for="username">Username:</label>
	            <input type="text" id="username" name="username"/>
	        </p>
	        <p>
	            <label for="password">Password:</label>
	            <input type="password" id="password" name="password"/>
	        </p>
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <input type="submit" value="Login"/>
	    </form>
	</div>
</body>
</html>