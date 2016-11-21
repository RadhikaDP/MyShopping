 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
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
<style>
select {
    width: 100%;
    height : 70%;
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

<body>
  <div class="app-cam">
<div align="center">
        <h3>Add New Sub Category</h3>  
       <form:form method="post" action="savesubcategory" modelAttribute="command" >    
        <table >    
         <tr>    
         <td>
        <b>Category:</b>
          </td>
          <td>
          <form:select path="category" name="category" id="category" items="${category}"  >
          
          </form:select>
          </td>
          <td><form:errors path="category" /></td> 
         </tr>   
          <tr>           		<td>
       <b>  Sub-Category:</b>
          </td>   
          <td><form:input path="subcategory"  pattern="[A-Za-z ]+" title="only Characters are allowed"/></td>  
          <td><form:errors path="subcategory"/></td> 
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>
       </div></div>
  </body>

</html>