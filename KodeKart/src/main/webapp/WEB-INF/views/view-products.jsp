<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Products</title>

<style>
    body {
        font-family: Arial;
        margin: 40px;
    }

    h2 {
        text-align: center;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 10px;
        text-align: center;
        border: 1px solid #ddd;
    }

    th {
        background-color: #3498db;
        color: white;
    }

    a {
        text-decoration: none;
        padding: 5px 10px;
        border-radius: 5px;
        color: white;
    }

    .delete {
        background-color: red;
    }

    .cart {
        background-color: green;
    }

    .home {
        display: inline-block;
        margin-top: 20px;
        padding: 10px;
        background-color: #2c3e50;
    }
</style>

</head>
<body>

<h2>All Products</h2>

<table>
<tr>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Actions</th>
</tr>

<c:forEach var="p" items="${products}">
<tr>
    <td>${p.name}</td>
    <td>${p.category}</td>
    <td>${p.price}</td>
    <td>${p.quantity}</td>
   
    <td>
        <a class="cart" href="addToCart/${p.id}">Add to Cart</a>
        
    </td>
</tr>
</c:forEach>

</table>

<br>
<a class="home" href="/">Go Home</a>

</body>
</html>