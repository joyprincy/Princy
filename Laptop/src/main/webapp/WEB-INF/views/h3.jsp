<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.jumbotron {
	background-color:;
	text-align: center;
}

.navbar {
	margin-bottom: 50px;
	border-radius: 0;
}

.jumbotron {
	margin-bottom: 0;
}

footer {
	background-color: #f2f2f2;
	padding: 25px;
}

.carousel-inner>.item>img {
	width: 640px;
	height: 360px;
}

.carousel-inner>.item>a>img {
	width: 100%;
	margin: auto;
}
</style>
</head>
<body>
	<div class="jumbotron">
		<div class="container text-center">
			<h1>Laptop Cart</h1>
			<p>Exclusive Laptop with latest models</p>
			<h5>${welcomeuser}</h5>
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




				<li><a href="About">About</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Category <span class="caret"></span></a>
					<ul class="dropdown-menu">

						<li><a href="categorylist?">dell</a></li>
						<li><a href="categorylist?">apple</a></li>
						<li><a href="categorylist?">lenova</a></li>
					</ul>
				<li><a href="contact">Contact</a></li>


			</ul>


			<ul class="nav navbar-nav navbar-right">
			 <c:choose>
		<c:when test="${empty loggedInUser }">
		<li><a href="h2"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
		
		</c:when>
		<c:when test="${not empty loggedInUser }">
		<li><a href="logout"><span class="glyphicon glyphicon-user"></span>Logout</a></li>
		</c:when>
		</c:choose>
		
				
				<li><a href="h4"><span class="glyphicon glyphicon-user"></span>
						Signup</a></li>

			</ul>
		</div>
	</div>
	</nav>
	<div class="container">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src=<c:url value="resources/images/picture1.jpg"/>
						alt="picture1">
				</div>

				<div class="item">
					<img src=<c:url value="resources/images/picture2.jpg"/>
						alt="picture2">
				</div>

				<div class="item">
					<img src=<c:url value="resources/images/picture3.jpg"/>
						alt="picture3">
				</div>
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>

			</div>
		</div>
</body>
</html>
