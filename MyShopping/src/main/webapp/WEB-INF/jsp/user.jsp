<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
 <%@ page import="shop.bean.Category" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  -->

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<%@ page isELIgnored="false" %>
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/dropdownmenue.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
<%
if(session.getAttribute("name")==null){
	response.sendRedirect("/MyShopping/login");
}
%>
window.history.forward();
function noBack()
{
    window.history.forward();
}

</script>

</head>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">

<nav>
 <div align="center">
<div >
			<ul class="dropdownMenu">
				<li><a href="/MyShopping/home">Home</a></li>
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
            	  </ul>    </li>                      
     
				<li><a href="#">My Account</a>
					<ul class="droprightMenu">
						<li><a href="/MyShopping/viewcart">Cart</a></li>
						<li><a href="/MyShopping/vieworder">Orders</a></li>						
					</ul></li>
					<li><a href="/MyShopping/about">About Us</a></li>
					<li><a href="/MyShopping/contact">Contact Us</a></li>
					<li><a href="/MyShopping/logout">Logout</a></li>
				
			</ul>
			</div>
			</div>
		</nav>

</body>
</html>