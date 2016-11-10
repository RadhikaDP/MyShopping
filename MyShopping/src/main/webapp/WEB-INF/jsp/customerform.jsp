<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
        <h1>Add New Customer</h1>  
       <form:form method="post" action="save" modelAttribute="registration">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="username" pattern="[A-Za-z]{1,25}" title="only alphabets MAXLENGTH=25" /></td>  
           <td align="left"><form:errors path="username" cssClass="error"/></td>
         </tr>   
          <tr>    
          <td>Password :</td>    
          <td><form:password path="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters"/></td>  
          <td align="left"><form:errors path="password" cssClass="error"/></td>
         </tr> 
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Email  must be in the following order: characters@characters.domain(2-3 letter) "/></td>  
          <td align="left"><form:errors path="email" cssClass="error"/></td>
         </tr>          
         <tr>    
          <td>Phone :</td>    
          <td><form:input path="phone" pattern="[0-9]{1,10}" title="Enter 10 digit mobile number" /></td>  
          <td align="left"><form:errors path="phone" cssClass="error"/></td>
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>
        <br>  <a href="customer">Back</a>
       </body>
</html>