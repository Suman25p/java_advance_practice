<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>

<h2>Admin Product Management</h2>

<!-- 🔥 Navigation -->
<a href="${pageContext.request.contextPath}/admin/add">Add Product</a> |
<a href="${pageContext.request.contextPath}/admin/upload">Bulk Upload</a> |
<a href="${pageContext.request.contextPath}/logout">Logout</a>

<br><br>

<!-- ✅ Error message -->
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<!-- ✅ Success message -->
<c:if test="${not empty msg}">
    <p style="color:green">${msg}</p>
</c:if>

<!-- ✅ Empty check -->
<c:if test="${empty products}">
    <p>No products available!</p>
</c:if>

<c:if test="${not empty products}">
<table border="1" cellpadding="8">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Price</th>
    <th>Status</th>
    <th>Actions</th>
</tr>

<c:forEach var="p" items="${products}">
<tr>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>${p.price}</td>

    <!-- 🔥 Status -->
    <td>
        <c:choose>
            <c:when test="${p.status == 'ACTIVE'}">
                <span style="color:green;">ACTIVE</span>
            </c:when>
            <c:otherwise>
                <span style="color:red;">INACTIVE</span>
            </c:otherwise>
        </c:choose>
    </td>

    <!-- 🔥 Actions -->
    <td>
        <a href="${pageContext.request.contextPath}/admin/edit/${p.id}">Edit</a> |

        <a href="${pageContext.request.contextPath}/admin/delete/${p.id}"
           onclick="return confirm('Are you sure you want to delete this product?');">
           Delete
        </a> |

        <a href="${pageContext.request.contextPath}/admin/status/${p.id}">
            Toggle Status
        </a>
    </td>
</tr>
</c:forEach>

</table>
</c:if>