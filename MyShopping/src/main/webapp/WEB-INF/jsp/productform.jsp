<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><jsp:include page="/WEB-INF/jsp/adminHome.jsp"></jsp:include> 
<head><script type="text/javascript">
<%
if(session.getAttribute("name")==null || !session.getAttribute("role").equals("admin")){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript">

</script>
<style>
select {
    width: 100%;
    height : 80%;
    padding: 16px 20px;
    border: none;
    border-radius: 4px;
    background-color: black;
    color : white;
    font-weight: bold;
    font-size: 0.875em;
}
</style>
</head>
<body> <div class="app-cam">
<div align="center">
        <h3>Add New Product</h3>  
       <form:form method="post" action="saveproduct" modelAttribute="product">    
        <table >    
 		
           <tr>    
                                     

          <td>  
          <form:select path="category" name="category" id="category" items="${category}"  >
          
          </form:select></td>
          </tr>
          <tr>

              <td>   
          <form:select path="subcategory" name="subcategory" id="subcategory" items="${subcategory}"  >          
          </form:select>  
                    
          </td>  
         </tr>  
         <tr>       
          <td><form:input path="productname" placeholder="Product Name" /></td>  
          <td align="left"><form:errors path="productname" /></td>
         </tr>          
         <tr>    
    
          <td><form:input path="productbrand" pattern="[A-Za-z0-9]+" title="only alphabests and digits are allowed" placeholder="Brand Name" /></td>  
          <td align="left"><form:errors path="productbrand" /></td>
         </tr>   
         <tr>
          <tr>    
  
          <td><form:input path="price" pattern="[0-9]+" title="only digits are allowed" placeholder="Price"/></td>  
          <td align="left"><form:errors path="price" /></td>
         </tr>   
         <tr>
          <tr>    
       
          <td><form:input path="description" placeholder="Description" /></td>  
          <td align="left"><form:errors path="description" /></td>
         </tr>   
      
         <tr>     
          <td><input type="submit" value="Save" /></td>    
         </tr>            
        </table>   
               
       </form:form>
      </div>
          </div>
          </body>
           
</html>