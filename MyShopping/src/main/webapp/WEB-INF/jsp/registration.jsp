<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/temp.jsp"></jsp:include> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body id="login" >
  <div class="app-cam">
 <div align="center">
 <h2 class="form-heading"> REGISTRATION</h2>
 <br></br>
        <form:form action="registration" method="post" modelAttribute="registration">
            <table border="0">
             
                <tr>
                   
                    <td><form:input path="username" pattern="[A-Za-z0-1]{1,25}" title="only alphabets and numbers MAXLENGTH=25" placeholder="User Name" /></td>
                     <td align="left"><form:errors path="username" cssClass="error"/></td>
                </tr>
                <tr>
                    
                    <td><form:password path="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" placeholder="Password" /></td>
                     <td align="left"><form:errors path="password" cssClass="error"/></td>
                </tr>
                <tr>
                  
                    <td><form:input path="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="Email  must be in the following order: characters@characters.domain(2-3 letter) " placeholder="E-mail" /></td>
                     <td align="left"><form:errors path="email" cssClass="error"/></td>
                </tr>
                <tr>
                    
                    <td><form:input path="phone"  pattern="^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$" title="Enter mobile number of this pattern : 123-456-7890
(123) 456-7890
123 456 7890
123.456.7890
+91 (123) 456-7890" placeholder="Phone Number"/></td>
                     <td align="left"><form:errors path="phone" cssClass="error"/></td>
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