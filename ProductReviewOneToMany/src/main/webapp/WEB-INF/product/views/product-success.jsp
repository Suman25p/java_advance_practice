<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Success</title>
</head>
<body>

<h2>Product Saved Successfully </h2>

<p>Product ID: ${response.productId}</p>
<p>Message: ${response.message}</p>

<a href="productPage">Add Another Product</a>

</body>
</html>