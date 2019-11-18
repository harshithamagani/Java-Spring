<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form method="post" action="/post/new/ninja" modelAttribute="ninja">
		<p>
			<form:errors path="dojo"></form:errors>
			<form:label path="dojo">Dojo:</form:label>
			<form:select path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:errors path="firstName"></form:errors>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName"/>
		</p>
		<p>
			<form:errors path="lastName"></form:errors>
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName"/>
		</p>
		<p>
			<form:errors path="age"></form:errors>
			<form:label path="age">Age:</form:label>
			<form:input path="age"/>
		</p>
		<input type="submit" value="Create">
	</form:form>
</body>
</html>