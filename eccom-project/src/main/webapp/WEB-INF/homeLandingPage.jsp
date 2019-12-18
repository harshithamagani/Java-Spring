<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!doctype html>
<html lang="zxx">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>winter</title>
    <link rel="icon" href="img/favicon.png">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- animate CSS -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/all.css">
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/themify-icons.css">
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css">
    <!-- swiper CSS -->
    <link rel="stylesheet" href="css/slick.css">
    <!-- style CSS -->
    <link rel="stylesheet" href="css/style.css">
    <style type="text/css">
    .lotus-logo{
    	width: 70%;
    	border-radius: 40px;
    }
    .cloth_img{
     width: 100%;
     }
    .banner_part{
    	height: 480px;
    }
    .banner_text{
    padding: 0px;
    }
    .footer_part{
    	margin-top: 20px;
    }
    .lotus_nav{
    	background-color: #343a40;
    }
    .banner_part{
    	background-color: #dddddf;
    }
    .footer_part{
    	background-color: #343a40;
    }
    .email_icon{
    	background-color:white;
    }
    .text_color{
    	color: white;
    }
    .main_menu .main-menu-item ul li .nav-link{
    	color: white;
    }
    .cart_icon{
      	width: 10%;
      }
      
      .btn{
      width:18%;
      }
    </style>
</head>

