<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>

<h2>Products</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Action</th>
</tr>

<c:forEach var="p" items="${products}">
<tr>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>${p.price}</td>
    <td>
        <a href="addToCart?id=${p.id}">Add to Cart</a>
    </td>
</tr>
</c:forEach>

</table>

</body>
</html>