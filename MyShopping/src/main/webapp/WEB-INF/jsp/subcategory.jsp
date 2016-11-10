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
<script type="text/javascript">
<%
if(session.getAttribute("name")==null){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>
</head>
<body>
  
  
<h1>Sub Category List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Category</th><th>SubCategory</th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="cat" items="${subcategory}">   
   <tr>  
   <td>${cat.id}</td>  
   <td>${cat.category}</td>  
   <td>${cat.subcategory}</td> 
   <td><a href="editsubcategory/${cat.id}">Edit</a></td>  
   <td><a href="deletesubcategory/${cat.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="subcategoryform">Add New Category</a>  
   <br><a href="categoryHome">Back</a>
</body>
</html>