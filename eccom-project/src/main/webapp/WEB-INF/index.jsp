<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style type="text/css">
    	#container{
    		width: 80%;
    		margin: 0 auto;
    	}
    	#login_section{
    		display: inline-block;
    		width:50%;
    		vertical-align: center;
    	}
    	#register_section{
    		display: inline-block;
    		width:49%;
    		padding: 2%;
    	}
    	.error{
    		color: red;
    	}
    	.input-size{
    		width: 45%;
    	}
    	.lotus-logo{
    		display: block;
    		margin: 0 auto;
    		border-radius: 100%;
    	}
    </style>
</head>
<body>
<div id="container">
<img class = "lotus-logo" alt="lotus" src="/images/lotus.jpeg">
    <div id="register_section">
    	<h2>Register</h2>
    
    <p class="error"><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <div class="form-group row">
        	<form:label class="col-sm-2 col-form-label" path="firstName">First Name</form:label>
        	<div class="col-sm-10">
        		<form:input class="form-control input-size" path="firstName"/>
        	</div>
        </div>
        <div class="form-group row">
        	<form:label class="col-sm-2 col-form-label" path="lastName">Last Name</form:label>
        	<div class="col-sm-10">
        		<form:input class="form-control input-size" path="lastName"/>
        	</div>
        </div>
         <div class="form-group row">
            <form:label class="col-sm-2 col-form-label"  path="email">Email</form:label>
            <div class="col-sm-10">
            	<form:input class="form-control input-size" type="email" path="email"/>
            </div>
        </div>
        <div class="form-group row">
            <form:label class="col-sm-2 col-form-label" path="password">Password:</form:label>
            <div class="col-sm-10">
            <form:password class="form-control input-size" path="password"/>
            </div>
        </div>
        <div class="form-group row">
            <form:label class="col-sm-2 col-form-label" path="passwordConfirmation">Password Confirmation:</form:label>
            <div class="col-sm-10">
            	<form:password class="form-control input-size" path="passwordConfirmation"/>
            </div>
        </div>
        <input class="btn btn-primary" type="submit" value="Register"/>
    </form:form>
    </div>
    <div id="login_section">
    	<h2>Login</h2>
	    <p class="error"><c:out value="${error}" /></p>
	    <form method="post" action="/login">
	        <div class="form-group row">
	            <label class="col-sm-2 col-form-label"  for="email">Email</label>
	            <div class="col-sm-10">
	            	<input class="form-control input-size" type="text" id="email" name="email"/>
	            </div>
	        </div>
	        <div class="form-group row">
	            <label class="col-sm-2 col-form-label"  for="password">Password</label>
	            <div class="col-sm-10">
	            	<input class="form-control input-size" type="password" id="password" name="password"/>
	            </div>
	        </div>
	        <input class="btn btn-primary" type="submit" value="Login"/>
	    </form>    
    </div>
   </div> 
</body>
</html>