<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/font-awesome.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" />
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body >
<table width="770" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="25" align="left" valign="top">&nbsp;</td>
  </tr>
  <tr>
    <td align="center" valign="top" ><table width="755" height="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td height="75" align="center" valign="middle"><table width="720" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td width="475" height="30" align="left" valign="middle" class="caption">FASHION 
                  <font color="9F1E30">SHOP</font></td>

              </tr>
            </table></td>
        </tr>
        <tr>
          <td height="32" align="center" valign="middle" ><table width="750" border="0" cellspacing="0" cellpadding="0">
              <tr align="center" valign="middle">
                <td width="70" height="25"><a href="login" class="footermenu">Home</a></td>
                <td width="60" height="25"><a href="myaccount" class="footermenu">My Account</a></td>                              
                <td width="95" height="25"><a href="about" class="footermenu">About us</a></td>         
                <td width="95" height="25"><a href="contact" class="footermenu">contact us</a></td>	
                 <td width="80" height="25"><a href="logout" class="footermenu">logout</a></td>   			
              </tr>
            </table></td>
        </tr>      
      </table></td>
  </tr>
</table>
</body>
</html>