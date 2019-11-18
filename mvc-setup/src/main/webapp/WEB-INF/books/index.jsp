<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books Page</title>
</head>
<body>
<h1>All Books</h1>

</body>
	<table>
		<thead>
	        <tr>
	            <th>Title</th>
	            <th>Description</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
		    <c:forEach items="${books}" var="book">
		    	<tr>
		    		<td><c:out value="${book.title}"></c:out></td>
		    		<td><c:out value="${book.description}"></c:out></td>
		    		<td><c:out value="${book.language}"></c:out></td>
		    		<td><c:out value="${book.numberOfPages}"></c:out></td>
		    	</tr>
		    </c:forEach>
	    </tbody>
	</table>
    <a href="/books/new">New Book</a>
</html>