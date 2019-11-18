<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Idea Form</title>
</head>
<body>
<div id="wrapper">
			<h1> Edit Idea </h1>
			<form:form method="post" action="/edit/idea/${idea.id}" modelAttribute="idea">
				<p>
					<form:errors path="content"></form:errors>
					<form:label path="content">Content:</form:label>
					<form:input path="content" type="text"/>
				</p>
				<input type="submit" value="Create">
			</form:form>
			<a href="/delete/idea/${idea.id}">Delete</a>
		</div>
</body>
</html>