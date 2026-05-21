<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.CartItem" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - Cart</title>



<!-- ========================================= -->
<!-- GLOBAL CSS -->
<!-- ========================================= -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- ========================================= -->
<!-- PAGE CSS -->
<!-- ========================================= -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/cart.css">



<!-- ========================================= -->
<!-- FONT AWESOME -->
<!-- ========================================= -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>



<body>



<!-- ========================================= -->
<!-- NAVBAR -->
<!-- ========================================= -->

<jsp:include page="partials/navbar.jsp" />





<!-- ========================================= -->
<!-- CART SECTION -->
<!-- ========================================= -->

<section class="cart-section">

<div class="container">



<h1 class="cart-title">

    Shopping Cart

</h1>





<%
List<CartItem> cartItems =
(List<CartItem>)
request.getAttribute("cartItems");



Double totalAmount =
(Double)
request.getAttribute("cartTotal");



if(totalAmount == null){

    totalAmount = 0.0;
}
%>





<%
if(cartItems == null || cartItems.isEmpty()){
%>



<!-- ========================================= -->
<!-- EMPTY CART -->
<!-- ========================================= -->

<div class="empty-cart">

    <i class="fa-solid fa-cart-shopping"></i>

    <h2>Your Cart is Empty</h2>

    <p>

        Add some amazing products to your cart.

    </p>

    <a href="${pageContext.request.contextPath}/products"
       class="primary-btn">

        Continue Shopping

    </a>

</div>



<%
}
else{
%>





<!-- ========================================= -->
<!-- CART CONTAINER -->
<!-- ========================================= -->

<div class="cart-container">





<!-- ========================================= -->
<!-- CART ITEMS -->
<!-- ========================================= -->

<div class="cart-items">


<%
for(CartItem item : cartItems){

    double total =
            item.getTotalPrice();
%>





<!-- ========================================= -->
<!-- CART CARD -->
<!-- ========================================= -->

<div class="cart-card">



    <!-- PRODUCT IMAGE -->

    <div class="cart-image">

        <img src="${pageContext.request.contextPath}/<%= item.getProduct().getImageUrl() %>"

             alt="Product Image">

    </div>





    <!-- PRODUCT INFO -->

    <div class="cart-info">



        <!-- BRAND -->

        <p class="cart-brand">

            <%= item.getProduct().getBrand() %>

        </p>





        <!-- PRODUCT TITLE -->

        <h2>

            <%= item.getProduct().getProductName() %>

        </h2>





        <!-- PRICE -->

        <p class="cart-price">

            ₹<%= (int)total %>

        </p>





        <!-- QUANTITY CONTROLS -->

        <div class="quantity-controls">



            <!-- DECREASE -->

            <a href="${pageContext.request.contextPath}/cart?action=decrease&cartItemId=<%= item.getCartItemId() %>"

               class="qty-btn">

                -

            </a>





            <!-- QUANTITY -->

            <span class="qty-value">

                <%= item.getQuantity() %>

            </span>





            <!-- INCREASE -->

            <a href="${pageContext.request.contextPath}/cart?action=increase&cartItemId=<%= item.getCartItemId() %>"

               class="qty-btn">

                +

            </a>

        </div>

    </div>





    <!-- REMOVE -->

    <div class="cart-remove">

        <a href="${pageContext.request.contextPath}/cart?action=remove&cartItemId=<%= item.getCartItemId() %>">

            <button>

                <i class="fa-solid fa-trash"></i>

            </button>

        </a>

    </div>

</div>


<%
}
%>

</div>





<!-- ========================================= -->
<!-- ORDER SUMMARY -->
<!-- ========================================= -->

<div class="cart-summary">



    <h2>Order Summary</h2>





    <div class="summary-row">

        <span>Total Items</span>

        <span>

            <%= cartItems.size() %>

        </span>

    </div>





    <div class="summary-row">

        <span>Delivery</span>

        <span>

            Free

        </span>

    </div>





    <hr>





    <div class="summary-row total-row">

        <span>Total</span>

        <span>

            ₹<%= totalAmount.intValue() %>

        </span>

    </div>




<a href="${pageContext.request.contextPath}/checkout"
   class="checkout-btn">

    Proceed To Checkout

</a>

</div>

</div>

<%
}
%>

</div>

</section>





<!-- ========================================= -->
<!-- FOOTER -->
<!-- ========================================= -->

<jsp:include page="partials/footer.jsp" />



</body>
</html>