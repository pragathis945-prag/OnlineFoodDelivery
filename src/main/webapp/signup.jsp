<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodHub | Signup</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:'Segoe UI',sans-serif;
}

body{
	background:#EEF6FF;
	display:flex;
	justify-content:center;
	align-items:center;
	min-height:100vh;
	padding:20px;
}

.signup-box{
	width:450px;
	background:white;
	padding:35px;
	border-radius:20px;
	box-shadow:0 10px 30px rgba(0,0,0,0.15);
}

.logo{
	text-align:center;
	font-size:38px;
	font-weight:bold;
	color:#2563EB;
	margin-bottom:8px;
}

.tagline{
	text-align:center;
	color:#666;
	margin-bottom:25px;
	font-size:15px;
}

label{
	font-size:15px;
	font-weight:600;
	color:#333;
	display:block;
	margin-top:12px;
}

input{
	width:100%;
	padding:13px;
	margin-top:8px;
	border:1px solid #ccc;
	border-radius:10px;
	font-size:15px;
}

input:focus{
	outline:none;
	border:2px solid #3B82F6;
}

button{
	width:100%;
	padding:14px;
	margin-top:25px;
	background:#3B82F6;
	color:white;
	border:none;
	border-radius:10px;
	font-size:17px;
	font-weight:bold;
	cursor:pointer;
	transition:.3s;
}

button:hover{
	background:#2563EB;
}

.login{
	text-align:center;
	margin-top:20px;
}

.login a{
	color:#2563EB;
	text-decoration:none;
	font-weight:bold;
}

.login a:hover{
	text-decoration:underline;
}

.footer{
	text-align:center;
	margin-top:20px;
	color:#888;
	font-size:13px;
}

</style>

</head>

<body>

<div class="signup-box">

<div class="logo">
🍔 FoodHub
</div>

<div class="tagline">
Create Your FoodHub Account
</div>

<form action="signup" method="post">

<label>Full Name</label>
<input type="text"
name="name"
placeholder="Enter your full name"
required>

<label>Email Address</label>
<input type="email"
name="email"
placeholder="Enter your email"
required>

<label>Phone Number</label>
<input type="text"
name="phone"
placeholder="Enter your phone number"
required>

<label>Password</label>
<input type="password"
name="password"
placeholder="Create a password"
required>

<label>Address</label>
<input type="text"
name="address"
placeholder="Enter your address"
required>

<button type="submit">
Create Account
</button>

</form>

<div class="login">
Already have an account?
<a href="login.jsp">Login</a>
</div>

<div class="footer">
© 2026 FoodHub | Online Food Delivery
</div>

</div>

</body>
</html>