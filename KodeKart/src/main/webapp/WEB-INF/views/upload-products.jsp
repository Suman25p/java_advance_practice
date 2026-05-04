<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%>

<h3>Upload CSV</h3>

<form action="uploadCSV" method="post" enctype="multipart/form-data">
    <input type="file" name="file" required/>
    <button type="submit">Upload</button>
</form>

<br>
<a href="admin/products">Back to Admin</a>