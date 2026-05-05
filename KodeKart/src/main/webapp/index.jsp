<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KodeKart</title>

<style>
body { font-family: Arial; margin:0; background:#f1f3f6; }

.header {
    background:#2874f0;
    padding:15px;
    color:white;
    text-align:center;
}

.search-box { padding:8px; width:50%; }
.btn { padding:6px 12px; background:green; color:white; border:none; }

.container {
    display:flex;
    flex-wrap:wrap;
    justify-content:center;
    margin-top:20px;
}

.card {
    width:200px;
    background:white;
    margin:10px;
    padding:10px;
    border-radius:10px;
    text-align:center;
    box-shadow:0 0 5px gray;
}
</style>

</head>
<body>

<!-- 🔥 NAV -->
<div style="text-align:right;padding:10px;">
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <a href="login">Login</a>
        <a href="register">Register</a>
    </c:when>
    <c:otherwise>
        <a href="cart">Cart</a>
        <a href="orders">Orders</a>
        <a href="logout">Logout</a>
    </c:otherwise>
</c:choose>
</div>

<!-- 🔥 HEADER -->
<div class="header">
<h2>KodeKart</h2>

<form action="search" method="get">
    <input type="text" name="keyword" class="search-box" placeholder="Search product">
    <button class="btn">Search</button>
</form>
</div>

<!-- 🔥 PRODUCTS -->
<div class="container">

<c:forEach var="p" items="${products}">
    <div class="card">
        <h4>${p.name}</h4>
        <p>${p.category}</p>
        <p>₹ ${p.price}</p>

        <c:choose>
            <c:when test="${p.status == 'ACTIVE'}">
                <a href="cart/add/${p.id}">
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