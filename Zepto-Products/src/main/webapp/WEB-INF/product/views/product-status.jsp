<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>Product Status</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #667eea, #764ba2);
}

.card {
    width: 400px;
    margin: 100px auto;
    background: white;
    padding: 25px;
    border-radius: 12px;
    text-align: center;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

.success {
    color: green;
    font-size: 20px;
    font-weight: bold;
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

<h2>🔍 Product Status</h2>

<p>Product ID: <b>${productId}</b></p>

<p class="success">
    Status: ${status}
</p>

</div>

</body>
</html>