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
Here you are!!!!
<a href="login.jsp"><button>LogOut</button></a>
<hr size ="3" color="midnightblue">
<table style="width:100%">
<tr>
<th>Name</th>
<th>Email</th>
<th>Age</th>
<th>Gender</th>
<th>City</th>
<th>Photo</th>
</tr>

<tr>
<td> <%= request.getParameter("name") %></td>
<td> <%= request.getParameter("email") %></td>
<td> <%= request.getParameter("age") %></td>
<td> <%= request.getParameter("gender") %></td>
<td> <%= request.getParameter("city") %></td>
<td> <%= request.getParameter("photo") %></td>

</table>

<%@include file="footer.html" %>
</body>
</html>