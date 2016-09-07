<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.modal-header, h4, .close {
	background-color: #5cb85c;
	color: white !important;
	text-align: center;
	font-size: 30px;
}

.modal-footer {
	background-color: #f9f9f9;
}
body
{
background-image:url("resources/images/bg joy.jpg");
background-repeat: no-repeat;
backgroung-attachment: fixed;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
padding:50px;
padding-top:0;
}

</style>
</head>
<body>

		<div class="container text-center">
			<h1>Login here</h1>
		</div>
	 <h1>${welcome}</h1>
<div class="container">
  <div class="row">
  	<div class="col-md-6">
   
            <form action="checklogin" id="login" method="post">
          <fieldset>
          
           <div class="form-group">
              <label path="username">UserName</label>
              
                <input type="text" name="username"  class="form-control" placeholder="enter your username" required="true"/>
                </div>
              
            
           
             <div class="form-group">
              <label path="password">Password</label>
              
                <input type="password" name="password" class="form-control"  placeholder="enter your passsword" required="true"/>
                </div>
                 <div class="control-group">
              
              <div class="controls">
                <button class="btn btn-success">Login</button>
              </div>
            </div>
          </fieldset>
</form>
</div>
</div>
</div>
		<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});
</script>

</body>
</html>





