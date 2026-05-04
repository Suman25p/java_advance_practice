<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<h2>Order History</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Total Amount</th>
    <th>Date</th>
</tr>

<c:forEach var="o" items="${orders}">
<tr>
    <td>${o.id}</td>
    <td>${o.totalAmount}</td>
    <td>${o.orderDate}</td>
</tr>
</c:forEach>
<c:forEach var="i" items="${items}">
<tr>
    <td>${i.productName}</td>
    <td>${i.price}</td>
    <td>${i.quantity}</td>
</tr>
</c:forEach>
</table>

<br>
<a href="/">Go Home</a>