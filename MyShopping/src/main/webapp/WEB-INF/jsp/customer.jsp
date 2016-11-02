

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
</head>
 <body background-image:url('bg.jpg');>
 <br/><br/><br/>
  <div align="center">
<a href="customerform">Add Customer</a>  
<br/>
<a href="viewcustomer">View Customers</a> 
</div>
</body> 
</html>
