<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <h1>Add New Product</h1>  
       <form:form method="post" action="saveproduct">    
        <table >    
 
           <tr>    
          <td>Product Subcategory Id :</td>    
          <td><form:input path="sub2id" /></td>  
         </tr>  
         <tr>    
          <td>Product Name :</td>    
          <td><form:input path="productname" /></td>  
         </tr>          
         <tr>    
          <td>Brand :</td>    
          <td><form:input path="productbrand" /></td>  
         </tr>   
         <tr>
          <tr>    
          <td>Price :</td>    
          <td><form:input path="price" /></td>  
         </tr>   
         <tr>
          <tr>    
          <td>Description :</td>    
          <td><form:input path="description" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>
       </body>
</html>