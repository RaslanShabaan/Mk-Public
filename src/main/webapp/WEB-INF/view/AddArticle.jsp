<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title> Admin Dashboard </title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="css/pe-icon-7-stroke.css" rel="stylesheet" />

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="purple" data-image="assets/img/sidebar-5.jpg">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="http://www.creative-tim.com" class="simple-text">
                    Creative Tim
                </a>
            </div>

            <ul class="nav">
                <li class="active">
                        <i class="pe-7s-graph"></i>
                            <form action="/GoSettings" method="get">
                               <button style="color:#000;border-color:#000;width: 80%" class="btn"> Account Settings </button>
                        </form>
                </li>
                <li>
                        <i class="pe-7s-user"></i>
                                <form action="/GoAddAdmin" method="get">
                                <button class="btn" style="color:#000;border-color:#000;width: 80%">Add Admin</button>
                                </form>
                </li>
                <li>
                        <i class="pe-7s-note2"></i>
                                <form action="/GoAddUser" method="get">
                                <button class="btn" style="color:#000;border-color:#000;width: 80%">Add User</button>
                                 </form>                                
                </li>
                <li>
                        <i class="pe-7s-news-paper"></i>
                                     <form action="/GoAllAdmins" method="get">                         
                                <button class="btn" style="color:#000;border-color:#000;width: 80%">All Admins</button>
                                </form>
               
                </li>
                <li>
                        <i class="pe-7s-science"></i>
                                <form action="/GoAllUserss" method="get">
                                <button class="btn" style="color:#000;border-color:#000;width: 80%">All Users</button>
                                </form>
                    
                </li>
                <li>
                        <i class="pe-7s-map-marker"></i>
                         <form action="/GoAddArt" method="get">
                                <button class="btn" style="color:#000;border-color:#000;width: 80%">Add Article</button>
                                </form>
                </li>
                <li>
                        <i class="pe-7s-bell"></i>
                     <form action="/AllArts" method="get">
                                <button  style="color:#000;border-color:#000;width: 80%" class="btn">All Articles</button>
                                </form>
                </li>
				<li class="active-pro">
				                        <i class="pe-7s-rocket"></i>
                                        <form action="/Logout" method="get">
                                <button style="color:#000;border-color:#000;width: 80%" class="btn">Log Me out</button>
                        </form>

                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                   <h3>Welcome Admin:: <b><c:out value="${pageContext.request.remoteUser}"/></b> </h3>
                   
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
								<p class="hidden-lg hidden-md">Dashboard</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-globe"></i>
                                    <b class="caret hidden-lg hidden-md"></b>
									<p class="hidden-lg hidden-md">
										5 Notifications
										<b class="caret"></b>
									</p>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
                        <li>
                           <a href="">
                                <i class="fa fa-search"></i>
								<p class="hidden-lg hidden-md">Search</p>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                            <form action="/GoSettings" method="get">
                               <button style="margin-right: 400px;margin-bottom: 0px" class="btn"> Account Settings </button>
                        </form>
                        <li class="dropdown" style="margin-left: 150px;margin-top: -75px">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <button class="btn">
										Admin Options			
										<b class="caret"></b>
									</button>
									
                              </a>
                              <ul class="dropdown-menu">
                                <li>
                                <form action="/GoAddAdmin" method="get">
                                <button class="btn" style="width:80%;margin-left:10%">Add Admin</button>
                                </form>
                                </li>
                               
                                <li>
                                <form action="/GoAddUser" method="get">
                                <button class="btn" style="width:80%;margin-left:10%">Add User</button>
                                 </form>                                
                                </li>

                                <li>
                                <form action="/GoAllAdmins" method="get">                         
                                <button class="btn" style="width:80%;margin-left:10%">All Admins</button>
                                </form>
                                </li>

                                <li>
                                <form action="/GoAllUserss" method="get">
                                <button class="btn" style="width:80%;margin-left:10%">All Users</button>
                                </form>
                                </li>

                                <li>
                                <form action="/GoAddArt" method="get">
                                <button class="btn" style="width:80%;margin-left:10%">Add Article</button>
                                </form>
                                </li>

                                <li>
                                <form action="/AllArts" method="get">
                                <button class="btn" style="width:80%;margin-left:10%">All Articles</button>
                                </form>
                                </li>
                               </ul>
                        </li>
                        
                        <form action="/Logout" method="get">
                                <button style="margin-top: -50px" class="btn">Log Me out</button>
                        </form>
						
						<li class="separator hidden-lg"></li>
                    </ul>
                </div>
            </div>
        </nav> 
    <h2 style="font-weight: bold;font-style: italic;color: red">${addd} </h2>
    <h2>Add New Article </h2>
                                                <form action="/PostArticle" method="post" enctype="multipart/form-data" > 
                                                
                                                <input type="text" required="required" placeholder="Article-Header" name="Head"/>
                                                <br><br>
											    <textarea name="Article" required="required" style="width:500px;height:250px;color:#000;"></textarea>
											    <input type="hidden"  name="${_csrf.parameterName}"	value="${_csrf.token}"/>
											    <br>
											     <input type="file" required="required" name="file" placeholder="Article-Picture" /><br />
                               
                                            <button class="btn" style="color:green;border-color: green" class="btn">Add Article</button> 
											</form>
    
    
    
</div>
 </div>
   
</body>

    <!--   Core JS Files   -->
    <script src="js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="js/light-bootstrap-dashboard.js?v=1.4.0"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="js/demo.js"></script>

	<script type="text/javascript">
    	$(document).ready(function(){

        	demo.initChartist();

        	$.notify({
            	icon: 'pe-7s-gift',
            	message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

            },{
                type: 'info',
                timer: 4000
            });

    	});
	</script>
</html>
