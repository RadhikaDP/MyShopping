<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  
<h1>Category List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="cat" items="${category}">   
   <tr>  
   <td>${cat.id}</td>  
   <td>${cat.category}</td>  
   <td><a href="editcategory/${cat.id}">Edit</a></td>  
   <td><a href="deletecategory/${cat.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="categoryform">Add New Category</a>  <br>
   <a href="categoryHome">Back</a>
</body>
</html>