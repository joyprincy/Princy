<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

	
	
table
 {
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

<body ng-app="myapp" ng-controller="Productcontroller">
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
				<li><a href="h3"><span class="glyphicon glyphicon-user"></span>
						Logout</a></li>
				
						
			</ul>
		</div>
	</div>
	</nav>

<div align="center">search <span class="glyphicon glyphicon-search"></span><input type="text" ng-model="searchbox"></span></div>

<table class="table-table-stripped">

<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Description</th>
<th>Price</th>
<th>Info</th>
</tr>
</thead>
<tbody>
<tr ng-repeat="pro in prot | filter : searchbox">
<td>{{pro.id}}</td>
<td>{{pro.name}}</td>
<td>{{pro.description}}</td>
<td>{{pro.price}}</td>

<td><a href="information?proid={{pro.id}}">i</a></td>
</tr>
</tbody>
</table>
<script type="text/javascript">
var products=${listproduct};
var myapp=angular.module("myapp",[]);
myapp.controller("Productcontroller",function($scope,$http){
	$scope.prot=products;
	
});
		

</script>
</body>
</html>