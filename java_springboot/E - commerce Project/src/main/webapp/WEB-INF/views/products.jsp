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

<title>HiDrip - Products</title>





<!-- ========================================= -->
<!-- GLOBAL CSS -->
<!-- ========================================= -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">





<!-- ========================================= -->
<!-- PRODUCTS CSS -->
<!-- ========================================= -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/products.css">





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
<!-- HERO SECTION -->
<!-- ========================================= -->

<section class="hero">

    <div class="hero-overlay"></div>





    <div class="hero-content">

        <span class="hero-badge">

            PREMIUM FASHION COLLECTION

        </span>





        <h1>

            Wear Confidence.
            Wear HiDrip.

        </h1>





        <p>

            Exclusive fashion collections
            designed for modern lifestyles

        </p>





        <div class="hero-buttons">

            <a href="#productsSection"
               class="hero-btn primary-btn">

                Shop Collection

            </a>





            <a href="#"
               class="hero-btn secondary-btn">

                Explore Trends

            </a>

        </div>

    </div>

</section>





<!-- ========================================= -->
<!-- PRODUCTS SECTION -->
<!-- ========================================= -->

<section class="products-section"
         id="productsSection">




    <!-- ========================================= -->
    <!-- PRODUCTS LAYOUT -->
    <!-- ========================================= -->

    <div class="products-layout">





        <!-- ========================================= -->
        <!-- FILTER SIDEBAR -->
        <!-- ========================================= -->

        <aside class="luxury-filter-sidebar">




            <div class="filter-card">




                <!-- HEADER -->

                <div class="filter-header">

                    <h3>

                        Filters

                    </h3>





                    <a href="#"
                       class="reset-btn">

                        Reset All

                    </a>

                </div>





                <!-- SEARCH -->

                <div class="sidebar-search-box">

                    <input type="text"
                           placeholder="Search products, brands...">

                    <i class="fa-solid fa-magnifying-glass"></i>

                </div>





                <!-- CATEGORIES -->

                <div class="filter-section">

                    <div class="filter-title">

                        <h4>

                            Categories

                        </h4>





                        <i class="fa-solid fa-chevron-down"></i>

                    </div>





                    <div class="filter-tags">

                        <button class="active">

                            All

                        </button>





                        <button>

                            Men

                        </button>





                        <button>

                            Women

                        </button>





                        <button>

                            Kids

                        </button>





                        <button>

                            Accessories

                        </button>

                    </div>

                </div>





                <!-- BRANDS -->

                <div class="filter-section">

                    <div class="filter-title">

                        <h4>

                            Brands

                        </h4>





                        <i class="fa-solid fa-chevron-down"></i>

                    </div>





                    <div class="filter-tags">

                        <button class="active">

                            All

                        </button>





                        <button>

                            Nike

                        </button>





                        <button>

                            Adidas

                        </button>





                        <button>

                            Puma

                        </button>





                        <button>

                            Zara

                        </button>





                        <button>

                            H&M

                        </button>

                    </div>

                </div>





                <!-- PRICE RANGE -->

                <div class="filter-section">

                    <div class="filter-title">

                        <h4>

                            Price Range

                        </h4>





                        <i class="fa-solid fa-chevron-down"></i>

                    </div>





                    <input type="range"
                           class="price-slider">





                    <div class="price-values">

                        <div class="price-box">

                            ₹499

                        </div>





                        <div class="price-box">

                            ₹9999

                        </div>

                    </div>

                </div>





                <!-- COLORS -->

                <div class="filter-section">

                    <div class="filter-title">

                        <h4>

                            Colors

                        </h4>





                        <i class="fa-solid fa-chevron-down"></i>

                    </div>





                    <div class="color-options">

                        <div class="color-circle black active"></div>

                        <div class="color-circle white"></div>

                        <div class="color-circle gray"></div>

                        <div class="color-circle blue"></div>

                        <div class="color-circle green"></div>

                        <div class="color-circle red"></div>





                        <div class="color-circle more">

                            +5

                        </div>

                    </div>

                </div>





                <!-- SIZE -->

                <div class="filter-section">

                    <div class="filter-title">

                        <h4>

                            Size

                        </h4>





                        <i class="fa-solid fa-chevron-down"></i>

                    </div>





                    <div class="size-options">

                        <button>XS</button>
                        <button>S</button>
                        <button>M</button>
                        <button>L</button>
                        <button>XL</button>
                        <button>XXL</button>

                    </div>

                </div>

            </div>

        </aside>





        <!-- ========================================= -->
        <!-- PRODUCTS CONTENT -->
        <!-- ========================================= -->

        <div class="products-content">




            <!-- TOP BAR -->

            <div class="products-topbar">




                <%
                List<Product> products =
                (List<Product>)
                request.getAttribute("products");



                if(products == null){

                    products =
                    Collections.emptyList();
                }
                %>





                <h2 class="products-count">

                    Latest Products
                    (<%= products.size() %>)

                </h2>





                <div class="sort-area">

                    <label>

                        Sort by:

                    </label>





                    <select>

                        <option>

                            Featured

                        </option>





                        <option>

                            Price Low to High

                        </option>





                        <option>

                            Price High to Low

                        </option>





                        <option>

                            Latest

                        </option>

                    </select>





                    <div class="view-buttons">

                        <button class="view-btn active">

                            <i class="fa-solid fa-grip"></i>

                        </button>





                        <button class="view-btn">

                            <i class="fa-solid fa-list"></i>

                        </button>

                    </div>

                </div>

            </div>





            <!-- ========================================= -->
            <!-- PRODUCTS GRID -->
            <!-- ========================================= -->

            <div class="products-grid">




                <%
                for(Product p : products){

                    String category =
                            "accessories";



                    switch(p.getCategoryId()){

                        case 1:

                            category = "men";
                            break;



                        case 2:

                            category = "women";
                            break;



                        case 3:

                            category = "kids";
                            break;



                        case 4:

                            category = "accessories";
                            break;
                    }



                    double originalPrice =
                            p.getPrice();



                    double finalPrice =
                            originalPrice -
                            (originalPrice *
                            p.getDiscountPercent()
                            / 100);
                %>





                <!-- ========================================= -->
                <!-- PRODUCT CARD -->
                <!-- ========================================= -->

                <div class="product-card"
                     data-category="<%= category %>">





                    <!-- WISHLIST -->

                    <form action="${pageContext.request.contextPath}/wishlist"
                          method="post">

                        <input type="hidden"
                               name="productId"
                               value="<%= p.getProductId() %>">

                        <button type="submit"
                                class="wishlist-icon-btn">

                            <i class="fa-regular fa-heart"></i>

                        </button>

                    </form>





                    <!-- PRODUCT IMAGE -->

                    <a class="product-link"
                       href="${pageContext.request.contextPath}/product-details?id=<%= p.getProductId() %>">

                        <div class="product-image-wrapper">

                            <img class="product-image"

                                 src="${pageContext.request.contextPath}/<%= p.getImageUrl() %>"

                                 alt="<%= p.getProductName() %>">

                        </div>

                    </a>





                    <!-- PRODUCT INFO -->

                    <div class="product-info">




                        <!-- BRAND -->

                        <p class="product-brand">

                            <%= p.getBrand() %>

                        </p>





                        <!-- PRODUCT NAME -->

                        <a class="product-link"
                           href="${pageContext.request.contextPath}/product-details?id=<%= p.getProductId() %>">

                            <h3 class="product-title">

                                <%= p.getProductName() %>

                            </h3>

                        </a>





                        <!-- DESCRIPTION -->

                        <p class="product-desc">

                            <%= p.getDescription() %>

                        </p>





                        <!-- RATING -->

                        <div class="rating">

                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-solid fa-star"></i>
                            <i class="fa-regular fa-star"></i>





                            <span>

                                4.5

                            </span>

                        </div>





                        <!-- PRICE -->

                        <div class="price-section">

                            <span class="final-price">

                                ₹<%= (int) finalPrice %>

                            </span>





                            <span class="original-price">

                                ₹<%= (int) originalPrice %>

                            </span>





                            <span class="discount-percent">

                                <%= (int) p.getDiscountPercent() %>% OFF

                            </span>

                        </div>





                        <!-- ADD TO CART -->

                        <form action="${pageContext.request.contextPath}/cart"
                              method="post">

                            <input type="hidden"
                                   name="productId"
                                   value="<%= p.getProductId() %>">

                            <button class="add-cart-btn"
                                    type="submit">

                                Add To Cart

                            </button>

                        </form>

                    </div>

                </div>

                <%
                }
                %>

            </div>

        </div>

    </div>

</section>





<!-- ========================================= -->
<!-- FOOTER -->
<!-- ========================================= -->

<jsp:include page="partials/footer.jsp" />





<!-- ========================================= -->
<!-- PRODUCTS JS -->
<!-- ========================================= -->

<script
src="${pageContext.request.contextPath}/assets/js/products.js">
</script>





</body>
</html>