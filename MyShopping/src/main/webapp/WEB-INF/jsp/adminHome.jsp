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
<script type="text/javascript">
<%! String role="admin"; %>  
<%
if(session.getAttribute("name")==null ){
	
	response.sendRedirect("/MyShopping/login");
}
else if(!session.getAttribute("role").equals(role)){
	
	response.sendRedirect("/MyShopping/login");
	
}
%>
</script>
</head>
<body>

<nav>
 <div align="center">
<div >
			<ul class="dropdownMenu">
				<li><a href="#">Home</a>
				<li><a href="#">Category </a>
				<ul class="droprightMenu">
					<li> <a href="/MyShopping/categoryform">Add Category</a></li>
					<li> <a href="/MyShopping/category">View Category</a></li>
					<li> <a href="/MyShopping/subcategoryform">Add SubCategory</a> </li>
					<li> <a href="/MyShopping/subcategory">View SubCategory</a></li>
				</ul>
				</li>
				
					<li><a href="#">Product </a>
						<ul class="droprightMenu">
							<li> <a href="/MyShopping/productform">Add Product</a> </li>
							<li><a href="/MyShopping/product">View Product</a></li>
							
						</ul>
					</li>
				<li><a href="#">Customer </a>
					<ul class="droprightMenu">
							<li><a href="/MyShopping/customerform">Add Customer</a></li>
							<li> <a href="/MyShopping/viewcustomer">View Customers</a> </li>
							
							
						</ul>
				
				</li>
				<li><a href="/MyShopping/adminlogout">Logout</a></li>				
			</ul>
			</div>		</div>
		</nav>

</body>
</html>