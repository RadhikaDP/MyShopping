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
<body>  <div class="app-cam">
<h2>Edit Customer</h2>  
       <form:form method="POST" action="/MyShopping/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="username" pattern="[A-Za-z0-1]{1,25}" title="only alphabets and numbers MAXLENGTH=25" placeholder="User Name" required="true" /></td>  
         </tr>    
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Email  must be in the following order: characters@characters.domain(2-3 letter) " placeholder="Email" required="true"  /></td>  
         </tr>   
         <tr>    
          <td>Phone :</td>    
          <td><form:input path="phone"  pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$" title="Enter mobile number of this pattern : 123-456-7890" placeholder="Phone Number" required="true" /></td>  
         </tr>   
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value=" Save" /></td>    
         </tr>    
        </table>    
       </form:form>  
         </div>
</body>
</html>