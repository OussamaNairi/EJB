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
	<h1>Add new Products</h1>
	<form action="ShopServlet" method="post">
	
  <div class="form-group">
    <label >name</label>
      <input type="text" class="form-control" name="name" id="name" placeholder="name">
    </div>
     <div class="form-group">
    <label >quantity</label>
      <input type="text"  class="form-control" name="quantity" id="quantity" placeholder="quantity">
    </div>
     <div class="form-group">
    <label >price</label>
      <input type="text"  class="form-control" name="price" id="price" placeholder="price">
    </div>
     <div class="form-group">
   
      <input type="submit" name="add" value="add" class="btn btn-primary"/>
    </div>


	</form>
	<%
		double total = (double) request.getAttribute("total");
	%>
	<h1>List of Products ,Total = <span id="total" ><%=total%></span></h1>
	<%
		List<Productdto> products = (List<Productdto>) request.getAttribute("products");
	%>
	<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">index</th>
			<th scope="col">name</th>
			<th scope="col">quantity</th>
			<th scope="col">price</th>
			<th scope="col">Delete</th>
			<th scope="col">Edit</th>

		</tr>
		</thead>
		<%
			int index = 0;
			if (products != null && !products.isEmpty()) {
				for (Productdto p : products) {
					index++;
		%>
		<tr id="tr<%=index%>">
			<td><%=index%></td>
			<td><%=p.getName()%></td>
			<td><%=p.getQuantity()%></td>
			<td><%=p.getPrice()%></td>
           <td><a href="javascript:deleteProduct(<%=index%>)">Delete</a></td>
           <td><form action="ShopServlet" method="post">
             <input   type="hidden" name="index" value="<%=index%>">
              <input   type="submit" name="load" value="editer">
           </form></td>
		</tr>
		<%
			}
			}
		%>


	</table>
	<script src="js/sweetalert.min.js"></script>
  <script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/products.js"></script>
</body>
</html>