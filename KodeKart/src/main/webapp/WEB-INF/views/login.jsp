<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 🔥 Already logged user → redirect -->
<c:if test="${not empty sessionScope.user}">
    <c:redirect url="/index"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<h2>Login</h2>

<!-- ✅ Error message -->
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form action="doLogin" method="post">

    Email: 
    <input type="email" name="email" required/><br><br>

    Password: 
    <input type="password" name="password" required/><br><br>

    <button type="submit">Login</button>
</form>

<br>

<!-- ✅ Register link -->
<a href="register">Don't have an account? Register</a>

</body>
</html>