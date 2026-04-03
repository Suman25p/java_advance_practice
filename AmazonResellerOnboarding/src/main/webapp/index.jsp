<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Amazon Seller Onboarding</title>

<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background: linear-gradient(to right, #ffcc00, #ff9900);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background: white;
        padding: 30px;
        border-radius: 10px;
        width: 350px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.2);
    }

    h2 {
        text-align: center;
        color: #333;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-top: 5px;
        margin-bottom: 15px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    input[type="submit"] {
        width: 100%;
        padding: 10px;
        background: #ff9900;
        border: none;
        color: white;
        font-size: 16px;
        border-radius: 5px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background: #e68a00;
    }

    label {
        font-weight: bold;
        font-size: 14px;
    }
</style>

</head>

<body>

<div class="container">
    <h2>Amazon Seller Onboarding</h2>

    <form action="onboarding/101" method="post">
        
        <label>Seller Name</label>
        <input type="text" name="sellerName" placeholder="Enter your name">

        <label>Seller Mobile</label>
        <input type="text" name="sellerMobile" placeholder="Enter mobile number">

        <label>Seller Email</label>
        <input type="text" name="sellerEmail" placeholder="Enter email">

        <label>Seller Type</label>
        <input type="text" name="sellerType" placeholder="Individual / Company">

        <input type="submit" value="Onboard Me ">
    </form>
</div>

</body>
</html>