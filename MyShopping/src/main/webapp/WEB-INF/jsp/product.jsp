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
<script type="text/javascript">
<%
if(session.getAttribute("name")==null || !session.getAttribute("role").equals("admin")){
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
<body>
    <div align="center">
 <div class="container">
  <div class="row">
  <div class="panel panel-default"> 
 <div class="panel-heading">
          <h4>
            Product List
          </h4>
 </div> 
<table>  
<tr><th class="col-xs-2">Id</th><th class="col-xs-2">Subcategory</th> <th class="col-xs-2">Product Name</th><th class="col-xs-2">Product Brand</th><th class="col-xs-2">Price</th><th class="col-xs-2">Description</th><th class="col-xs-2" >Edit</th><th class="col-xs-2">Delete</th></tr>  
   <c:forEach var="cat" items="${product}">   
   <tr>  
   <td class="col-xs-2">${cat.id}</td>  
   <td class="col-xs-2">${cat.subcategory }</td>
   <td class="col-xs-2">${cat.productname}</td>  
   <td class="col-xs-2">${cat.productbrand}</td>  
   <td class="col-xs-2">${cat.price}</td>  
   <td class="col-xs-2">${cat.description}</td> 
   <td class="col-xs-2"><a href="editproduct/${cat.id}">Edit</a></td>  
   <td class="col-xs-2"><a href="deleteproduct/${cat.id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  </div></div></div>

   
</body>
</html>