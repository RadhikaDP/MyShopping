<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page isELIgnored="false" %>
<title>Insert title here</title>
<script type="text/javascript">
<%
if(session.getAttribute("name")==null || session.getAttribute("role")!="Admin"){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>
</head>
<body>
<h1>Edit Customer</h1>  
       <form:form method="POST" action="/MyShopping/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="username"  /></td>  
         </tr>    
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td>Phone :</td>    
          <td><form:input path="phone" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value=" Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
         <br>  <a href="/MyShopping/customer">Back</a>
</body>
</html>