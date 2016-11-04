<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  
<h1>Customer List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Email</th><th>Phone</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="cust" items="${list}">   
   <tr>  
   <td>${cust.id}</td>  
   <td>${cust.username}</td>  
   <td>${cust.email}</td>  
   <td>${cust.phone}</td>  
   <td><a href="editcust/${cust.id}">Edit</a></td>  
   <td><a href="deletecust/${cust.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="customerform">Add New Customer</a>  
     <br>  <a href="customer">Back</a>
</body>
</html>