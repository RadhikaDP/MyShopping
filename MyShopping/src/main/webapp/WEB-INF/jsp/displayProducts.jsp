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
<title>products</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<%@ page isELIgnored="false" %>
<script type="text/javascript">
<%
if(session.getAttribute("name")==null){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>

<style type="text/css">
th, td {
    padding: 15px;
    text-align: left;
}
th, td {
    border-bottom: 1px solid #ddd;
}
tr:hover {background-color: #f5f5f5}
</style>
</head>
<body> 
 <div class="container">
  <div class="row">
  <div class="panel panel-default"> 
 <div class="panel-heading">
          <h4>
            Products
          </h4>
 </div>
<table  >  
<tr><th class="col-xs-2">Product name</th><th class="col-xs-2">Brand</th><th class="col-xs-2">Price</th><th class="col-xs-2">Description</th><th class="col-xs-2">Stock</th><th class="col-xs-2">Add to cart</th><th class="col-xs-2">Buy Now</th></tr> 

   <c:forEach var="pro" items="${sub2}">   
   <tr>  
   <td class="col-xs-2">${pro.productname}</td>  
   <td class="col-xs-2">${pro.productbrand}</td>  
   <td class="col-xs-2">${pro.price}</td>
   <td class="col-xs-2">${pro.description}</td>
    <td class="col-xs-2">
    <c:set var="stock" value= "${pro.stock}"/>
 	<% 
 	String res="Avilable";
 	Object ob = pageContext.getAttribute("stock");
	int test=(Integer)ob;
	if(test==0){
		res="Out of Stock";
	}

	request.setAttribute("res", res);
    %> 
    
      ${res}
    </td>
   <td class="col-xs-2"><a href="addcart/${pro.id}/${pro.productname}/${pro.subid}">Add to Cart</a></td>  
   <td class="col-xs-2"><a href="buynow/${pro.subcategory}/${pro.id}">Buy Now </a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   </div></div></div>
</body>
<%-- <jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>  --%>
</html>