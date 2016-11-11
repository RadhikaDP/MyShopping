<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:include page="/WEB-INF/jsp/temp.jsp"></jsp:include> 
<br/>
<br/>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</head>
<body >
  <div class="app-cam">
 <div align="center">
 <h2 class="form-heading"> ADMIN LOGIN</h2>
 <br></br>
        <form:form action="admin" method="post" modelAttribute="admin"  >
            <table border="0">

                <tr>
                    
                    <td><form:input path="username" name="uname" placeholder="UserName"/></td>
                    <td align="left"><form:errors path="username" cssClass="error" /></td>
                </tr>
                <tr>
                  
                    <td><form:password path="password" name="upass" placeholder="Password" /></td>
                    <td align="left"><form:errors path="password" cssClass="error"  /></td>
                </tr>            
                <tr>              
                    <td colspan="1" align="center"><input type="submit" value="login"  /></td>
                  
                </tr>
            </table>
            <p><a href="login"> Back</a></p>
        </form:form>
    </div>
    </div>
</body>
