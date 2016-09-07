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
 <form:form method="POST" modelAttribute="product" action="addpro" enctype="multipart/form-data">
 <h1 class="well">Add product</h1>
 <div class="col-lg-14 well">
         
           <div class="row">
           <table>
            <tr>
           <td>
           <form:label path="id">ID</form:label></td>
          <td>
           <form:input path="id" class="form-control" readonly="true" /></td>
           </tr>
           
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
           <td>
           <form:label path="cat">Category</form:label></td>
          <td>
           <form:select class="form-control"  path="cat.name" items="${categorylist}" itemLabel="name" itemvalue="name"/></td>
           </tr>
             <tr>
           
           <td><form:label path="supplier">Supplier</form:label></td>
          <td>
           <form:input path="supplier" class="form-control"/></td>
           </tr>
         
           <tr>
           
           <td><form:label path="price">Price</form:label></td>
          <td>
           <form:input path="price" class="form-control"/></td>
           </tr>
          <td><form:label path="file">UploadFile</form:label></td>
          <td>
           <form:input type="file" path="file" class="form-control"/></td>
           </tr>
 <%-- <c:forEach items="${pinfo}" var="products">
 <div class=col-sm-3>
 <div class="items">
 <img class="img-responsive" src=<c:url value="/resources/images/${products.id}.jpg"/>width="240" height="240">
 </div>
 </div>
 <div class=col-sm-8>
 <br><b>NAME:</b>${products.name}<br>
 <br><b>DESCRIPTION:</b>${products.description}<br> 
 <br><b>PRICE:</b>${products.price}<br>
 <br><b>CATEGORY:</b>${products.category}<br>
  <br><b>SUPPLIER:</b>${products.supplier}<br>
 <br>
   </div>
   </c:forEach>        --%>
           
           <td colspan="2">
           <button type="submit" class="btn-btn-lg-info">Submit</button>   </td></tr>
                   </table>
                   
           </div>
           </div>
     
           </form:form>
           </div>
</body>
</html>