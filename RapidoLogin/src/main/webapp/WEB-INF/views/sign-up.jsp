<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rapido Sign-Up</title>

<style>
    body {
        margin: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(to right, #4facfe, #00f2fe);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: white;
        padding: 30px 40px;
        border-radius: 15px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        width: 350px;
    }

    .logo {
        text-align: center;
        font-size: 26px;
        font-weight: bold;
        color: #0077b6;
        margin-bottom: 10px;
    }

    h2 {
        text-align: center;
        margin-bottom: 20px;
        color: #333;
    }

    .form-group {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-size: 14px;
        margin-bottom: 5px;
        color: #555;
    }

    input {
        width: 100%;
        padding: 10px;
        border-radius: 8px;
        border: 1px solid #ccc;
        outline: none;
        transition: 0.3s;
    }

    input:focus {
        border-color: #0077b6;
        box-shadow: 0 0 5px rgba(0,119,182,0.5);
    }

    .btn {
        width: 100%;
        padding: 12px;
        background: #0077b6;
        color: white;
        border: none;
        border-radius: 25px;
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
    }

    .btn:hover {
        background: #023e8a;
        transform: scale(1.03);
    }
</style>

</head>
<body>

<div class="container">
    <div class="logo">Rapido 🚀</div>
    <h2>Sign-Up</h2>

    <form action="signup">
        
        <div class="form-group">
            <label>Mobile</label>
            <input type="text" name="mobile" placeholder="Enter mobile number">
        </div>

        <div class="form-group">
            <label>Email</label>
            <input type="text" name="email" placeholder="Enter email">
        </div>

        <div class="form-group">
            <label>Location</label>
            <input type="text" name="location" placeholder="Enter location">
        </div>

        <div class="form-group">
            <label>OTP</label>
            <input type="text" name="otp" placeholder="Enter OTP">
        </div>

        <button type="submit" class="btn">Sign-Up</button>
    </form>
</div>

</body>
</html>