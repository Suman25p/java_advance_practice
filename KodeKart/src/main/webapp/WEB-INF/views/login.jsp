<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login</h2>

<form action="doLogin" method="post">
    Email: <input type="text" name="email"/><br><br>
    Password: <input type="password" name="password"/><br><br>
    <button type="submit">Login</button>
</form>

<p style="color:red">${error}</p>
</body>
</html>