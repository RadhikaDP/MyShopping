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
			<ul class="dropdownMenu">
				<li><a href="#">Home</a></li>				
				<li><a href="#">Categories</a>			
				 <ul class="droprightMenu">
        
                 <c:forEach items="${category }" var="catLevel1">               
                        <li><a href="#">${catLevel1.getCategory()}</a> 
                            <ul class="droprightMenu">
                           
                                <c:forEach items="${sub}" var="catLevel2">
                                    <c:if test="${catLevel1.getCategory()==catLevel2.getCategory() }">
                                        <li><a href="#">${catLevel2.getSubcategory() }</a> 
                                            <ul class="droprightMenu">
                                         
                                                <c:forEach items="${sub2}" var="catLevel3">
                                                    <c:if test="${catLevel2.getSubcategory()==catLevel3.getSubcategory()}">
                                                        <li><a href="displayProducts/${catLevel3.id}">${catLevel3.getSubcategory2() }</a></li>
                                                    </c:if>
                                                </c:forEach>
                                                
                                            </ul>                                           
                                            </li>
                                    </c:if>
                                </c:forEach>
                                
                            </ul></li>
                </c:forEach>
              </ul>	</li>
				<li><a href="#">My Account</a>
					<ul class="droprightMenu">
						<li><a href="cart">Cart</a></li>
						<li><a href="order">Orders</a></li>						
					</ul></li>
					<li><a href="login">Logout</a></li>
				<li><a href="#">Help</a></li>
			</ul>
		</nav>
</body>
</html>