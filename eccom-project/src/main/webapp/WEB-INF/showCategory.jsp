<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	      .remove_link{
	      	margin-left: 15px;
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
        <a class="nav-link active" href="/new/category">Create Category</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="/new/product">Create Product</a>
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
		<h1>${category.name}</h1>
		<c:if test="${not empty category.products}">
		<h5>Products</h5>
		</c:if>
		<c:if test="${empty category.products}">
		<p>No products associated!!</p>
		</c:if>
		<c:forEach items="${category.products}" var="product">
			<p><a href="/products/${product.id}">${product.name}</a> <a class="remove_link" href="/remove/product/${category.id}/${product.id}">Remove</a></p>
		</c:forEach>
		<c:if test="${not empty allproducts}">
		<form action="/add/product2/category" method="post">
		<label path="name">Add Product:</label>
			<select name = "product">
				<c:forEach items="${allproducts}" var="product">
					<option value="${product.id}">${product.name}</option>
				</c:forEach>
			</select>
			<input name = "category" type="hidden" value="${category.id}"> 
			<input type="submit"  value="Add">
		</form>
		</c:if>
	    <a href="/category/delete/${category.id}">Delete Category</a>
	</div>
<!------------basic template bottom------------->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>