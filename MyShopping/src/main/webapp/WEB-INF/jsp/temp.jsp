<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
 <%@ page import="shop.bean.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/dropdownmenue.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>


</head>
<body>

<nav>
 <div align="center">
<div >
			<ul class="dropdownMenu">
				<li><a href="/MyShopping/login">Sign In</a>
				<li><a href="/MyShopping/registration">Sign Up</a></li>					
				<li><a href="/MyShopping/about">About us</a>
				<li><a href="/MyShopping/contact">contact us</a></li>				
			</ul>
			</div>		</div>
		</nav>

</body>
</html>