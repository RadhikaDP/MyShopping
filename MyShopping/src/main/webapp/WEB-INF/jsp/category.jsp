<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
<%
if(session.getAttribute("name")==null || session.getAttribute("role")!="Admin"){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>
<style type="text/css">
th, td {
    padding: 15px;
    text-align: left;
}
th, td {
    border-bottom: 1px solid #ddd;
}
tr:hover {background-color: #f5f5f5}
</style>
</head>

<body >
  <div align="center">
 <div class="container">
  <div class="row">
  <div class="panel panel-default"> 
 <div class="panel-heading">
          <h4>
            Cart
          </h4>
 </div>
<table >  
<tr><th class="col-xs-2">Id</th><th class="col-xs-2">Name</th><th class="col-xs-2">Edit</th><th class="col-xs-2">Delete</th></tr>  
   <c:forEach var="cat" items="${category}">   
   <tr>  
   <td class="col-xs-2">${cat.id}</td>  
   <td class="col-xs-2">${cat.category}</td>  
   <td class="col-xs-2"><a href="editcategory/${cat.id}">Edit</a></td>  
   <td class="col-xs-2"><a href="deletecategory/${cat.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table> 
    
   </div></div></div>
   <br/>  
   <a href="categoryform" >Add New Category</a>  <br>
   <a href="categoryHome">Back</a>
   </div>
</body>

</html>