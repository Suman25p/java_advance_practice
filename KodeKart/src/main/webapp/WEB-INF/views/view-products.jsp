<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Products</title>

<style>
    body { font-family: Arial; margin: 40px; }
    h2 { text-align: center; }

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

    button {
        padding: 6px 12px;
        border-radius: 5px;
        border: none;
        color: white;
        background-color: green;
        cursor: pointer;
    }

    .home {
        display: inline-block;
        margin-top: 20px;
        padding: 10px;
        background-color: #2c3e50;
        color: white;
        text-decoration: none;
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
        <!-- ✅ FIXED ADD TO CART -->
        <form action="${pageContext.request.contextPath}/addToCart" method="post">
            <input type="hidden" name="productId" value="${p.id}" />
            <input type="hidden" name="quantity" value="1" />
            <button type="submit">Add to Cart</button>
        </form>
    </td>
</tr>
</c:forEach>

</table>

<br>
<a class="home" href="${pageContext.request.contextPath}/">Go Home</a>

</body>
</html>