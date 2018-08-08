<%@page import="lti.hola.bean.RegisterBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile Window</title>
</head>

<body bgcolor=#ADD8E6 text=black>
<jsp:include page="banner.jsp"/>
<% RegisterBean user= (RegisterBean) session.getAttribute("User"); %>
<table align="center">
<tr><th colspan="2"> Your Profile Details </th></tr>
<tr><td> Name </td></tr><tr><td><%=user.getName() %></td></tr>
<tr><td> Email </td></tr><tr><td><%=user.getEmail() %></td></tr>
<tr><td> Age </td></tr><tr><td><%=user.getAge() %> </td></tr>
<tr><td> Gender </td></tr><tr><td><%=user.getGender() %> </td></tr>
<tr><td> City </td></tr><tr><td><%=user.getCity() %> </td></tr>
<tr><td colspan="2"> <img src = "<%= user.getPhoto() %>" height="200" width="200"> </td></td>
</table>
 
<%@include file="footer.html" %>
</body>
</html>