<body>
    <!--::header part start::-->
    <header class="main_menu home_menu">
        <div class="container-fluid">
            <div class="lotus_nav row align-items-center justify-content-center">
                <div class="col-lg-11">
                    <nav class="navbar navbar-expand-lg navbar-light">
                        <a class="navbar-brand" href="index.html"> <img class="lotus-logo" src="data:image/jpeg;base64,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" alt="logo"> </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="menu_icon"><i class="fas fa-bars"></i></span>
                        </button>

                        <div class="collapse navbar-collapse main-menu-item" id="navbarSupportedContent">
                            <ul class="navbar-nav">
                                <li class="nav-item">
                                    <a class="nav-link text_color" href="index.html">Home</a>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_1"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Shop
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_1">
                                        <a class="dropdown-item" href="category.html"> shop category</a>
                                        <a class="dropdown-item" href="single-product.html">product details</a>
                                        
                                    </div>
                                </li>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_3"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        pages
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
                                        <a class="dropdown-item" href="login.html"> 
                                            login
                                            
                                        </a>
                                        <a class="dropdown-item" href="tracking.html">tracking</a>
                                        <a class="dropdown-item" href="checkout.html">product checkout</a>
                                        <a class="dropdown-item" href="cart.html">shopping cart</a>
                                        <a class="dropdown-item" href="confirmation.html">confirmation</a>
                                        <a class="dropdown-item" href="elements.html">elements</a>
                                    </div>
                                </li>
                                
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="blog.html" id="navbarDropdown_2"
                                        role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        blog
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown_2">
                                        <a class="dropdown-item" href="blog.html"> blog</a>
                                        <a class="dropdown-item" href="single-blog.html">Single blog</a>
                                    </div>
                                </li>
                                
                                <li class="nav-item">
                                    <a class="nav-link" href="contact.html">Contact</a>
                                </li>
                            </ul>
                        </div>
                        <div class="hearer_icon d-flex">
                            <<!-- div class="dropdown cart">
                                <a class="dropdown-toggle" href="/lotus/cart" id="navbarDropdown3" role="button"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="ti-bag"></i>
                                </a>
                            </div> -->
                            <img class="cart_icon" alt="cart icon" src="/images/cart.png" onclick="location.href='/lotus/cart'">
                        </div>
                        <c:choose>
	  <c:when test="${userInSession}">
	      <a class="btn btn-outline-light" href="/logout">Logout</a>
	   </c:when>
	  <c:otherwise>
      	 <a class="btn btn-outline-light" href="/">Sign Up/Sign In</a>
      </c:otherwise>
  </c:choose>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- Header part end-->

    <!-- banner part start-->
    <section class="banner_part">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-7">
                    <div class="banner_slider">
                        <div class="single_banner_slider">
                            <div class="banner_text">
                                <div class="banner_text_iner">
                                    <h1 onclick="location.href='/lotus/products/'">Fashion Collection</h1>
                                    <a href="#" class="btn_1">shop now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- banner part start-->

    <!-- feature_part start-->
    <section class="feature_part pt-4">
        <div class="container-fluid p-lg-0 overflow-hidden">
            <div class="row align-items-center justify-content-between">
                <div class="col-lg-4 col-sm-6">
                    <div class="single_feature_post_text">
                        <img class="cloth_img" src="data:image/jpeg;base64,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" alt="#">
                        <div class="hover_text">
                            <a  href="/lotus/category/products/11" class="btn_2">shop for men</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="single_feature_post_text">
                        <img class="cloth_img" src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTVIYy5aIyQyQmmTkLKUD6qs0ECGhrV8jo9T63qtjG19uHPYKAm" alt="#">
                        <div class="hover_text">
                            <a  href="/lotus/category/products/12" class="btn_2">shop for women</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-sm-6">
                    <div class="single_feature_post_text">
                        <img class="cloth_img" src="data:image/jpeg;base64,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" alt="#">
                        <div class="hover_text">
                            <a href="/lotus/category/products/10" class="btn_2">shop for kids</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- upcoming_event part start-->


    <!--::footer_part start::-->
    <footer class="footer_part">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-sm-6 col-lg-2">
                    <div class="single_footer_part">
                        <h4>Category</h4>
                        <ul class="list-unstyled">
                            <li><a href="#">Male</a></li>
                            <li><a href="#">Female</a></li>
                            <li><a href="#">Shoes</a></li>
                            <li><a href="#">Fashion</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-2">
                    <div class="single_footer_part">
                        <h4>Company</h4>
                        <ul class="list-unstyled">
                            <li><a href="">About</a></li>
                            <li><a href="">News</a></li>
                            <li><a href="">FAQ</a></li>
                            <li><a href="">Contact</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-3">
                    <div class="single_footer_part">
                        <h4>Address</h4>
                        <ul class="list-unstyled">
                            <li><a href="#">200, Green block, NewYork</a></li>
                            <li><a href="#">+10 456 267 1678</a></li>
                            <li><span>contact89@winter.com</span></li>
                        </ul>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-4">
                    <!-- <div class="single_footer_part">
                        <h4>Newsletter</h4>
                        <div id="mc_embed_signup">
                            <form target="_blank"
                                action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                method="get" class="subscribe_form relative mail_part">
                                <input type="email" name="email" id="newsletter-form-email" placeholder="Email Address"
                                    class="placeholder hide-on-focus" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = ' Email Address '">
                                <button type="submit" name="submit" id="newsletter-submit"
                                    class="email_icon newsletter-submit button-contactForm">subscribe</button>
                                <div class="mt-10 info"></div>
                            </form>
                        </div>
                        <div class="social_icon">
                            <a href="#"><i class="ti-facebook"></i></a>
                            <a href="#"><i class="ti-twitter-alt"></i></a>
                            <a href="#"><i class="ti-instagram"></i></a>
                        </div>
                    </div> -->
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="col-lg-12">
                    <!-- <div class="copyright_text">
                        <P><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0.</P> -->
                    <!--</div> -->
                </div>
            </div>
        </div>
    </footer>
    <!--::footer_part end::-->

    <!-- jquery plugins here-->
    <script src="js/jquery-1.12.1.min.js"></script>
    <!-- popper js -->
    <script src="js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- easing js -->
    <script src="js/jquery.magnific-popup.js"></script>
    <!-- swiper js -->
    <script src="js/swiper.min.js"></script>
    <!-- swiper js -->
    <script src="js/mixitup.min.js"></script>
    <!-- particles js -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <!-- slick js -->
    <script src="js/slick.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>
    <!-- custom js -->
    <script src="js/custom.js"></script>
</body>

</html>