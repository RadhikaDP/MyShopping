<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  
<h1>Product List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Subcategory Id <th>Product Name</th><th>Product Brand</th><th>Price</th><th>Description</th></tr>  
   <c:forEach var="cat" items="${product}">   
   <tr>  
   <td>${cat.id}</td>  
   <td>${cat.sub2id }</td>
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
</body>
</html>