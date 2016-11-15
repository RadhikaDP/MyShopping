<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/user.jsp"></jsp:include> 
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/images/remove.png" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
<%
if(session.getAttribute("name")==null || session.getAttribute("role")!="Customer"){
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
  
 <div class="container">
  <div class="row">
  <div class="panel panel-default"> 
 <div class="panel-heading">
          <h4>
            Cart
          </h4>
 </div>
<table  >  
 <tr><th class="col-xs-2">Product name</th><th class="col-xs-2">Remove</th><th class="col-xs-2">Buy</th><tr>
   <c:forEach var="cart" items="${cart}">   
   <tr>  
   <td class="col-xs-2">${cart.productname}</td>  
   <td class="col-xs-2"><a href="deletcart/${cart.cartid }">Remove from  cart</a></td>    
   <td class="col-xs-2"><a href="/MyShopping/displayProducts/buynow/${cart.productname}/${cart.productid}">Buy Now</a></td>
   </tr>  
   </c:forEach>  
   </table>   
   </div>
   </div></div>  
</body>
</html>