<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><jsp:include page="/WEB-INF/jsp/user.jsp"></jsp:include> 
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
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
  
  
<h1>Order List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Product name</th><th>total</th><th>quantity</th><th>Cancel Order</th></tr>  
   <c:forEach var="cust" items="${order}">   
   <tr>   
   <td>${cust.productname}</td>  
   <td>${cust.total}</td>  
   <td>${cust.quantity}</td>  
  
   <td><a href="cancelOrder/${cust.id}">CancelOrder</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
 
</body>
</html>