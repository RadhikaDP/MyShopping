<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title><%@ page isELIgnored="false" %>
<script type="text/javascript">
<%
if(session.getAttribute("name")==null){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>
</head>

<body>
        <h1>Add New Category</h1>  
       <form:form method="post" action="savecategory"  modelAttribute="category">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="category"  pattern="[A-Za-z]{1,30}" title="only alphabets MAX LENGTH=30" /></td>  
          <td align="left"><form:errors path="category" /></td>
         </tr>     
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>
       <a href="categoryHome">Back</a>
       </body>

</html>