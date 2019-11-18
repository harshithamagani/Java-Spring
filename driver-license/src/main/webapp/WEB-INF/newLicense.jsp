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
			<h1> New License </h1>
			<form:form method="post" action="/license/new/post" modelAttribute="license">
				<p>
					<form:errors path="person"></form:errors>
					<form:label path="person">Person:</form:label>
					<form:select path="person">
							<c:forEach items="${persons}" var="person">
								<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
							</c:forEach>
					</form:select>
				</p>
				<p>
					<form:errors path="state"></form:errors>
					<form:label path="state">State:</form:label>
					<form:input type="text" path="state"/>
				</p>
				<p>
					<form:errors path="expDate"></form:errors>
					<form:label path="expDate">Expiration Date:</form:label>
					<form:input type="date" path="expDate"/>
				</p>
				<input type="submit" value="Create">
			</form:form>
		</div>
</body>
</html>