<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/adminHome.jsp"></jsp:include> 
<br/>
<br/>
<head>
<%@ page isELIgnored="false" %>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
  
  
<h1>Product List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Subcategory</th> <th>Product Name</th><th>Product Brand</th><th>Price</th><th>Description</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="cat" items="${product}">   
   <tr>  
   <td>${cat.id}</td>  
   <td>${cat.subcategory }</td>
   <td>${cat.productname}</td>  
   <td>${cat.productbrand}</td>  
   <td>${cat.price}</td>  
   <td>${cat.description}</td> 
   <td><a href="editproduct/${cat.id}">Edit</a></td>  
   <td><a href="deleteproduct/${cat.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="productform">Add New Product</a>  
     <br>  <a href="productHome">Back</a>
</body>
</html>