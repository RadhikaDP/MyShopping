<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/homeheader.jsp"></jsp:include> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body id="login" background-image:url('bg.jpg');>
  <div class="app-cam">
 <div align="center">
 <h2 class="form-heading"> REGISTRATION</h2>
 <br></br>
        <form:form action="registration" method="post" modelAttribute="registration">
            <table border="0">
             
                <tr>
                   
                    <td><form:input path="username" placeholder="User Name" /></td>
                </tr>
                <tr>
                    
                    <td><form:password path="password" placeholder="Password" /></td>
                </tr>
                <tr>
                  
                    <td><form:input path="email" placeholder="E-mail" /></td>
                </tr>
                <tr>
                    
                    <td><form:input path="phone" placeholder="Phone Number"/></td>
                </tr>
                <tr>
                	
                    <td colspan="2" align="center"><input type="submit" value="Register" /></td>
                </tr>
            </table>
            <p>Allready Registered ?<a href="login"> Sign In</a></p>
        </form:form>
    </div>
    </div>
</body>
</html>