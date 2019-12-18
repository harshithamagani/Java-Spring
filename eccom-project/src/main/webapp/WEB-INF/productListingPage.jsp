<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Product Listing Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.3/examples/album/">

    <!-- Bootstrap core CSS -->
    <link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


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
      .prods{
      	margin-top: 20px;
      }
      .cart_icon{
      	width: 3%;
      	margin-right: 	15px; 
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="album.css" rel="stylesheet">
  </head>
  <body>
     <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/lotus">Lotus<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/lotus/products">Products<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
        <c:forEach items="${categories}" var="category">
          <a class="dropdown-item" href="/lotus/category/products/${category.id}">${category.name}</a>
          </c:forEach>
        </div>  
      </li>
    </ul>
    <img class="cart_icon" alt="cart icon" src="/images/cart.png" onclick="location.href='/lotus/cart'">
      <c:choose>
	  <c:when test="${userInSession}">
	      <a class="btn btn-outline-light" href="/logout">Logout</a>
	   </c:when>
	  <c:otherwise>
      	 <a class="btn btn-outline-light" href="/">Sign Up/Sign In</a>
      </c:otherwise>
  </c:choose>
  </div>
</nav>

<main role="main">

  <div class="album py-5 bg-light prods">
    <div class="container">

      <div class="row">
      <c:forEach items="${products}" var="product">
        <div class="col-md-4" onclick="location.href='/lotus/products/${product.id}'">
          <div class="card mb-4 shadow-sm">
          	<c:if test="${empty product.imageUrl}">
            	<img class="bd-placeholder-img card-img-top" height="280" src="https://makitweb.com/demo/broken_image/images/noimage.png" alt="Flowers in Chania" />
            </c:if>
            <c:if test="${not empty product.imageUrl}">
            	<img class="bd-placeholder-img card-img-top" height="280" src="${product.imageUrl}" alt="Flowers in Chania" />
            </c:if>
             <div class="card-body">
              <p class="card-text"><strong>${product.name}</strong></p>
              <p class="card-text"><strong>$${product.price}</strong></p>
            </div>
          </div>
        </div>
        </c:forEach>
      </div>
    </div>
  </div>

</main>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="/docs/4.3/assets/js/vendor/jquery-slim.min.js"><\/script>')</script><script src="/docs/4.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o" crossorigin="anonymous"></script>
	  <script type="text/javascript">
	      function GetContent(prm){
	    	    alert(prm);
	    	  }
	  </script>
      </body>
</html>
