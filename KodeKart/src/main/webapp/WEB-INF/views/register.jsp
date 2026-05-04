<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>

<h2>User Registration</h2>

<form action="registerUser" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Phone: <input type="text" name="phone"><br><br>
    Password: <input type="password" name="password" required><br><br>

    <button type="submit">Register</button>
</form>

<a href="login">Already have account? Login</a>

</body>
</html>