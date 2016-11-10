<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/user.jsp"></jsp:include> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>checkout</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
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
 <div align="center">
<h1> Billing details </h1>
 <form:form action="billing" method="post" modelAttribute="creditcard">
            <table border="0">
             
                <tr>
                   
                    <td><form:input path="cardnumber" placeholder="Card Number" /></td>
                    <td align="left"><form:errors path="cardnumber" /></td>
                </tr>
                <tr>
                    
                    <td><form:input path="cardname" placeholder="Name On Card" /></td>
                    <td align="left"><form:errors path="cardname" /></td>
                </tr>
                <tr>
                    <td><form:input path="cvv" placeholder="CVV" /></td>
                    <td align="left"><form:errors path="cvv" /></td>
                </tr>
                <tr>     
                    <td><form:password path="pin" placeholder="PIN"/></td>
                    <td align="left"><form:errors path="pin" /></td>
                </tr>
                <tr>
                	
                    <td colspan="2" align="center"><input type="submit" value="Place Order" /></td>
                </tr>
            </table>
           
        </form:form>
        </div>
</body>
</html>