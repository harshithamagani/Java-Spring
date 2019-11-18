<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product Details</title>
</head>
<body>
	<div id="wrapper">
		<h1>${product.name}</h1>
		<p>Categories:</p>
			<c:forEach items="${product.categories}" var="category">
				<p>${category.name}</p>
			</c:forEach>
			
		<form method="post" action="/add/category2/product">
			<p>
				<label path="name">Add Category:</label>
				<select name="category">
					<c:forEach items="${categories}" var="category">
						<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
			</p>
			<input name="product" type="hidden" value="${product.id}">
			<input type="submit" value="Add">
		</form>
	</div>
</body>
</html>