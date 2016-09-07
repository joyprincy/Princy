<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
body
{
background-image:url("resources/images/welcome 1.jpg");
padding:50px;
padding-top:0;
}
</style>
<body>

		<div class="container text-center">
			<h1>Admin</h1>
			
		</div>
	</div>

	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
					
    <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Product <span class="caret"></span></a>
	<ul class="dropdown-menu">
	
<li><a href="addproduct">Addproduct</a></li>
<li><a href="viewproduct">Viewproduct</a>	</li>
</ul>
  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
	<ul class="dropdown-menu">
	
<li><a href="addcategory">Addcategory</a></li>
<li><a href="viewcategory">Viewcategory</a>	</li>
</ul>
 <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier <span class="caret"></span></a>
	<ul class="dropdown-menu">
	
<li><a href="addsupplier">Addsupplier</a></li>
<li><a href="viewsupplier">Viewsupplier</a>	</li>
</ul>

			
</ul>
<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Logout</a></li>
				
						</ul>
		</div>
	</div>
	</nav>
	</body>
</html>