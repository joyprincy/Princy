<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration form</title>

</head>
<style>
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
<body>

		<div class="container text-center">
			<h1>Register here</h1>
		</div>
	
<div class="container">
  <div class="row">
  	<div class="col-md-6">
     <form:form action="register" id="reg" method="post" commandName="user" autocomplete="on">
          <fieldset>
            <div class="form-group">
              <label for="firstname">FIRST NAME</label>
                <form:input path="firstname"  name="firstname" class="form-control" id="firstname"  placeholder="enter your last name" required="true"/>
                <p class="help-block">Firstname can contain any letters or numbers, without spaces</p>
              </div>
            
             <div class="form-group">
              <label for="lastname">LAST NAME</label>
               <form:input path="lastname"  name="lastname" class="form-control" id="lastname"  placeholder="enter your last name" required="true"/>
                <p class="help-block">Lastname can contain any letters or numbers, without spaces</p>
              </div>
            
         
            <div class="form-group">
              <label  for="emailid">EMAIL-ID</label>
               <form:input path="emailid" name="emailid" class="form-control " id="emailid"  placeholder="enter your e-mailid" required="true"/>
                <p class="help-block">Please provide your E-mail</p>
              </div>
              
                 <div class="form-group">
              <label  for="adress">ADDRESS</label>
               <form:input path="address" name="address" class="form-control " id="address"  placeholder="enter your address" required="true"/>
                <p class="help-block">Please provide your address</p>
              </div>
               <div class="form-group">
              <label  for="username">USERNAME</label>
               <form:input path="username" name="username" class="form-control " id="username"  placeholder="enter your username" required="true"/>
                <p class="help-block">Please provide your username</p>
              </div>
         
            
                        <div class="form-group">
              <label for="password">PASSWORD</label>
               <form:input path="password" name="password" class="form-control" id="password"  placeholder="enter your password" required="true"/>
       <form:errors path="password"/>
                <p class="help-block">Password should be at least 6 characters</p>
              </div>
            
         
            
         
    <div class="control-group">
              
              <div class="controls">
                <button class="btn btn-success">Register</button>
              </div>
            </div>
          </fieldset>
          </form:form>
        </form>
    
    </div> 
  </div>
</div>



    </body>
</html>