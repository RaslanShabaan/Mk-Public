<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<!--
	Usable by gettemplates.co
	Twitter: http://twitter.com/gettemplateco
	URL: http://gettemplates.co
-->
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Website Template</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by gettemplates.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="gettemplates.co" />

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<link href="https://fonts.googleapis.com/css?family=Droid+Sans" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Themify Icons-->
	<link rel="stylesheet" href="css/themify-icons.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="gtco-loader"></div>
	
	<div id="page">
	<nav class="gtco-nav" role="navigation" style="height:70px">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-4 col-md-4">
					<div id="gtco-logo">Welcome User ::<span style="font-weight:bold;color:#000;font-style:italic"><b><c:out value="${pageContext.request.remoteUser}"/></b></span></div>
				</div>
				<div class="col-md-4 text-right menu-1 main-nav">
					<ul >
					
						<li class="active"> 
							  <form action="/Logout" method="get">
						<button class="btn" style="background-color:#fff;margin-left:700px;border-color:red;color:red"> Log Me Out </button>
						</form>
						</li>
						
						<li class="active"> 
					<form action="/GoUserSett" method="get">
						<button class="btn" style="margin-top:-73px;background-color:#fff;margin-left:500px;border-color:green;color:green"> Account Settings </button>
						</form>
						</li>
						
					
                        <li class="active"> 
					<form action="/back" method="get">
						<button class="btn" style="margin-top:-130px;background-color:#fff;margin-left:300px;border-color:gray;color:#000"> Back To Home </button>
						</form>
						</li>
						                                   
					</ul>
				</div>
			</div>
			
		</div>
	</nav>

	<div class="gtco-section" id="gtco-faq" data-section="faq">
		<div class="gtco-container">
			<div class="row" >
				<div class="col-md-8 col-md-offset-2 text-center gtco-heading">
					<h2> Update Data </h2>
					<p> You Can Reset Your User Name Or Pass-Word :) </p>
				</div>
				
				
				
			</div>
					</div>
				
				<div style="border:1px solid #000;width:40%;margin-left:30%;height:200px">
                    <form action="/UserSett" method="post">
					<input placeholder="Change User Name"  name="un" style="margin-top:4%;width:40%;margin-left:30%"/>
					<br></br>
					<input placeholder="Change User Pass-Word"  name="up" style="width:40%;margin-left:30%"/>
					<br><br>
					 <input type="hidden"  name="${_csrf.parameterName}"	value="${_csrf.token}"/>
				<button class="btn" style="border-color:green;color:#000;width:40%;margin-left:30%"> Reset Data </button>
				</form>
				</div>
				
				
				</div>
			</div>
		</div>
	</div>


	
					</div>
				</div>
					
			</div>
		</div>
	</div>

	

	<footer id="gtco-footer" role="contentinfo" style="height:200px">
		<div class="gtco-container">
			<div class="row row-pb-md">

				<div class="col-md-4">
					<div class="gtco-widget">
					<h3>About Us</h3>
					<image src="img/r.JPG" style="width:300px;height:200px"/>
						<p>I am a technology passionate Java Web Developer, have a solid understanding of Web development 
I am always looking forward to writing high-quality, good designed, easily-maintained & Instrumentation tested .
I am working hard to keep myself updated with new updates,love new career challenges.</p>
					
					</div>
				</div>

				<div class="col-md-4 col-md-push-1">
					<div class="gtco-widget">
						<h3>Links</h3>
						<ul class="gtco-footer-links">
							<li><a href="https://www.linkedin.com/in/raslan-shabaan/"> Linked In </a></li>
							<li><a href="https://github.com/RaslanShabaan">Git Hub </a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-4" >
					<div class="gtco-widget">
						<h3>Get In Touch</h3>
						<ul class="gtco-quick-contact">
							<li><a href="#"><i class="icon-phone"></i> 0100 2453285 </a></li>
							<li><a href="#"><i class="icon-mail2"></i> raslan.shabaan@gmail.com </a></li>
						</ul>
					</div>
				</div>

			</div>


		</div>
	</footer>
	</div>
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

	</body>
</html>
