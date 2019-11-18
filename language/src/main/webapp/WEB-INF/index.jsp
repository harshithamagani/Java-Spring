<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Language Dashboard</title>
		<style>
			#wrapper{
				text-align: center;
			}
			.error{
				color:red;
			}
		</style>
	</head>
	<body>
		<div id="wrapper">
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">Name</th>
			      <th scope="col">Creator</th>
			      <th scope="col">Version</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${langs}" var="lang">
			    <tr>
			      <td><c:out value="${lang.name}"></c:out></td>
			      <td><c:out value="${lang.creator}"></c:out></td>
			      <td><c:out value="${lang.version}"></c:out></td>
			      <td><a href="/lanuages/delete/${lang.id}">Delete</a> | <a href="/languages/edit/${lang.id}">Edit</a></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			<form:form action="/languages/post" method="post" modelAttribute="lang">
				<p>
					<form:errors class="error" path="name"></form:errors><br>
					<form:label path="name">Name</form:label>
					<form:input path="name"/>
				</p>
				<p>
					<form:errors class="error" path="creator"></form:errors><br>
					<form:label path="creator">Creator</form:label>
					<form:input path="creator"/>
				</p>
				<p>
					<form:errors class="error" path="version"></form:errors><br>
					<form:label path="version">Version</form:label>
					<form:input path="version"/>
				</p>
				<input type="submit" value="Submit">
			</form:form>
		</div>
	</body>
</html>