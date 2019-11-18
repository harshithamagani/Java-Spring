<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <style type="text/css">
    	#container{
    		width: 80%;
    		margin: 0 auto;
    	}
    	#login_section{
    		display: inline-block;
    		margin:100px;
    		vertical-align: top;
    	}
    	#register_section{
    		display: inline-block;
    		margin:100px;
    		margin-left: 145px;
    	}
    	#welcome{
    		text-align: center;
    	}
    </style>
</head>
<body>
<div id="container">
	<h1 id="welcome">Welcome</h1>
    <div id="register_section">
    	<h1>Register</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
        	<form:label path="firstName">First Name</form:label>
        	<form:input path="firstName"/>
        </p>
        	<form:label path="lastName">Last Name</form:label>
        	<form:input path="lastName"/>
        <p>
        </p>
        <p>
            <form:label path="email">Email</form:label>
            <form:input type="email" path="email"/>
        </p>
        <p>
        	<form:label path="location">Location</form:label>
        	<form:input path="location"/>
        	<form:select path="state">
        		<form:option value="CA">CA</form:option>
        		<form:option value="TX">TX</form:option>
        		<form:option value="MI">MI</form:option>
        		<form:option value="NY">NY</form:option>
        	</form:select>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>
    </div>
    <div id="login_section">
    	<h1>Login</h1>
	    <p><c:out value="${error}" /></p>
	    <form method="post" action="/login">
	        <p>
	            <label for="email">Email</label>
	            <input type="text" id="email" name="email"/>
	        </p>
	        <p>
	            <label for="password">Password</label>
	            <input type="password" id="password" name="password"/>
	        </p>
	        <input type="submit" value="Login!"/>
	    </form>    
    </div>
   </div> 
</body>
</html>