<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ideas Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<style type="text/css">
		#wrapper{
			width: 900px;
			margin: 0 auto;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<h1>Welcome, <c:out value="${user.email}" /></h1>
		<a href="/logout">Logout</a>
		<h2>Ideas</h2>
		<table class="table">
  <thead>
    <tr>
      <th scope="col">Idea</th>
      <th scope="col">Created By:</th>
      <th scope="col">Likes</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${allIdeas}" var="idea">
    <tr>
      <td><a href="ideas/${idea.id}"><c:out value="${idea.content}"></c:out></a></td>
      <td>${idea.user}</td>
      <td>${idea.likes.size()}</td>
      <td><a href="/liked/${idea.id}">Like</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<a class="btn btn-dark" href="/ideas/new">Create an Idea</a>
	</div>
</body>
</html>