<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<style type="text/css">
#wrapper{
	text-align: center;
	margin-top: 10%;
}

.username {
	margin-left: 40px;
}

.password{
	margin-left: 43px;
}

.passwordCmf{
	margin-left: 24px;
}
.red{
	color:red;
}
</style>
</head>
<body>
	<div id="wrapper">
    <h1>Register</h1>
    
    <p><form:errors class="red" path="user.*"/></p>
    
    <form:form class="form" method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="username">Username:</form:label>
            <form:input class="username" path="username"/>
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password class="password" path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confrm:</form:label>
            <form:password class="passwordCmf" path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register"/>
    </form:form>
    </div>
</body>
</html>