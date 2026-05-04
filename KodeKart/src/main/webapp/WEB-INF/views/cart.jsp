<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<h2>Your Cart</h2>

<table border="1" cellpadding="10">
<tr>
    <th>Product Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Action</th>
</tr>

<c:forEach var="c" items="${cartItems}">
<tr>
    <td>${c.name}</td>
    <td>${c.price}</td>

    <td>
        <form action="updateCart" method="post">
            <input type="hidden" name="id" value="${c.id}"/>
            <input type="number" name="quantity" value="${c.quantity}" min="1"/>
            <button type="submit">Update</button>
        </form>
    </td>

    <td>
        <a href="removeFromCart?id=${c.id}">Remove</a>
    </td>
</tr>
</c:forEach>

</table>

<br>

<!-- Total Price outside table -->
<h3>Total Price: ${total}</h3>

<br>

<!--  Checkout button -->
<a href="checkout">Proceed to Payment</a>

<br><br>

<a href="/">Go Home</a>