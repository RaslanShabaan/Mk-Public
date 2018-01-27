<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Login form </title>  
      <link rel="stylesheet" href="css/stylee.css">
</head>
<body>
  <body>  
<div class="container" >
<h1 style="color: #fff ;font-weight: bold;font-style: italic; font-size: 20px"> ${logout} </h1>      
    <div class="container">
<h1 style="color: #fff ;font-weight: bold;font-style: italic; "> ${Reg} </h1>
-
<h1 style="color: #fff ;font-weight: bold;font-style: italic; "> ${vcod} </h1>

    <!--  Login Fail  -->
    <c:if test="${not empty error}">
        <h1 style="color: #c7254e;font-weight: bold;font-style: italic;font-size: 30px">  ${error}</h1>
    </c:if>

	<section id="content">
		
			<h1>Login Form</h1>
			<form action="/Login" method="post">
			<div>
				<input type="text" placeholder="Username" name ="username" required="" id="username" />
				<input type="password" placeholder="Password" required=""name="password" id="password" />
				<input type="submit" value="Log Me In :) " />
				<input type="hidden"  name="${_csrf.parameterName}"	value="${_csrf.token}"/>
            
				</form>
			</div>
			
			<div style="margin-bottom:-90px">
			<form action="/GoRegister" method="get">
			<input type="submit" value="Register Me:)" />
			</form>
			</div>
			
			<div style="margin-top:px;margin-left:50%">
<form action="/er" method="get">			
			<input  type="submit" value="Find Me Acc :)" />
</form>
				
		</div>
		<!-- form -->
	</section><!-- content -->
	<h2 style="font-weight: bold;color:#c7254e">For Admin Try [Admin - Admin] but For User Try [User - User] If It Not Work Try Theird Button To Make You Account :)</h2>
	</div><!-- container -->
</body>
  

    <script  src="js/index.js"></script>
</body>
</html>
