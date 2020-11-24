<%@page import="tn.essat.dto.Productdto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" >
<title>Insert title here</title>
</head>
<body>
<% Productdto product = (Productdto) request.getAttribute("product");
         int index = (int) request.getAttribute("index"); 
%>
	<h1>EDIT new Products</h1>
	<form action="ShopServlet" method="post">
	<input type="hidden" name="index" value="<%=index%>" />
	<div class="form-group">
    <label >name</label>
      <input type="text" class="form-control" name="name" id="name" value="<%=product.getName()%>">
    </div>
     <div class="form-group">
    <label >quantity</label>
      <input type="text"  class="form-control" name="quantity" id="quantity" value="<%=product.getQuantity()%>">
    </div>
     <div class="form-group">
    <label >price</label>
      <input type="text"  class="form-control" name="price" id="price" value="<%=product.getPrice()%>">
    </div>
     <div class="form-group">
   
      <input type="submit" name="update" value="update" class="btn btn-primary"/>
    </div>
		</form>
</body>
</html>