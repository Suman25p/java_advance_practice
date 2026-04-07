<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zepto - Product Reseller</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #56ab2f, #a8e063);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: white;
        padding: 30px 40px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        width: 350px;
    }

    h2 {
        text-align: center;
        color: #2e7d32;
        margin-bottom: 20px;
    }

    label {
        font-weight: 600;
        display: block;
        margin-top: 10px;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        border: 1px solid #ccc;
        border-radius: 6px;
        outline: none;
        transition: 0.3s;
    }

    input[type="text"]:focus {
        border-color: #4caf50;
        box-shadow: 0 0 5px rgba(76, 175, 80, 0.5);
    }

    .btn {
        width: 100%;
        margin-top: 20px;
        padding: 12px;
        background: #4caf50;
        color: white;
        border: none;
        border-radius: 6px;
        font-size: 16px;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {
        background: #388e3c;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Zepto - Product Reseller</h2>

    <form action="uploadProduct" method="post">

        <label>Product Name</label>
        <input type="text" name="name" placeholder="Enter product name">

        <label>Product Quantity</label>
        <input type="text" name="qty" placeholder="Enter quantity">

        <label>Product Description</label>
        <input type="text" name="description" placeholder="Enter description">

        <label>Product Price</label>
        <input type="text" name="price" placeholder="Enter price">

        <label>Sold By</label>
        <input type="text" name="soldby" placeholder="Seller name">

        <input type="submit" value="Upload Product" class="btn">

    </form>
</div>

</body>
</html>