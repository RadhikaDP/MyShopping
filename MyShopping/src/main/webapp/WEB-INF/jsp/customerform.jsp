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
<body><div align="center">  <div class="app-cam">
        <h2>Add New Customer</h2>  
       <form:form method="post" action="save" modelAttribute="registration">    
        <table border="0">
             
                <tr>
                   
                    <td><form:input path="username" pattern="[A-Za-z0-1]{1,25}" title="only alphabets and numbers MAXLENGTH=25" placeholder="User Name" /></td>
                     <td align="left"><form:errors path="username" cssClass="error"/></td>
                </tr>
                <tr>
                    
                    <td><form:password path="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" placeholder="Password" /></td>
                     <td align="left"><form:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                  
                    <td><form:input path="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Email  must be in the following order: characters@characters.domain(2-3 letter) " placeholder="E-mail" /></td>
                     <td align="left"><form:errors path="email" cssClass="error"/></td>
                </tr>
                <tr>
                    
                    <td><form:input path="phone"  pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$" title="Enter mobile number of this pattern : 123-456-7890
(123) 456-7890
123 456 7890
123.456.7890
+91 (123) 456-7890" placeholder="Phone Number"/></td>
                     <td align="left"><form:errors path="phone" cssClass="error"/></td>
                </tr>
                <tr>
                	
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
       </form:form>
        <br>  <a href="customer">Back</a></div></div>
       </body>
</html>