<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<br/>
<br/>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body id="login">
 <jsp:include page="/WEB-INF/jsp/temp.jsp"></jsp:include> 
  <div class="app-cam">
 <div align="center">
 <h2 class="form-heading"> LOGIN</h2>
 <br></br>
        <form:form action="login" method="post" modelAttribute="login"  >
            <table border="0">
           
                <tr>
                    
                    <td><form:input path="username" name="uname" placeholder="User Name"/></td>
                    <td align="left"><form:errors path="username" cssClass="error"/></td>
                </tr>
                <tr>
                  
                    <td><form:password path="password" name="upass" placeholder="Password" /></td>
                    <td align="left"><form:errors path="password" cssClass="error"/></td>
                </tr>            
                <tr>
                
                
                    <td colspan="2" align="center"><input type="submit" value="login" /></td>
                </tr>
            </table>
            <p>New here ?<a href="registration"> Sign up</a></p>
        </form:form>
    </div>
    </div>
</body>

</html>