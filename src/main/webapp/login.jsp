<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodHub | Login</title>

<style>

*{
	margin:0;
	padding:0;
	box-sizing:border-box;
	font-family:'Segoe UI',sans-serif;
}

body{
	background:#F8F8F8;
	display:flex;
	justify-content:center;
	align-items:center;
	height:100vh;
}

.login-box{
	width:420px;
	background:white;
	padding:40px;
	border-radius:15px;
	box-shadow:0 8px 20px rgba(0,0,0,.1);
}

.logo{
	text-align:center;
	font-size:40px;
	font-weight:bold;
	color:#FC8019;
	margin-bottom:10px;
}

.tagline{
	text-align:center;
	color:#666;
	margin-bottom:30px;
	font-size:15px;
}

label{
	display:block;
	font-weight:600;
	color:#333;
	margin-bottom:8px;
}

input{
	width:100%;
	padding:13px;
	margin-bottom:20px;
	border:1px solid #ddd;
	border-radius:8px;
	font-size:15px;
}

input:focus{
	outline:none;
	border:2px solid #FC8019;
}

button{
	width:100%;
	padding:14px;
	background:#FC8019;
	color:white;
	border:none;
	border-radius:8px;
	font-size:17px;
	font-weight:bold;
	cursor:pointer;
	transition:.3s;
}

button:hover{
	background:#E76F00;
}

.signup{
	text-align:center;
	margin-top:20px;
}

.signup a{
	color:#FC8019;
	text-decoration:none;
	font-weight:bold;
}

.signup a:hover{
	text-decoration:underline;
}

.footer{
	text-align:center;
	margin-top:20px;
	font-size:13px;
	color:#777;
}

</style>

</head>

<body>

<div class="login-box">

<div class="logo">
🍔 FoodHub
</div>

<div class="tagline">
Order your favourite food anytime, anywhere
</div>

<form action="login" method="post">

<label>Email</label>

<input
type="email"
name="email"
placeholder="Enter your email"
required>

<label>Password</label>

<input
type="password"
name="password"
placeholder="Enter your password"
required>

<button type="submit">
Login
</button>

</form>

<div class="signup">
New User?
<a href="signup.jsp">Create Account</a>
</div>

<div class="footer">
© 2026 FoodHub
</div>

</div>

</body>
</html>