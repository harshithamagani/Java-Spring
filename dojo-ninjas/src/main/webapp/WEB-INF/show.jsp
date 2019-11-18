<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Details</title>
</head>
<body>
	<div id="wrapper">
		<h1>${dojo.name}</h1>
		<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">First Name</th>
	      <th scope="col">Last Name</th>
	      <th scope="col">Age</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${ninjas}" var="ninja">
	  	<tr>
	      <th scope="row">${ninja.id}</th>
	      <td>${ninja.firstName}</td>
	      <td>${ninja.lastName}</td>
	      <td>${ninja.age}</td>
	    </tr>
	  </c:forEach>
	  </tbody>
	</table>
	</div>
</body>
</html>