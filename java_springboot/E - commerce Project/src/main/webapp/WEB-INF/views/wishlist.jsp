<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.hidrip.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - Wishlist</title>



<!-- GLOBAL CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- PAGE CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/wishlist.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>



<!-- NAVBAR -->

<jsp:include page="partials/navbar.jsp" />





<!-- WISHLIST SECTION -->

<section class="wishlist-section">

<div class="container">



<%
List<Product> wishlistProducts =
(List<Product>)
request.getAttribute(
        "wishlistProducts");



if(wishlistProducts == null){

    wishlistProducts =
    Collections.emptyList();
}
%>





<!-- TITLE -->

<h1 class="wishlist-title">

    My Wishlist

</h1>





<%
if(wishlistProducts.isEmpty()){
%>



<!-- EMPTY -->

<div class="empty-wishlist">

    <i class="fa-regular fa-heart"></i>

    <h2>

        Your Wishlist is Empty

    </h2>

    <p>

        Save your favorite products here.

    </p>



    <a href="${pageContext.request.contextPath}/products"
       class="shop-btn">

        Explore Products

    </a>

</div>



<%
}
else{
%>





<!-- PRODUCTS GRID -->

<div class="wishlist-grid">


<%
for(Product p : wishlistProducts){

    double originalPrice =
            p.getPrice();



    double finalPrice =
            originalPrice -
            (originalPrice *
            p.getDiscountPercent()
            / 100);
%>





<!-- PRODUCT CARD -->

<div class="wishlist-card">



    <!-- REMOVE -->

    <a href="${pageContext.request.contextPath}/wishlist?action=remove&productId=<%= p.getProductId() %>"
       class="remove-btn">

        <i class="fa-solid fa-xmark"></i>

    </a>





    <!-- IMAGE -->

    <a href="${pageContext.request.contextPath}/product-details?id=<%= p.getProductId() %>"
       class="wishlist-link">

        <div class="wishlist-image-wrapper">

            <img src="${pageContext.request.contextPath}/<%= p.getImageUrl() %>"
                 class="wishlist-image"
                 alt="Product">

        </div>

    </a>





    <!-- INFO -->

    <div class="wishlist-info">



        <p class="wishlist-brand">

            <%= p.getBrand() %>

        </p>





        <a href="${pageContext.request.contextPath}/product-details?id=<%= p.getProductId() %>"
           class="wishlist-link">

            <h2 class="wishlist-product-title">

                <%= p.getProductName() %>

            </h2>

        </a>





        <p class="wishlist-desc">

            <%= p.getDescription() %>

        </p>





        <!-- PRICE -->

        <div class="wishlist-price-section">

            <span class="wishlist-final-price">

                ₹<%= (int)finalPrice %>

            </span>



            <span class="wishlist-original-price">

                ₹<%= (int)originalPrice %>

            </span>

        </div>





        <!-- ADD TO CART -->

        <form action="${pageContext.request.contextPath}/cart"
              method="post">

            <input type="hidden"
                   name="productId"
                   value="<%= p.getProductId() %>">

            <button type="submit"
                    class="wishlist-cart-btn">

                Add To Cart

            </button>

        </form>

    </div>

</div>

<%
}
%>

</div>

<%
}
%>

</div>

</section>





<!-- FOOTER -->

<jsp:include page="partials/footer.jsp" />



</body>
</html>