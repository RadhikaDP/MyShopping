<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>products</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<%@ page isELIgnored="false" %>
</head>
<body> 
<h1>Products List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Product name</th><th>Brand</th><th>Price</th><th>Description</th><th>Add to cart</th><th>Buy Now</th></tr> 

   <c:forEach var="pro" items="${sub2}">   
   <tr>  
   <td>${pro.productname}</td>  
   <td>${pro.productbrand}</td>  
   <td>${pro.price}</td>
   <td>${pro.description}</td>
   <td><a href="addcart/${pro.id}/${pro.productname}/${pro.subcategory}">Add to Cart</a></td>  
   <td><a href="buynow/${pro.subcategory}/${pro.id}">Buy Now </a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   
</body>
</html>