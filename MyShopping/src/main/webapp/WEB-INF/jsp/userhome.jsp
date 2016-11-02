<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/dropdownmenue.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<nav>
			<!-- Navigation -->
			<ul class="dropdownMenu">
				<li><a href="#">Home</a></li>
				
				<li><a href="#">My Account</a>
					<ul class="dropdownMenu">
						<li><a href="#">My orders</a></li>
						<li><a href="#">Cart</a></li>						
					</ul>
				</li>
				<li><a href="#">About Us</a>
				
				</li>

				<li><a href="#">Contact Us</a>
					</li>
					<li><a href="#">Logout</a></li>
				<li><a href="#">Help</a></li>
			</ul>
		</nav>
</body>
</html>