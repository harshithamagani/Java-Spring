<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Create New Product</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/navbar-fixed/">

    <!-- Bootstrap core CSS -->
	<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<style>
	      .bd-placeholder-img {
	        font-size: 1.125rem;
	        text-anchor: middle;
	        -webkit-user-select: none;
	        -moz-user-select: none;
	        -ms-user-select: none;
	        user-select: none;
	      }
	
	      @media (min-width: 768px) {
	        .bd-placeholder-img-lg {
	          font-size: 3.5rem;
	        }
	      }
	      #wrapper{
	          display: inline-block;
    	      margin-top: 10%;
    		  margin-left: 36%;
	      }
    </style>
    <!-- Custom styles for this template -->
    <link href="navbar-top-fixed.css" rel="stylesheet">
  </head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <!-- <a class="navbar-brand" href="#">Navbar</a> -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/new/category">Create Category</a>
      </li>
    </ul>
    <div class="form-inline my-2 my-lg-0">
      <a href="/logout"><button>Logout</button></a>
    </div>
  </div>
</nav>
<main role="main" class="container">

  <div class="starter-template">
    <h1>Bootstrap starter template</h1>
  </div>

</main><!-- /.container -->
<!------------basic template top------------->
	<div id="wrapper"> 
	<h1>Create New Product</h1>
		<form:form method="post" action="/post/new/product" modelAttribute="product">
			<p>
				<form:errors path="name"></form:errors>
				<form:label path="name">Name:</form:label>
				<form:input path="name"/>
			</p>
			<p>
				<form:label path="imageUrl">Image:</form:label>
				<form:input path="imageUrl"/>
			</p>
			<p>
				<form:errors path="description"></form:errors>
				<form:label path="description">Description:</form:label>
				<form:input path="description"/>
			</p>
			<p>
				<form:errors path="price"></form:errors>
				<form:label path="price">Price:</form:label>
				<form:input path="price"/>
			</p>
			<input type="submit" value="Create">
		</form:form>
	</div>
	<!------------basic template bottom------------->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>