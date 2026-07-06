<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.Cart"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FoodHub | My Cart</title>

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
    color:white;
    font-size:30px;
    font-weight:bold;
}

.links a{
    color:white;
    text-decoration:none;
    margin-left:25px;
    font-size:17px;
    font-weight:bold;
}

.links a:hover{
    color:#FFE6CC;
}

.container{
    width:85%;
    margin:40px auto;
    background:white;
    padding:30px;
    border-radius:18px;
    box-shadow:0 6px 15px rgba(0,0,0,.10);
}

h2{
    text-align:center;
    color:#282C3F;
    margin-bottom:25px;
}

table{
    width:100%;
    border-collapse:collapse;
}

th{
    background:#FC8019;
    color:white;
    padding:15px;
}

td{
    padding:15px;
    text-align:center;
    border-bottom:1px solid #eee;
}

input[type=number]{
    width:70px;
    padding:8px;
    border:1px solid #ccc;
    border-radius:6px;
}

.update{
    background:#28A745;
    color:white;
    border:none;
    padding:10px 18px;
    border-radius:8px;
    cursor:pointer;
}

.delete{
    background:#DC3545;
    color:white;
    border:none;
    padding:10px 18px;
    border-radius:8px;
    cursor:pointer;
}

.update:hover{
    background:#218838;
}

.delete:hover{
    background:#C82333;
}

.total-box{
    width:320px;
    margin:30px auto;
    background:#FFF3E6;
    border:2px solid #FC8019;
    padding:18px;
    border-radius:12px;
    text-align:center;
    font-size:24px;
    font-weight:bold;
}

.buttons{
    display:flex;
    justify-content:center;
    gap:25px;
    margin-top:30px;
}

.continue,
.checkout{

    color:white;
    border:none;
    padding:14px 28px;
    border-radius:8px;
    cursor:pointer;
    font-size:16px;
    font-weight:bold;

}

.continue{
    background:#28A745;
}

.checkout{
    background:#FC8019;
}

.continue:hover{
    background:#218838;
}

.checkout:hover{
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

<h2>🛒 My Shopping Cart</h2>

<table>

<tr>

<th>Item</th>
<th>Price</th>
<th>Quantity</th>
<th>Subtotal</th>
<th>Update</th>
<th>Delete</th>

</tr>

<%

List<Cart> cartList=(List<Cart>)request.getAttribute("cartList");

double grandTotal=0;

if(cartList!=null){

for(Cart cart:cartList){

grandTotal+=cart.getSubtotal();

%>

<tr>

<td><%=cart.getItem_name()%></td>

<td>₹ <%=cart.getPrice()%></td>

<td>

<form action="updateCart" method="post">

<input type="hidden"
name="cartId"
value="<%=cart.getCart_id()%>">

<input type="number"
name="quantity"
value="<%=cart.getQuantity()%>"
min="1">

</td>

</form>

</td>

<td>

₹ <%=cart.getSubtotal()%>

</td>

<td>

<button
type="submit"
class="update">

Update

</button>

</td>

<td>

<a href="deleteCart?cartId=<%=cart.getCart_id()%>">

<button
type="button"
class="delete">

Delete

</button>

</a>

</td>

</tr>

<%

}

}else{

%>

<tr>

<td colspan="6"
style="padding:40px;
text-align:center;
font-size:22px;
color:#777;">

🛒 Your Cart is Empty

</td>

</tr>

<%

}

%>

</table>

<div class="total-box">

Grand Total : ₹ <%=grandTotal%>

</div>

<div class="buttons">

<button
type="button"
class="continue"
onclick="location.href='restaurants'">

🛍 Continue Shopping

</button>

<form
action="checkout.jsp"
method="get">

<button
type="submit"
class="checkout">

💳 Proceed To Checkout

</button>

</form>

</div>

</div>

</body>
</html>