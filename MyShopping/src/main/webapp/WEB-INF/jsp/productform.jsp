<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${cat.subcategory}
        <h1>Add New Product</h1>  
       <form:form method="post" action="saveproduct" modelAttribute="product">    
        <table >    
 		
           <tr>    
                                     
		<td>
         Select Subcategory:
          </td>
          <td>  
           
          <form:select path="subcategory" name="subcategory" id="subcategory" items="${subcategory}"  >
          
          </form:select>
       
          </td>  
         </tr>  
         <tr>    
          <td>Product Name :</td>    
          <td><form:input path="productname" /></td>  
          <td align="left"><form:errors path="productname" /></td>
         </tr>          
         <tr>    
          <td>Brand :</td>    
          <td><form:input path="productbrand" /></td>  
          <td align="left"><form:errors path="productbrand" /></td>
         </tr>   
         <tr>
          <tr>    
          <td>Price :</td>    
          <td><form:input path="price" /></td>  
          <td align="left"><form:errors path="price" /></td>
         </tr>   
         <tr>
          <tr>    
          <td>Description :</td>    
          <td><form:input path="description" /></td>  
          <td align="left"><form:errors path="description" /></td>
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>   
               
       </form:form>
       <a href="productHome">Back</a>
          
          </body>
           
</html>