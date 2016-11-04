<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/adminHome.jsp"></jsp:include> 
<br/>
<br/>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
 <body >
 <br/><br/><br/>
  <div align="center">
<a href="categoryform">Add Category</a>  
<br/>
<a href="category">View Category</a> 
<br/>
<a href="subcategoryform">Add SubCategory</a>  
<br/>
<a href="subcategory">View SubCategory</a> 
</div>
</body> 
</html>