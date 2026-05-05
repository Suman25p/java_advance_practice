<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload CSV</title>

<style>
    body { font-family: Arial; margin: 40px; }
    h3 { text-align: center; }

    form {
        text-align: center;
        margin-top: 20px;
    }

    input, button {
        padding: 8px;
        margin: 10px;
    }

    .back {
        display: block;
        text-align: center;
        margin-top: 20px;
        text-decoration: none;
    }
</style>

</head>
<body>

<h3>Upload Products (CSV)</h3>

<!-- ✅ Error message -->
<c:if test="${not empty error}">
    <p style="color:red; text-align:center;">${error}</p>
</c:if>

<!-- ✅ Success message -->
<c:if test="${not empty msg}">
    <p style="color:green; text-align:center;">${msg}</p>
</c:if>

<form action="${pageContext.request.contextPath}/admin/uploadCSV"
      method="post"
      enctype="multipart/form-data">

    <!-- 🔥 CSV only -->
    <input type="file" name="file" accept=".csv" required/>

    <br>

    <button type="submit">Upload</button>
</form>

<br>

<a class="back" href="${pageContext.request.contextPath}/admin/products">
    Back to Admin
</a>

</body>
</html>