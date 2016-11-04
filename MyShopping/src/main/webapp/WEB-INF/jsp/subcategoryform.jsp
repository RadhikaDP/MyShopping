 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title><%@ page isELIgnored="false" %>
<style>
   .error 
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>

<body>
        <h1>Add New sub Category</h1>  
       <form:form method="post" action="savesubcategory" >    
        <table >    
         <tr>    
          <td><spring:message code="lbl.category" text="Category" /></td> 
          <td><form:input path="category"  /></td> 
          <td><form:errors path="category" cssClass="error" /></td> 
         </tr>   
          <tr>    
          <td><spring:message code="lbl.subcategory" text="Sub-Category" /></td>  
          <td><form:input path="subcategory"  /></td>  
          <td><form:errors path="subcategory" cssClass="error" /></td> 
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