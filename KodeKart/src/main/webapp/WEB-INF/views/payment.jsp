<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Page</title>
</head>

<body>

<h2>Payment Page</h2>

<h3>Total Amount: ₹ ${total}</h3>

<br>

<form action="${pageContext.request.contextPath}/placeOrder" method="post">

    <label>Select Payment Method:</label><br><br>

    <input type="radio" name="method" value="UPI" required> UPI <br>
    <input type="radio" name="method" value="Card"> Debit/Credit Card <br>
    <input type="radio" name="method" value="COD"> Cash on Delivery <br><br>

    <button type="submit">Pay Now</button>

</form>

<br>

<a href="${pageContext.request.contextPath}/cart">Back to Cart</a>

</body>
</html>