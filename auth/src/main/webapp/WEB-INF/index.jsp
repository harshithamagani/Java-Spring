<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Admin Console</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/cover/">

    <!-- Bootstrap core CSS -->
	<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }
/* 
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      } */
      
      a,h1,h3{
        color: white;
      }
      
      .btn-secondary{
      	color: #092541;
    	background-color:#fff;
    	border-color: #fff;
      }
      
      .center{
      	margin-top: 10%;
      }
      
      body {
 	  	background-image: url("https://static5.redcart.pl/templates/images/thumb/7011/1500/1500/pl/0/templates/images/products/7011/f3dd8a94890c285b67b787c84c1e5581.jpg");
   	  }
   	  
    </style>
    <!-- Custom styles for this template -->
    <link href="cover.css" rel="stylesheet">
  </head>
  <body class="text-center">
    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column center">
  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Welcome</h3>
      <nav class="nav nav-masthead justify-content-center">
        <a class="nav-link active" href="#">Home</a>
        <a class="nav-link" href="#">Features</a>
        <a class="nav-link" href="#">Contact</a>
      </nav>
    </div>
  </header>

  <main role="main" class="inner cover">
    <h1 class="cover-heading">Admin Dashboard</h1>
    <p class="lead"></p>
    <p class="lead">
      <a href="/login" class="btn btn-lg btn-secondary">Login</a>
      <a href="/registration" class="btn btn-lg btn-secondary">Register</a>
    </p>
  </main>
</div>
</body>