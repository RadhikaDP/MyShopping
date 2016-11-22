<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><jsp:include page="/WEB-INF/jsp/user.jsp"></jsp:include> 
<head>
 <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" /> 
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
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
            Orders
          </h4>
 </div>
        <div style="overflow-y:auto;">
<table >  
<tr><th class="col-xs-2">Product name</th> <th class="col-xs-2">total</th> <th class="col-xs-2">quantity</th> <th class="col-xs-2">Cancel Order</th></tr>  
   <c:forEach var="cust" items="${order}">   
   <tr>   
   <td class="col-xs-2">${cust.productname}</td>  
   <td class="col-xs-2">${cust.total}</td>  
   <td class="col-xs-2">${cust.quantity}</td>    
   <td class="col-xs-2"><a href="cancelOrder/${cust.id}/${cust.productname}/${cust.quantity}">CancelOrder</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   </div>
   </div>
   </div>
 </div> 
</body>
<%-- <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>  --%>
</html>