<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KodeKart</title>

<style>
    body {
        font-family: Arial;
        margin: 0;
        background-color: #f1f3f6;
    }

    /* 🔥 Header */
    .header {
        background-color: #2874f0;
        padding: 15px;
        text-align: center;
        color: white;
    }

    .search-box {
        width: 50%;
        padding: 8px;
        border-radius: 5px;
        border: none;
    }

    .search-btn {
        padding: 8px 15px;
        background-color: orange;
        border: none;
        color: white;
        cursor: pointer;
    }

    /* 🔥 Product Grid */
    .container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        margin-top: 20px;
    }

    .card {
        width: 200px;
        background: white;
        margin: 10px;
        padding: 10px;
        border-radius: 10px;
        text-align: center;
        box-shadow: 0px 0px 5px gray;
    }

    .card h4 {
        margin: 10px 0;
    }

    .price {
        color: green;
        font-weight: bold;
    }

    .btn {
        background-color: green;
        color: white;
        padding: 5px 10px;
        border: none;
        cursor: pointer;
        margin-top: 5px;
    }

    .nav {
        text-align: right;
        padding: 10px;
    }

    .nav a {
        margin: 5px;
        text-decoration: none;
        color: black;
    }
</style>

</head>
<body>

<!-- 🔥 Navbar -->
<div class="nav">
    <a href="${pageContext.request.contextPath}/cart">Cart</a>
    <a href="${pageContext.request.contextPath}/orders">Orders</a>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>

<!-- 🔥 Header + Search -->
<div class="header">
    <h2>KodeKart</h2>

    <form action="${pageContext.request.contextPath}/products/search" method="get">
        <input type="text" name="keyword" class="search-box" placeholder="Search for products...">
        <button class="search-btn">Search</button>
    </form>
</div>

<!-- 🔥 Products -->
<div class="container">

<c:forEach var="p" items="${products}">
    <div class="card">

        <h4>${p.name}</h4>
        <p>${p.category}</p>
        <p class="price">₹ ${p.price}</p>

        <!-- 🔥 Stock check -->
        <c:choose>
            <c:when test="${p.status == 'ACTIVE'}">
                <a href="${pageContext.request.contextPath}/cart/add/${p.id}">
                    <button class="btn">Add to Cart</button>
                </a>
            </c:when>

            <c:otherwise>
                <button class="btn" style="background:gray;" disabled>
                    Out of Stock
                </button>
            </c:otherwise>
        </c:choose>

    </div>
</c:forEach>

</div>

</body>
</html>