<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
</head>
<body>

<h2>Add Product with Reviews</h2>

<form action="saveProduct" method="post">

    Product Name:
    <input type="text" name="name" required><br><br>

    Review 1:
    <input type="text" name="comments"><br><br>

    Review 2:
    <input type="text" name="comments"><br><br>

    Review 3:
    <input type="text" name="comments"><br><br>

    <button type="submit">Save Product</button>

</form>

</body>
</html>