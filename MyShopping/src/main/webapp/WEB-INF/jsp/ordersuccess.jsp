<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="/WEB-INF/jsp/user.jsp"></jsp:include> 
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
<%
if(session.getAttribute("name")==null || session.getAttribute("role")!="Customer"){
	response.sendRedirect("/MyShopping/login");
}
%>
</script>
</head>
<body>
<h1>Your order has been placed successfully....!</h1>

</body>
</html>