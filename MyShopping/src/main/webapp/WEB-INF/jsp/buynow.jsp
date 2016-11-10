<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/user.jsp"></jsp:include> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>buynow</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<%@ page isELIgnored="false" %>

<script type="text/javascript">

function  computecost()
{
	var quantity=document.getElementById("quantity").value;
  
 	 document.getElementById("total").disabled = "true";  
	document.getElementById("total").value= quantity*${pro.price};
 

}

</script>

</head>
<body id="login">

  <h2 class="form-heading"> </h2>
<br></br>
<table border="2" width="70%" cellpadding="2">  
<tr><th>Product name</th><th>Brand</th><th>Price</th><th>Description</th></tr> 

   <tr>  
   <td>${pro.productname}</td>  
   <td>${pro.productbrand}</td>  
   <td>${pro.price}</td>
   <td>${pro.description}</td>  
   <td></td>
   </tr>  
   </table>     
       <form:form action="/MyShopping/address/${pro.productname }/${pro.price}" method="post" modelAttribute="order"  >
            <table border="0">
           		   <tr>
                    <td>Quantity</td>
                    <td><form:input path="quantity" name="quantity" id="quantity" placeholder="Quantity" /></td>
                    <td align="left"><form:errors path="quantity" cssClass="error"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="button" value="total cost"  onclick=" computecost()"  /></td>
                    <td><form:input path="total" name="total" id="total"  readonly="readonly"/></td>
                    <td align="left"><form:errors path="total" cssClass="error"/></td>
                    <td></td>
                </tr>
                         
                <tr>
                <td></td>
                    <td colspan="2" align="center"><input type="submit" value="Proceed to pay" /></td>
                </tr>
                <tr><td><input type="reset" value="clear" /></td></tr>
            </table>
        </form:form>

   
</body>
</html>