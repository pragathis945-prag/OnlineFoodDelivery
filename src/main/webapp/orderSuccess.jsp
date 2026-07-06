<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodHub | Order Success</title>

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

.container{
width:550px;
margin:70px auto;
background:white;
padding:40px;
border-radius:20px;
box-shadow:0 8px 20px rgba(0,0,0,.12);
text-align:center;
}

.success{
font-size:80px;
}

h2{
color:#28A745;
margin-top:15px;
font-size:34px;
}

h3{
margin-top:20px;
color:#282C3F;
}

p{
margin-top:15px;
font-size:18px;
color:#666;
}

.button{
display:inline-block;
margin-top:35px;
background:#FC8019;
color:white;
padding:15px 35px;
text-decoration:none;
border-radius:10px;
font-size:18px;
font-weight:bold;
transition:.3s;
}

.button:hover{
background:#E46D00;
}

</style>

</head>

<body>

<div class="navbar">

<div class="logo">
🍔 FoodHub
</div>

</div>

<div class="container">

<div class="success">
✅
</div>

<h2>
Order Placed Successfully!
</h2>

<h3>
Order ID :
<%= request.getAttribute("orderId") %>
</h3>

<p>
Thank you for ordering with <b>FoodHub</b>.
</p>

<p>
Your delicious food is being prepared and will be delivered soon.
</p>

<a href="restaurants" class="button">
🍽 Continue Shopping
</a>

</div>

</body>
</html>