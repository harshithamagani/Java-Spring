<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Category</title>
<style type="text/css">
#wrapper{
text-align:center;
}
</style>
</head>
<body>
	<div id="wrapper">
	<h1>Create New Category</h1>
		<form:form method="post" action="/post/new/category" modelAttribute="category">
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