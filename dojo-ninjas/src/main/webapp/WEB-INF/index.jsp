<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Name</th>
	      <th scope="col">Ninja Count</th>
	    </tr>
	  </thead>
	  <tbody>
	  <c:forEach items="${dojos}" var="dojo">
	  	<tr>
	      <th scope="row">${dojo.id}</th>
	      <td>${dojo.name}</td>
	      <td>${fn:length(dojo.ninjas)} ninjas</td>
	    </tr>
	  </c:forEach>
	  </tbody>
	</table>
	</div>
</body>
</html>