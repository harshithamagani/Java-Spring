<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<style type="text/css">
		#wrapper{
			text-align:center;
		}
	</style>
</head>
<body>
	<div id="wrapper">
		<h1>Information</h1>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">License No</th>
      <th scope="col">State</th>
      <th scope="col">Exp Date</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${licenses}" var="license">
  	<tr>
      <th scope="row">${license.id}</th>
      <td>${license.person.firstName}</td>
      <td>${license.person.lastName}</td>
      <td>${license.number}</td>
      <td>${license.state}</td>
      <td>${license.expDate}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
	</div>
</body>
</html>