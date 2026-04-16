<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Products</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #667eea, #764ba2);
}

.card {
    width: 70%;
    margin: 60px auto;
    background: white;
    padding: 25px;
    border-radius: 12px;
    text-align: center;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

h2 {
    color: #333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

th {
    background-color: #6c5ce7;
    color: white;
    padding: 10px;
}

td {
    padding: 10px;
    border-bottom: 1px solid #ddd;
}

tr:hover {
    background-color: #f2f2f2;
}

button {
    padding: 10px 15px;
    border: none;
    border-radius: 6px;
    background: #6c5ce7;
    color: white;
    cursor: pointer;
    margin-top: 15px;
}
</style>

</head>

<body>

<div class="card">

<h2>📋 All Products</h2>

<table>
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Status</th>
</tr>

<c:if test="${empty products}">
    <tr>
        <td colspan="3">No Products Found</td>
    </tr>
</c:if>

<c:forEach var="p" items="${products}">
<tr>
    <td>${p.id}</td>
    <td>${p.name}</td>
    <td>${p.status}</td>
</tr>
</c:forEach>

</table>

<a href="dashboard">
    <button>⬅ Back to Dashboard</button>
</a>

</div>

</body>
</html>