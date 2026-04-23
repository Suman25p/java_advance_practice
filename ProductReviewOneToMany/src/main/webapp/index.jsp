<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Review App</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #6a11cb, #2575fc);
            margin: 0;
            padding: 0;
        }

        .container {
            width: 420px;
            margin: 80px auto;
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 8px;
            border: 1px solid #ccc;
            outline: none;
        }

        input:focus {
            border-color: #6a11cb;
        }

        .btn {
            margin-top: 20px;
            width: 100%;
            padding: 12px;
            background: linear-gradient(to right, #ff416c, #ff4b2b);
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
        }

        .btn:hover {
            opacity: 0.9;
        }

        .footer {
            text-align: center;
            margin-top: 15px;
            color: #666;
            font-size: 13px;
        }
    </style>
</head>

<body>

<div class="container">
    <h2>🛒 Add Product</h2>

    <form action="saveProduct" method="post">

        <label>Product Name</label>
        <input type="text" name="name" placeholder="Enter product name" required>

        <label>Review 1</label>
        <input type="text" name="comments" placeholder="Enter review">

        <label>Review 2</label>
        <input type="text" name="comments" placeholder="Enter review">

        <label>Review 3</label>
        <input type="text" name="comments" placeholder="Enter review">

        <button type="submit" class="btn">Save Product</button>
    </form>

    <div class="footer">
        Product Review System 💙
    </div>
</div>

</body>
</html>
