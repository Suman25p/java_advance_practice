<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
        width: 300px;
        padding: 20px;
        border: 1px solid #ccc;
        border-radius: 10px;
    }
    input {
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
</style>

</head>
<body>

<h2>Add Product</h2>


<form:form action="${pageContext.request.contextPath}/admin/save" method="post" modelAttribute="product">

    <label>Name:</label>
    <form:input path="name"/>

    <label>Category:</label>
    <form:input path="category"/>

    <label>Price:</label>
    <form:input path="price"/>

    <label>Quantity:</label>
    <form:input path="quantity"/>

    <label>Description:</label>
    <form:input path="description"/>

    <br>
    <button type="submit">Add Product</button>

</form:form>

<br>


<a href="${pageContext.request.contextPath}/">Go Home</a>

</body>
</html>