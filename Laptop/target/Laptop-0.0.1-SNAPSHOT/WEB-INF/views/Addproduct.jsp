<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
 <form:form method="POST" commandName="addproduct" action="addpro">
 <h1 class="well">Add product</h1>
 <div class="col-lg-14 well">
         
           <div class="row">
           <table>
           
           
            <tr>
           <td>
           <form:label path="description">Description</form:label></td>
          <td>
           <form:input path="description" class="form-control"/></td>
           </tr> 
            <tr>
           <td>
           <form:label path="name">Name</form:label></td>
          <td>
           <form:input path="name" class="form-control"/></td>
           </tr>
           <tr>
           
           <td><form:label path="price">Price</form:label></td>
          <td>
           <form:input path="price" class="form-control"/></td>
           </tr>
          
          
           
           <td colspan="2">
           <button type="submit" class="btn-btn-lg-info">Submit</button>   </td></tr>
                   </table>
                   
           </div>
           </div>
     
           </form:form>
           </div>
</body>
</html>