<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>

<style>
    body {
        font-family: Arial;
        margin: 40px;
    }
    form {
        width: 350px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
    }
    input, textarea {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
    }
    button {
        padding: 8px 15px;
        background-color: green;
        color: white;
        border: none;
    }
    .error {
        color: red;
    }
</style>

</head>
<body>

<h2>Add Product</h2>

<!-- ✅ Error message -->
<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<!-- ✅ Success message -->
<c:if test="${not empty msg}">
    <p style="color:green">${msg}</p>
</c:if>

<form:form action="${pageContext.request.contextPath}/admin/save"
           method="post"
           modelAttribute="product">

    <label>Name:</label>
    <form:input path="name" required="true"/>

    <label>Category:</label>
    <form:input path="category" required="true"/>

    <label>Price:</label>
    <form:input path="price" type="number" step="0.01" required="true"/>

    <label>Quantity:</label>
    <form:input path="quantity" type="number" required="true"/>

    <label>Description:</label>
    <form:textarea path="description"/>

    <br>
    <button type="submit">Add Product</button>

</form:form>

<br>

<!-- 🔥 Navigation -->
<a href="${pageContext.request.contextPath}/admin/products">Back to Products</a> |
<a href="${pageContext.request.contextPath}/">Go Home</a>

</body>
</html>