<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title> Register form </title>  
      <link rel="stylesheet" href="css/stylee.css">
</head>
<body>
  <body>  
<div class="container" style="margin-top:7%">

	<section id="content">
		<form action="Register" method="post" name="Form" onsubmit="return validation()">
			<h1> Register Form</h1>
			<div>
				<input name="UMail"   placeholder="E_Mail"   type ="text" required="" id="username" />
			</div>
			<div>
				<input type="text"     name="UName"   placeholder="UserName" required="" id="password" />
			</div>
			<div>
				<input type="password" name="UPass" placeholder="PassWord" required="" id="password" />
			</div>
			<div>
				<input type="text"     name="UPhone"  placeholder="Phone"  required="" id="password" />
			</div>
			 <input type="hidden"  name="${_csrf.parameterName}"	value="${_csrf.token}"/>
          	
			<div>
				<input type="submit" value="Register Me:)" />
			</div>
			
		</form><!-- form -->
	</section><!-- content -->
	</div><!-- container -->  
<script>
        
        function validation()
        {
            var text=/^[A-Za-z]+$/;
            // UserName Validation //
            if (document.Form.UName.value.length <1) {
                alert("User Name Is Requred.");
                return false;
            }
            if(document.Form.UName.value.length >20) {
                alert("User Name Is InValid Too Long .");
                return false;
            }  
            
        if( document.Form.UName.value.match(text)) {
               
            }else{
                alert("Not A Text ");
                return false;
            }
         
         
          // UserPassWord Validation //
        if (document.Form.UPass.value.length < 1) {
                alert("User PassWord Is Requred .");
                return false;
            }
            

        //  email  Validation // 
        if (document.Form.UMail.value.length < 1) {
                alert("Email Is Requred .");
                return false;
            }
            
                // Phone  Validation //
            if (document.Form.UPhone.value.length <1 ) {
                alert("Phone Is Requred .");
                return false;
            }if (document.Form.UPhone.value.length != 11 ) {
                alert("Not A Phone Number .");
                return false;
            }if (isNaN(document.Form.UPhone.value) ) {
                alert("Not A Phone Number .");
                return false;
            }
            
         else {
                return true;
            }
        }
    </script>

    <script  src="js/index.js"></script>
</body>
</html>
