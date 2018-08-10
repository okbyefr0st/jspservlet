<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SQLTAGS</title>
</head>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<body>
<%--
<sql:setDataSource var="myds" url="jdbc:oracle:thin:@localhost:1521:xe"
driver = "oracle.jdbc.OracleDriver" use="training" password="oracle"/> --%>



<sql:query var="rs" datasource = "${rs.myds}">
select * from product </sql:query>

<table> border ="2">
<tr><th>Code</th></tr>Name</th><th> Price </th></tr>

<c:forEach var="item" items="${rs.rows}">
<tr><td>${item.code}</td>
<td>${item.name}</td>
<td>${item.price}</td></tr>
</c:forEach>
</table>
</body>
</html>