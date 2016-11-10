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

<%
if(session.getAttribute("name")==null){
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
				<li><a href="/MyShopping/home">Home</a>
				<li><a href="#">Categories</a>			
				
			 	 <ul class="droprightMenu">  
                 <c:forEach items="${category}" var="catLevel1">     
                           
                        <li ><a href="#">${catLevel1.getCategory()}</a> 
                            <ul class="droprightMenu">                  
                                <c:forEach items="${sub}" var="catLevel2"> 
                                                                         
                                  <c:if test="${catLevel1.getCategory().equals(catLevel2.getCategory())}">     
                                                     
                                        <li><a href="displayProducts/${catLevel2.getId()}">${catLevel2.getSubcategory() }</a> 
                                                                                                                       
                                        </li>
                                    </c:if>                                                                                                                            
                                </c:forEach>                               
                            </ul></li>
                </c:forEach>
              </ul>                          
     </li>
				<li><a href="#">My Account</a>
					<ul class="droprightMenu">
						<li><a href="/MyShopping/viewcart">Cart</a></li>
						<li><a href="/MyShopping/vieworder">Orders</a></li>						
					</ul></li>
					<li><a href="/MyShopping/about">About Us</a></li>
					<li><a href="/MyShopping/contact">Contact Us</a></li>
					<li><a href="/MyShopping/logout">Logout</a></li>
				
			</ul>
			</div>		</div>
		</nav>

</body>
</html>