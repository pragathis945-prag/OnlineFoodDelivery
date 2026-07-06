<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodHub | Checkout</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Segoe UI',sans-serif;
}

body{
background:#F8F8F8;
}

.navbar{
background:#FC8019;
padding:18px 60px;
display:flex;
justify-content:space-between;
align-items:center;
}

.logo{
color:white;
font-size:30px;
font-weight:bold;
}

.links a{
color:white;
text-decoration:none;
margin-left:25px;
font-weight:bold;
}

.container{
width:550px;
margin:50px auto;
background:white;
padding:35px;
border-radius:18px;
box-shadow:0 8px 20px rgba(0,0,0,.12);
}

h2{
text-align:center;
color:#282C3F;
margin-bottom:30px;
font-size:34px;
}

label{
display:block;
margin-bottom:8px;
font-weight:bold;
color:#444;
}

textarea,
select{
width:100%;
padding:14px;
border:2px solid #ddd;
border-radius:10px;
font-size:16px;
margin-bottom:20px;
outline:none;
}

textarea:focus,
select:focus{
border-color:#FC8019;
}

button{
width:100%;
padding:15px;
background:#FC8019;
color:white;
border:none;
border-radius:10px;
font-size:18px;
font-weight:bold;
cursor:pointer;
transition:.3s;
}

button:hover{
background:#E46D00;
}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">
🍔 FoodHub
</div>

<div class="links">
<a href="restaurants">Home</a>
<a href="cart">Cart</a>
</div>

</div>

<div class="container">

<h2>💳 Checkout</h2>

<form action="checkout" method="post">


<label>📍 Delivery Address</label>

<textarea
name="deliveryAddress"
rows="4"
placeholder="Enter your complete delivery address"
required></textarea>

<label>💳 Payment Method</label>

<select name="paymentMethod" required>

<option value="">-- Select Payment Method --</option>

<option value="Cash on Delivery">
💵 Cash on Delivery
</option>

<option value="UPI">
📱 UPI
</option>

<option value="Credit Card">
💳 Credit Card
</option>

<option value="Debit Card">
💳 Debit Card
</option>

</select>

<button type="submit">

🛒 Place Order

</button>

</form>

</div>

</body>
</html>