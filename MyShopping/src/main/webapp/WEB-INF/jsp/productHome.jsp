

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
  <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<html lang="en">
<jsp:include page="/WEB-INF/jsp/adminHome.jsp"></jsp:include>
<head>
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
 <body >
 <br/><br/><br/>
  <div align="center">
  <h3>
<a href="productform">Add Product</a>  </h3>
<br/><h3>
<a href="product">View Product</a> </h3>
</div>
</body> 
</html>