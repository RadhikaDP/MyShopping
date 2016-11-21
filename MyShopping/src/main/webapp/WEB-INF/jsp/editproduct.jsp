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
</head>
<body><div class="app-cam">
<h1>Edit Customer</h1>  
       <form:form method="POST" action="/MyShopping/editsaveproduct">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Subcategory Id : </td>   
          <td><form:input path="subcategory"  /></td>  
         </tr>     
         <tr>    
          <td>Product name :</td>    
          <td><form:input path="productname" /></td>  
         </tr>   
                    <tr>    
          <td>Product brand:</td>    
          <td><form:input path="productbrand" /></td>  
         </tr>   
         <tr>    
          <td>Price :</td>    
          <td><form:input path="price" /></td>  
         </tr> 
                  <tr>    
          <td>Description :</td>    
          <td><form:input path="description" /></td>  
         </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" value=" Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
        <br>  </div>
</body>
</html>