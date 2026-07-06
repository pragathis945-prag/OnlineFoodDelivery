<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Menu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodHub | Restaurant Menu</title>

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
display:flex;
justify-content:space-between;
align-items:center;
padding:18px 60px;
box-shadow:0 3px 10px rgba(0,0,0,.15);
}

.logo{
font-size:32px;
font-weight:bold;
color:white;
}

.links a{
color:white;
text-decoration:none;
margin-left:25px;
font-weight:bold;
font-size:17px;
}

.container{
width:90%;
margin:35px auto;
}

.heading{
font-size:35px;
color:#282C3F;
margin-bottom:30px;
}

.grid{
display:grid;
grid-template-columns:repeat(auto-fit,minmax(340px,1fr));
gap:30px;
}

.card{
background:white;
border-radius:18px;
overflow:hidden;
box-shadow:0 4px 12px rgba(0,0,0,.10);
transition:.3s;
}

.card:hover{
transform:translateY(-5px);
box-shadow:0 10px 20px rgba(0,0,0,.15);
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
padding:20px;
}

.content h3{
font-size:28px;
color:#282C3F;
margin-bottom:10px;
}

.desc{
color:#666;
margin-bottom:12px;
}

.price{
display:inline-block;
background:#48C479;
color:white;
padding:6px 14px;
border-radius:20px;
font-weight:bold;
margin-top:10px;
}

.available{
color:#28A745;
font-weight:bold;
margin-top:15px;
}

.notavailable{
color:red;
font-weight:bold;
margin-top:15px;
}

.qty{
margin-top:18px;
font-weight:bold;
}

input[type=number]{
width:90px;
padding:8px;
margin-top:8px;
border:1px solid #ccc;
border-radius:6px;
}

button{
width:100%;
padding:13px;
margin-top:20px;
background:#FC8019;
color:white;
border:none;
border-radius:8px;
font-size:16px;
font-weight:bold;
cursor:pointer;
}

button:hover{
background:#E76F00;
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

<h2 class="heading">🍽 Restaurant Menu</h2>

<%

List<Menu> menuList=(List<Menu>)request.getAttribute("menuList");

if(menuList!=null){

%>

<div class="grid">

<%

for(Menu menu:menuList){

%>

<div class="card">

<img src="images/menu/<%=menu.getImage_url()%>">

<div class="content">

<h3><%=menu.getItem_name()%></h3>

<p class="desc">
<%=menu.getDescription()%>
</p>

<p>
<b>Category :</b>
<%=menu.getCategory()%>
</p>

<div class="price">
₹ <%=menu.getPrice()%>
</div>

<%

if(menu.isIs_available()){

%>

<p class="available">

✅ Available

</p>

<%

}else{

%>

<p class="notavailable">

❌ Not Available

</p>

<%

}

%>

<form action="cart" method="post">

<div class="qty">

Quantity

<br><br>

<input
type="number"
name="quantity"
value="1"
min="1">

</div>

<input
type="hidden"
name="menuId"
value="<%=menu.getMenu_id()%>">

<button type="submit">

🛒 Add To Cart

</button>

</form>

</div>

</div>

<%

}

%>

</div>

<%

}else{

%>

<h2 style="text-align:center;color:gray;">

No Menu Items Available

</h2>

<%

}

%>

</div>

</body>
</html>