<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Details</title>
<style type="text/css">
#wrapper{
text-align: center;
}
</style>
</head>
<body>
	<div id="wrapper">
		<h1>${idea.content}</h1>
		<p>Created by:	${idea.user.name}</p>
		<h3>Users who liked your idea:</h3>
		<h3>Name:</h3>
		<c:if test="${idea.likes.size() != 0}">
			<c:forEach items="${idea.likes}" var="like">
				<p>${like.user.name}</p>
			</c:forEach>
		</c:if>
		<a href="/ideas/${idea.id}/edit">Edit</a>
	</div>
</body>
</html>