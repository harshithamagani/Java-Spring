<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Events</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style type="text/css">
    	#container{
    		width: 80%;
    		margin: 0 auto;
    	}
    	#logout{
    		margin-left: 900px;
    	}
</style>
</head>
<body>
<div id="container">
	<div id="wrapper1">
	 	<h1>Welcome, ${user.firstName}</h1>
	 	<a id="logout" href="/logout">Logout</a>
	 	<p>Here are some of the events in your state:</p>
	 	<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action/Status</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${userLocationEvnets}" var="event">
		<tr>
	        <td>${event.name }</td>
	        <td>${event.date }</td>
	        <td>${event.location }</td>
	        <td>${event.host.firstName}</td>
	        <td>@mdo</td>
	    </tr>
       </c:forEach>
  </tbody>
</table>
	</div>
		<div id="wrapper2">
	 	<p>Here are some of the events in other state:</p>
	 	<table class="table">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action/Status</th>
    </tr>
  </thead>
  <tbody>
		<c:forEach items="${notUserLocationEvnets}" var="event">
		<tr>
	        <td>${event.name }</td>
	        <td>${event.date }</td>
	        <td>${event.location }</td>
	        <td>${event.host.firstName}</td>
	        <td>@mdo</td>
	    </tr>
       </c:forEach>
  </tbody>
</table>
</div>
	<div id="wrapper3">
	 	<h1>Create An Event</h1>
	 	<form:form method="post"  action="/post/event" modelAttribute="event">
	 		<p>
	 			<form:errors path="name"></form:errors>
	 			<form:label path="name">Name:</form:label>
	 			<form:input path="name"/>
	 		</p>
	 		<p>
	 			<form:errors path="date"></form:errors>
	 			<form:label path="date">Date:</form:label>
	 			<form:input type="date" path="date"/>
	 		</p>
	 		<p>
	 			<form:errors path="location"></form:errors>
	 			<form:label path="location">Location:</form:label>
	 			<form:input path="location"/>
	 			<form:select path="state">
		 			<form:option value="CA">CA</form:option>
	        		<form:option value="TX">TX</form:option>
	        		<form:option value="MI">MI</form:option>
	        		<form:option value="NY">NY</form:option>
	 			</form:select>
	 		</p>
	 		<input type="submit" value="Submit">
	 	</form:form>
	</div>
</div>
</body>
</html>