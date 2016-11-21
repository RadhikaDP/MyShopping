<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><jsp:include page="/WEB-INF/jsp/adminHome.jsp"></jsp:include> 
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
            Customer List
          </h4>
 </div> 
<table >  
<tr><th class="col-xs-2">Name</th><th class="col-xs-2">Email</th><th class="col-xs-2">Phone</th><th class="col-xs-2">Edit</th><th class="col-xs-2">Delete</th></tr>  
   <c:forEach var="cust" items="${list}">   
   <tr>  
   <td class="col-xs-2">${cust.username}</td>  
   <td class="col-xs-2">${cust.email}</td>  
   <td class="col-xs-2">${cust.phone}</td>  
   <td class="col-xs-2"><a href="editcust/${cust.id}"><img src="/MyShopping/resources/images/edit.jpg" height="50" width="60"></a></td>  
   <td class="col-xs-2"><a href="deletecust/${cust.id}"><img src="/MyShopping/resources/images/delete.png" height="47" width="65"></a></td>  
   </tr>  
   </c:forEach>  
   </table>  </div></div></div>
</div>
</body>
</html>