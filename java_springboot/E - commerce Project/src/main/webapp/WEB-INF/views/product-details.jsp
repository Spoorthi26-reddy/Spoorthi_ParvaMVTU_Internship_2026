<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="com.hidrip.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Product Details</title>



<!-- GLOBAL CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- PAGE CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/product-details.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>



<body>



<!-- ========================================= -->
<!-- NAVBAR -->
<!-- ========================================= -->

<jsp:include page="partials/navbar.jsp" />



<%
Product product =
(Product) request.getAttribute("product");

double originalPrice =
        product.getPrice();

double finalPrice =
        originalPrice -
        (originalPrice *
        product.getDiscountPercent() / 100);
%>





<!-- ========================================= -->
<!-- PRODUCT DETAILS -->
<!-- ========================================= -->

<section class="product-details-section">

<div class="container details-container">



    <!-- ========================================= -->
    <!-- LEFT : PRODUCT IMAGES -->
    <!-- ========================================= -->

    <div class="product-gallery">


        <!-- MAIN IMAGE -->

        <div class="main-image">

            <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>"

                 alt="<%= product.getProductName() %>">

        </div>



        <!-- THUMBNAILS -->

        <div class="thumbnail-images">

            <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>">

            <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>">

            <img src="${pageContext.request.contextPath}/<%= product.getImageUrl() %>">

        </div>

    </div>





    <!-- ========================================= -->
    <!-- RIGHT : PRODUCT INFO -->
    <!-- ========================================= -->

    <div class="product-info-section">



        <!-- BRAND -->

        <p class="product-brand">

            <%= product.getBrand() %>

        </p>



        <!-- PRODUCT TITLE -->

        <h1>

            <%= product.getProductName() %>

        </h1>



        <!-- RATING -->

        <div class="rating">

            <i class="fa-solid fa-star"></i>
            <i class="fa-solid fa-star"></i>
            <i class="fa-solid fa-star"></i>
            <i class="fa-solid fa-star"></i>
            <i class="fa-regular fa-star"></i>

            <span>4.0 Ratings</span>

        </div>



        <!-- DESCRIPTION -->

        <p class="product-description">

            <%= product.getDescription() %>

        </p>





        <!-- PRICE SECTION -->

        <div class="price-section">

            <span class="final-price">

                ₹<%= (int)finalPrice %>

            </span>

            <span class="original-price">

                ₹<%= (int)originalPrice %>

            </span>

            <span class="discount-percent">

                <%= (int)product.getDiscountPercent() %>% OFF

            </span>

        </div>





        <!-- SIZE SECTION -->

        <div class="size-section">

            <h3>Select Size</h3>

            <div class="sizes">

                <button>S</button>
                <button>M</button>
                <button>L</button>
                <button>XL</button>

            </div>

        </div>





        <!-- QUANTITY -->

        <div class="quantity-section">

            <h3>Quantity</h3>

            <input type="number"
                   value="1"
                   min="1">

        </div>





        <!-- DELIVERY -->

        <div class="delivery-info">

            <i class="fa-solid fa-truck"></i>

            Free Delivery Available

        </div>





        <!-- BUTTONS -->

        <div class="details-buttons">

            <button class="primary-btn">

                Add To Cart

            </button>


<form action="${pageContext.request.contextPath}/wishlist"
      method="post">

    <input type="hidden"
           name="productId"
           value="<%= product.getProductId() %>">

    <button type="submit"
            class="wishlist-btn">

        <i class="fa-regular fa-heart"></i>

    </button>

</form>

        </div>

    </div>

</div>

</section>





<!-- ========================================= -->
<!-- FOOTER -->
<!-- ========================================= -->

<jsp:include page="partials/footer.jsp" />



</body>
</html>