<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>buynow</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<%@ page isELIgnored="false" %>

<script type="text/javascript">

function computecost()
{
	var quantity=document.getElementById("quantity").value;
  
	
	document.getElementById("total").value=quantity*${pro.price};
	document.getElementById("total").disabled = "true";
	
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
   <form method="post" action="/MyShopping/address"  >
    <div><br>
   <label for="name">Number Of Items</label>
   <input type ="text" name="quantity" id="quantity" size="2">
   
   <br><br>
   <input type ="button" value="total cost" name="total"  onclick= "computecost();">
    <input type ="text"  name="total" id="total" onclick= "this.blur();">
   </div>
   <br>
   <input type="submit" value="Proceed to checkout" id ="submit" onclick="return validate();">
   <input type="reset" value="clear" />
   </form> 
      

   
</body>
</html>