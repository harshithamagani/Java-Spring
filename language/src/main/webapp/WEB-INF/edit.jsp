<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Form</title>
	<style type="text/css">
		#wrapper{
			text-align: center;
		}
	</style>
</head>
<body>
<div id="wrapper">
	<a href="#">Dashboard</a>
		<form:form action="/languages/edit/post" method="post" modelAttribute="lang">
			<p>
				<form:errors path="name"></form:errors><br>
				<form:label path="name">Name</form:label>
				<form:input path="name"/>
			</p>
			<p>
				<form:errors path="creator"></form:errors><br>
				<form:label path="creator">Creator</form:label>
				<form:input path="creator"/>
			</p>
			<p>
				<form:errors path="version"></form:errors><br>
				<form:label path="version">Version</form:label>
				<form:input path="version"/>
			</p>
			<input type="submit"  value="Submit">
		</form:form>
</div>
</body>
</html>