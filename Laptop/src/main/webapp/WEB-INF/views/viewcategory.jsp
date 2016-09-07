<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
	<style>
	.input[type=text] {
    width: 130px;
    -webkit-transition: width 0.4s ease-in-out;
    transition: width 0.4s ease-in-out;
}

input[type=text]:focus {
    width: 100%;
}
	
	
table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 5px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color:#fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
	
</head>

<body ng-app="myapp" ng-controller="Categorycontroller">
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

<li><a href="contact">Contact</a></li>
				<li><a href="Admin">Admin</a></li>
				
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
				
						
			</ul>
		</div>
	</div>
	</nav>




<div align="center">search <input type="text" ng-model="searchbox"></div>
<table class="table-table-stripped">

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Description</th>

<th>Edit</th>  
<th>Delete</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="cat in cate  | filter : searchbox">
<td>{{cat.id}}</td>
<td>{{cat.name}}</td>
<td>{{cat.description}}</td>

<td><a href="editc?catid={{cat.id}}">Edit</a></td>
<td><a href="dele?catid={{cat.id}}">Delete</a></td>
</tr>
</tbody>
</table>
<script type="text/javascript">
var categorys=${cdata};
var myapp=angular.module("myapp",[]);
myapp.controller("Categorycontroller",function($scope){
	$scope.cate=categorys;
	
});
		

</script>
</body>
</html>