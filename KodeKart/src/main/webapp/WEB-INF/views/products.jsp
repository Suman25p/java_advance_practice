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

<!-- ✅ Error message -->
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<!-- ✅ Empty check -->
<c:if test="${empty products}">
    <p>No products available!</p>
</c:if>

<c:if test="${not empty products}">
<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<c:forEach var="p" items="${products}">
<tr>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>₹ ${p.price}</td>

    <!-- 🔥 Status -->
    <td>
        <c:choose>
            <c:when test="${p.status == 'ACTIVE'}">
                <span style="color:green;">Available</span>
            </c:when>
            <c:otherwise>
                <span style="color:red;">Out of Stock</span>
            </c:otherwise>
        </c:choose>
    </td>

    <!-- 🔥 Action -->
    <td>
        <c:choose>

            <!-- ✅ If product available -->
            <c:when test="${p.status == 'ACTIVE'}">
                <a href="${pageContext.request.contextPath}/cart/add/${p.id}">
                    Add to Cart
                </a>
            </c:when>

            <!-- ❌ If not available -->
            <c:otherwise>
                <span style="color:gray;">Not Available</span>
            </c:otherwise>

        </c:choose>
    </td>
</tr>
</c:forEach>

</table>
</c:if>

</body>
</html>