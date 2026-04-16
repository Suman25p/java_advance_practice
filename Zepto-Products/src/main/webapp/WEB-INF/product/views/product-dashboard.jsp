<html>
<head>
<style>

body {
    font-family: Arial, sans-serif;
    background: linear-gradient(to right, #667eea, #764ba2);
    margin: 0;
    padding: 0;
}

.container {
    width: 60%;
    margin: 30px auto;
    background: white;
    padding: 25px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0,0,0,0.2);
}

h2 {
    text-align: center;
    color: #333;
}

h3 {
    color: #555;
    border-bottom: 2px solid #eee;
    padding-bottom: 5px;
}

input[type="text"] {
    width: 95%;
    padding: 10px;
    margin-top: 5px;
    margin-bottom: 10px;
    border-radius: 6px;
    border: 1px solid #ccc;
}

button, input[type="submit"] {
    padding: 10px 15px;
    border: none;
    border-radius: 6px;
    color: white;
    cursor: pointer;
    margin-top: 5px;
}

.add-btn {
    background-color: #28a745;
}

.view-btn {
    background-color: #007bff;
}

.update-btn {
    background-color: #ffc107;
    color: black;
}

.delete-btn {
    background-color: #dc3545;
}

.section {
    margin-bottom: 25px;
}

a button {
    text-decoration: none;
}

</style>
</head>

<body>

<div class="container">

<h2>Product Dashboard</h2>

<!-- CREATE PRODUCT -->
<div class="section">
<h3>Add Product</h3>
<form action="uploadProduct" method="post">
    Name:
    <input type="text" name="productName">

    Quantity:
    <input type="text" name="qty">

    Description:
    <input type="text" name="description">

    Price:
    <input type="text" name="price">

    Sold By:
    <input type="text" name="soldBy">

    <input type="submit" value="Add Product" class="add-btn">
</form>
</div>

<!-- VIEW ALL -->
<div class="section">
<h3>All Products</h3>
<a href="getAllProducts">
    <button class="view-btn">View All Products</button>
</a>
</div>

<!-- CHECK STATUS -->
<div class="section">
<h3>Check Product Status</h3>
<form action="checkProductStatus" method="get">
    Product ID:
    <input type="text" name="productId">
    <input type="submit" value="Check Status" class="view-btn">
</form>
</div>

<!-- UPDATE -->
<div class="section">
<h3>Update Product</h3>
<form action="updateStatus" method="get">
    Product ID:
    <input type="text" name="productId">

    New Status:
    <input type="text" name="status">

    <input type="submit" value="Update" class="update-btn">
</form>
</div>

<!--  DELETE -->
<div class="section">
<h3>Delete Product</h3>
<form action="deleteProduct" method="get">
    Product ID:
    <input type="text" name="productId">
    <input type="submit" value="Delete" class="delete-btn">
</form>
</div>

</div>

</body>
</html>