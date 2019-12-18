<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>      

<!doctype html>
<html lang="en">
  <head>
    <title>Dashboard</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/starter-template/">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- Bootstrap core CSS -->


    <style>
    
		body {
		  padding-top: 5rem;
		}
		.starter-template {
		  padding: 3rem 1.5rem;
		  text-align: center;
		}
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
    </style>
    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
  </head>
  <body>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/new/product">Product<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/new/category">Category <span class="sr-only">(current)</span></a>
      </li>
    </ul>
    <div class="form-inline my-2 my-lg-0">
      <a href="/logout"><button>Logout</button></a>
    </div>
  </div>
</nav>

<main role="main" class="container">

  <div class="starter-template">
  <c:if test="${not empty categories}">
  <h1>Categories</h1>
<table class="table table-borderless">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach  items="${categories}"  var="category">
    <tr>
      <td><a href="/categories/${category.id}">${category.name}</a></td>
      <td><a href="/category/delete/${category.id} ">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</c:if>
<c:if test="${not empty products}">
<h1>Products</h1>
<table class="table table-borderless">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach  items="${products}"  var="product">
    <tr>
      <td><a href="/products/${product.id}">${product.name}</a></td>
      <td>${product.price}</td>
      <td><a href="/product/edit/${product.id}">Edit</a> | <a href="/product/delete/${product.id}">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</c:if>
  </div>

</main><!-- /.container -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script></body>
</html>
