<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/homeheader.jsp"></jsp:include> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>checkout</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<h1>Enter your Address details </h1>
 <form:form action="billing" method="get" modelAttribute="address">
            <table border="0">
             
                <tr>
                   
                    <td><form:input path="flatno" placeholder="Flat no / House no" /></td>
                </tr>
                <tr>
                    
                    <td><form:input path="locality" placeholder="Locality" /></td>
                </tr>
                <tr>
                    <td><form:input path="town" placeholder="Towm" /></td>
                </tr>
                <tr>     
                    <td><form:input path="state" placeholder="State"/></td>
                </tr>
                 <tr>     
                    <td><form:input path="pincode" placeholder="Pincode"/></td>
                </tr>
                <tr>
                	
                    <td colspan="2" align="center"><input type="submit" value="Continue" /></td>
                </tr>
            </table>
           
        </form:form>
</body>
</html>