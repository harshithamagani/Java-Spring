<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create New Person</title>
	<style type="text/css">
		#wrapper{
			text-align: center;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<h1>New Person</h1>
		<form:form method="post" action="/persons/post/new" modelAttribute="person">
			<p>
				<form:errors path="firstName"></form:errors>	
				<form:label path="firstName">First Name:</form:label>
				<form:input path="firstName"/>		
			</p>
			<p>
				<form:errors path="lastName"></form:errors>	
				<form:label path="lastName">Last Name:</form:label>
				<form:input path="lastName"/>		
			</p>
			<input type="submit" value="Create">
		</form:form>
	</div>
	
</body>
</html>