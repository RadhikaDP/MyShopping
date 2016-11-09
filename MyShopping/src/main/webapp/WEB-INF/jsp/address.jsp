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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://lab.iamrohit.in/js/location.js"></script>
</head>
<body>
 <div align="center">
<h3>Enter your Address details </h3>
 <form:form action="/MyShopping/address1" method="post" modelAttribute="address">
            <table border="0">
             
                <tr>
                   
                    <td><form:input path="flatno" placeholder="Flat no / House no" pattern="[0-9]{1,6}" title="only digits are allowed"/></td>
                    <td align="left"><form:errors path="flatno" /></td>
                </tr>
                <tr>
                    
                    <td><form:input path="locality" placeholder="Locality" pattern="[A-Za-z]{1,25}" title="only alphabets are allowed"/></td>
                    <td align="left"><form:errors path="locality"/></td>
                </tr>
                  <tr>
           				<td>
                         <form:select path="country" name="country" class="countries" id="countryId">
                                     <form:option value="">Select Contry</form:option>
                                    </form:select>
                    </td>
                </tr>
                 <tr>     
                
                    <td>
                    <form:select path="state" name="state" class="states" id="stateId">
                                     <form:option value="">Select State</form:option>
                                    </form:select>
                    </td>
                </tr>
                <tr>
           			<td>
                         <form:select path="town" name="city" class="cities" id="cityId">
                                     <form:option value="">Select City</form:option>
                                    </form:select>
                    </td>
                </tr>
              
                 <tr>     
                    <td><form:input path="pincode" placeholder="Pincode"  pattern="[0-9]{1,7}" title="only digits are allowed"/></td>
                    <td align="left"><form:errors path="pincode" /></td>
                </tr>
                <tr>
                	
                    <td colspan="2" align="center"><input type="submit" value="Continue" /></td>
                </tr>
            </table>
           
       </form:form>
        </div>
</body>
</html>