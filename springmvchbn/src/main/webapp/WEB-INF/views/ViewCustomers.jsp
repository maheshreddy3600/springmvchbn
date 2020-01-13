<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr><th>Customer_code<th>customer_name</th></tr>
<c:forEach var="cust" items="${customers}">
<tr>
<td><c:out value="${cust.code}"></c:out></td>
<td><c:out value="${cust.name}"></c:out></td>

<td><a  href="updatecust?code=${cust.code}">Update</a></td>
<td><a href="deletecust?code=${cust.code}">Delete</a></td>
</tr>
</c:forEach>
</table>
<a href ="addcust">Add Customer</a>

</body>
</html>