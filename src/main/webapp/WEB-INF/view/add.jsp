<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title> Add Acc form </title>  
      <link rel="stylesheet" href="css/stylee.css">
</head>
<body>
  <body>  
<div class="container" >

	<section id="content">
		
			<h1>Admin Form</h1>
			<form action="/IAdmin" method="Post">
			<div>
				<input type="text" name="UN" placeholder="Admin-Name" required="" id="username" />
				<input name="PS" type="password" placeholder="Admin-PassWord" required="" id="password" />
				<input type="hidden"  name="${_csrf.parameterName}"	value="${_csrf.token}"/>
				<input type="submit" value="Add Admin :) " />
				</form>
			</div>
		
			<h1>User Form</h1>
			<form action="/IUser" method="Post">
			<div>
				<input type="text" name="UN" placeholder="User-Name" required="" id="username" />
				<input name="PS" type="password" placeholder="User-PassWord" required="" id="password" />
				<input type="hidden"  name="${_csrf.parameterName}"	value="${_csrf.token}"/>
				<input type="submit" value="Add User :) " />
				</form>
			</div>
				
		</div>
		<!-- form -->
	</section><!-- content -->
	</div><!-- container -->
	</body>
    <script  src="js/index.js"></script>
</body>
</html>
