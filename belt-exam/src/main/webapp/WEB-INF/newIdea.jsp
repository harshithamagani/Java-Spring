<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		#wrapper{
			text-align:center;
		}
	</style>
</head>
<body>
	<div id="wrapper">
			<h1> New Idea </h1>
			<form:form method="post" action="/post/idea" modelAttribute="idea">
				<p>
					<form:errors path="content"></form:errors>
					<form:label path="content">Content:</form:label>
					<form:input path="content" type="text"/>
				</p>
				<input type="submit" value="Create">
			</form:form>
		</div>
</body>
</html>