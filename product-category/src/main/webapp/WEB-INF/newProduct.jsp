<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Product Form</title>
	<style type="text/css">
		#wrapper{
			text-align:center;
		}
	</style>
</head>
<body>
	<div id="wrapper"> 
	<h1>Create new Product</h1>
		<form:form method="post" action="/post/new/product" modelAttribute="product">
			<p>
				<form:errors path="name"></form:errors>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
			</p>
			<p>
				<form:errors path="description"></form:errors>
				<form:label path="description">Description:</form:label>
				<form:input path="description"/>
			</p>
			<p>
				<form:errors path="price"></form:errors>
				<form:label path="price">Price:</form:label>
				<form:input path="price"/>
			</p>
			<input type="submit" value="Create">
		</form:form>
	</div>
</body>
</html>