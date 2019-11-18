<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Book Form</title>
<style type="text/css">
 .error{
 	color:red;
 }
</style>
</head>
<body>
	<h1>New Book</h1>
	<form:form action="/books/create" method="post" modelAttribute="book">
		<p>
			<form:label path="title">Title</form:label><br>
			<form:errors class="error" path="title"></form:errors><br>
			<form:input path="title"/>
		</p>
		<p>
			<form:label path="description">Description</form:label><br>
			<form:errors class="error" path="description"></form:errors><br>
			<form:input path="description"/>
		</p>
		<p>
			<form:label path="language">Language</form:label><br>
			<form:errors class="error" path="language"></form:errors><br>
			<form:input path="language"/>
		</p>
		<p>
			<form:label path="numberOfPages">NumberOfPages</form:label><br>
			<form:errors class="error" path="numberOfPages"></form:errors><br>
			<form:input path="numberOfPages"/>
		</p>
		<input type="submit" value="Submit">	
	</form:form>
</body>
</html>