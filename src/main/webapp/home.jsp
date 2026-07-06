<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.foodapp.model.User"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Restaurant"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodHub | Home</title>

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
box-shadow:0 3px 10px rgba(0,0,0,.12);
}

.logo{
font-size:32px;
font-weight:bold;
color:white;
}

.menu a{
color:white;
text-decoration:none;
margin-left:30px;
font-size:17px;
font-weight:600;
}

.menu a:hover{
color:#FFE7D1;
}

.header{
width:90%;
margin:35px auto;
}

.header h2{
font-size:35px;
color:#282C3F;
margin-bottom:10px;
}

.header p{
color:#666;
font-size:18px;
}

.container{
width:90%;
margin:40px auto;
display:grid;
grid-template-columns:repeat(auto-fit,minmax(330px,1fr));
gap:30px;
}

.card{
background:white;
border-radius:18px;
overflow:hidden;
box-shadow:0 4px 12px rgba(0,0,0,.10);
transition:.3s;
border:1px solid #eee;
}

.card:hover{
transform:translateY(-6px);
box-shadow:0 12px 25px rgba(0,0,0,.15);
}

.card img{
width:100%;
height:220px;
object-fit:cover;
transition:.4s;
}

.card:hover img{
transform:scale(1.05);
}

.content{
padding:22px;
}

.content h3{
font-size:28px;
color:#282C3F;
margin-bottom:12px;
}

.content p{
margin:10px 0;
font-size:16px;
color:#555;
}

.rating{
display:inline-block;
background:#48C479;
padding:6px 14px;
border-radius:20px;
color:white;
font-weight:bold;
margin-top:12px;
}

button{
width:100%;
margin-top:20px;
padding:13px;
background:#FC8019;
border:none;
color:white;
font-size:16px;
font-weight:bold;
border-radius:8px;
cursor:pointer;
transition:.3s;
}

button:hover{
background:#E46D00;
}

</style>

</head>

<body>

<%
User user=(User)session.getAttribute("loggedUser");

if(user==null){
response.sendRedirect("login.jsp");
return;
}

List<Restaurant> restaurantList=
(List<Restaurant>)request.getAttribute("restaurantList");
%>

<div class="navbar">

<div class="logo">
🍔 FoodHub
</div>

<div class="menu">
<a href="restaurants">Home</a>
<a href="cart">Cart</a>
<a href="login.jsp">Logout</a>
</div>

</div>

<div class="header">

<h2>Welcome, <%=user.getName()%> 👋</h2>

<p>Discover delicious food from the best restaurants near you.</p>

</div>

<div class="container">

<%
if(restaurantList!=null){

for(Restaurant restaurant:restaurantList){
%>

<div class="card">

<img src="images/restaurants/<%=restaurant.getImage_path()%>">

<div class="content">

<h3><%=restaurant.getName()%></h3>

<p>🍽️ <b>Cuisine :</b> <%=restaurant.getCuisine_type()%></p>

<p>📍 <b>Address :</b>

<%=restaurant.getAddress()%></p>

<div class="rating">

⭐ <%=restaurant.getRating()%>

</div>

<br><br>

<a href="menu?restaurantId=<%=restaurant.getRestaurant_id()%>">

<button>

View Menu 🍽️

</button>

</a>

</div>

</div>

<%

}

}else{

%>

<h2 style="text-align:center;color:gray;">

No Restaurants Available

</h2>

<%

}

%>

</div>

</body>
</html>