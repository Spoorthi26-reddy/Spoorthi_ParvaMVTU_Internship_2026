<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - Home</title>



<!-- GLOBAL CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- HOME CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/home.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>



<body>


<!-- ========================= -->
<!-- SHARED NAVBAR -->
<!-- ========================= -->

<jsp:include page="partials/navbar.jsp" />



<!-- ========================= -->
<!-- HERO SECTION -->
<!-- ========================= -->

<section class="home-hero">

    <div class="hero-content">

        <h1>

            Discover Modern Fashion

        </h1>

        <p>

            Explore premium fashion collections
            for Men, Women, Kids and Accessories.

        </p>

        <div class="hero-buttons">

            <a href="${pageContext.request.contextPath}/products"
               class="primary-btn">

                Shop Now

            </a>

            <a href="#featured-products"
               class="secondary-btn">

                Explore

            </a>

        </div>

    </div>

</section>




<!-- ========================= -->
<!-- FEATURED PRODUCTS -->
<!-- ========================= -->

<section class="featured-section"
         id="featured-products">

    <div class="container">

        <h2 class="section-title">

            Featured Products

        </h2>


        <div class="featured-grid">


<%
List<Product> products =
(List<Product>) request.getAttribute("products");

int count = 0;

for(Product p : products){

    if(count == 8){
        break;
    }

    count++;
%>


<div class="featured-card">

    <img src="<%= p.getImageUrl() %>"
         alt="Product Image">

    <div class="featured-info">

        <h3>

            <%= p.getProductName() %>

        </h3>

        <p>

            <%= p.getDescription() %>

        </p>

        <span class="discount-badge">

            <%= p.getDiscountPercent() %>% OFF

        </span>

    </div>

</div>


<%
}
%>

        </div>

    </div>

</section>




<!-- ========================= -->
<!-- SHARED FOOTER -->
<!-- ========================= -->

<jsp:include page="partials/footer.jsp" />



</body>
</html>