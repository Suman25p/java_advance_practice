<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<h2>Admin Product Management</h2>

<!-- 🔗 Top Links -->
<a href="${pageContext.request.contextPath}/admin/add">Add Product</a> |
<a href="${pageContext.request.contextPath}/admin/upload">Bulk Upload</a>

<br><br>

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
    <td>
        <a href="${pageContext.request.contextPath}/admin/edit/${p.id}">Edit</a> |
        <a href="${pageContext.request.contextPath}/admin/delete/${p.id}">Delete</a> |
        <a href="${pageContext.request.contextPath}/admin/status/${p.id}">
            Toggle Status
        </a>
    </td>
</tr>
</c:forEach>

</table>