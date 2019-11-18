<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Details Page</title>
</head>
<body>
	<div id="wrapper">
		<h1>${category.name}</h1>
		<p>Products</p>
		<c:forEach items="${category.products}" var="product">
			<p>${product.name}</p>
		</c:forEach>
		
		<form action="/add/product2/category" method="post">
			<select name = "product">
				<c:forEach items="${allproducts}" var="product">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select>
			<input name = "category" type="hidden" value="${category.id}"> 
			<input type="submit"  value="Create">
		</form>
	</div>
</body>
</html>