<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Confirmation By Admin</title>
<style>
body {
    font-family: Arial;
    background: linear-gradient(to right, #667eea, #764ba2);
}

.card {
    width: 400px;
    margin: 80px auto;
    background: white;
    padding: 25px;
    border-radius: 12px;
    text-align: center;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

.success {
    color: green;
    font-size: 22px;
    font-weight: bold;
}

button {
    padding: 10px 15px;
    border: none;
    border-radius: 6px;
    background: #6c5ce7;
    color: white;
    cursor: pointer;
}
</style>
</head>
	<body>
	<div class="card">
    <div class="success">✅ Product Uploaded</div>

    <p>Product ID: ${response.productId}</p>
    <p>${response.confirmationMsg}</p>

    <a href="dashboard"><button>Go Dashboard</button></a>
	</div>
	</body>
</html>
	