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
<script type="text/javascript">
<%
if(session.getAttribute("name")==null || !session.getAttribute("role").equals("Customer")){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>
</head>
<body>
  
  
<h1>Products List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Product name</th><th>Brand</th><th>Price</th><th>Description</th><th>Remove</th><th>BuyNow</th></tr> 
   <c:forEach var="pro" items="${sub2}">   
   <tr>  
   <td>${pro.productname}</td>  
   <td>${pro.productbrand}</td>  
   <td>${pro.price}</td>
   <td>${pro.description}</td>
   <td><a href="removecart/${cat.id}">Remove</a></td>  
   <td><a href="buynow/${cat.id}">Buy Now </a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   
</body>
</html>