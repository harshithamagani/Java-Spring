<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<div id="wrapper">
		<h1>New Dojo</h1>
		<form:form method="post" action="/post/new/dojo" modelAttribute="dojo">
			<p>
				<form:errors path="name"></form:errors>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
			</p>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>