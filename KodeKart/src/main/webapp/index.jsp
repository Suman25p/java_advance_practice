<!DOCTYPE html>
<html>
<head>
    <title>E-Commerce Home</title>
    <style>
        body { font-family: Arial; background-color: #f4f4f4; margin: 0; }
        header { background: #2c3e50; color: white; padding: 15px; text-align: center; }
        nav { background: #34495e; padding: 10px; text-align: center; }
        nav a {
            color: white;
            margin: 10px;
            text-decoration: none;
            font-weight: bold;
        }
        nav a:hover { color: yellow; }
        .container { padding: 20px; }
        .card {
            background: white;
            padding: 20px;
            margin: 15px;
            display: inline-block;
            width: 250px;
            text-align: center;
            box-shadow: 2px 2px 10px gray;
        }
        button {
            padding: 10px;
            background: #27ae60;
            color: white;
            border: none;
            cursor: pointer;
        }
        footer {
            background: #2c3e50;
            color: white;
            text-align: center;
            padding: 10px;
            margin-top: 20px;
        }
    </style>
</head>

<body>

<header>
    <h1>E-Commerce Management System</h1>
</header>

<nav>
    <a href="login">Login</a>
    <a href="register">Register</a>
    <a href="products">Products</a>
    <a href="cart">Cart</a>
    <a href="orders">Orders</a>
    <a href="admin/products">Admin</a>
</nav>

<div class="container">
    <h2>Welcome</h2>
    <p>This system allows users to shop products and place orders.</p>

    <div class="card">
        <h3>Products</h3>
        <button onclick="location.href='products'">View</button>
    </div>

    <div class="card">
        <h3>Cart</h3>
        <button onclick="location.href='cart'">Go</button>
    </div>

    <div class="card">
        <h3>Orders</h3>
        <button onclick="location.href='orders'">View</button>
    </div>
</div>

<footer>
    <p>Developed by You</p>
</footer>

</body>
</html>