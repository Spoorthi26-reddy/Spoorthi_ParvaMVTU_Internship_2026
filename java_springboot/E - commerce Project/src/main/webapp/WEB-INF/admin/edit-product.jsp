<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="com.hidrip.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>

    Edit Product

</title>



<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/admin-add-product.css">



<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<%
Product product =
(Product)
request.getAttribute(
        "product");
%>





<!-- ========================================= -->
<!-- ADMIN LAYOUT -->
<!-- ========================================= -->

<div class="admin-layout">





    <!-- ========================================= -->
    <!-- SIDEBAR -->
    <!-- ========================================= -->

    <aside class="admin-sidebar">



        <h2 class="admin-logo">

            HiDrip Admin

        </h2>





        <nav class="admin-nav">

            <a href="${pageContext.request.contextPath}/admin/dashboard">

                Dashboard

            </a>



            <a href="${pageContext.request.contextPath}/admin/products">

                Products

            </a>



            <a href="${pageContext.request.contextPath}/admin/orders">

                Orders

            </a>



            <a href="${pageContext.request.contextPath}/admin/users">

                Users

            </a>



            <a href="${pageContext.request.contextPath}/home">

                Back To Store

            </a>

        </nav>

    </aside>





    <!-- ========================================= -->
    <!-- MAIN -->
    <!-- ========================================= -->

    <main class="admin-main">



        <!-- TOPBAR -->

        <div class="topbar">

            <h1>

                Edit Product

            </h1>

        </div>





        <!-- FORM -->

        <div class="form-container">



            <form action="${pageContext.request.contextPath}/admin/edit-product"
                  method="post"
                  class="product-form">





                <!-- PRODUCT ID -->

                <input type="hidden"
                       name="productId"
                       value="<%= product.getProductId() %>">





                <!-- CATEGORY -->

                <div class="form-group">

                    <label>

                        Category

                    </label>



                    <select name="categoryId"
                            required>

                        <option value="1"
                        <%= product.getCategoryId() == 1 ? "selected" : "" %>>

                            Men

                        </option>



                        <option value="2"
                        <%= product.getCategoryId() == 2 ? "selected" : "" %>>

                            Women

                        </option>



                        <option value="3"
                        <%= product.getCategoryId() == 3 ? "selected" : "" %>>

                            Kids

                        </option>



                        <option value="4"
                        <%= product.getCategoryId() == 4 ? "selected" : "" %>>

                            Accessories

                        </option>

                    </select>

                </div>





                <!-- PRODUCT NAME -->

                <div class="form-group">

                    <label>

                        Product Name

                    </label>



                    <input type="text"
                           name="productName"
                           value="<%= product.getProductName() %>"
                           required>

                </div>





                <!-- BRAND -->

                <div class="form-group">

                    <label>

                        Brand

                    </label>



                    <input type="text"
                           name="brand"
                           value="<%= product.getBrand() %>"
                           required>

                </div>





                <!-- DESCRIPTION -->

                <div class="form-group">

                    <label>

                        Description

                    </label>



                    <textarea name="description"
                              rows="5"
                              required><%= product.getDescription() %></textarea>

                </div>





                <!-- PRICE -->

                <div class="form-group">

                    <label>

                        Price

                    </label>



                    <input type="number"
                           name="price"
                           step="0.01"
                           value="<%= product.getPrice() %>"
                           required>

                </div>





                <!-- DISCOUNT -->

                <div class="form-group">

                    <label>

                        Discount %

                    </label>



                    <input type="number"
                           name="discountPercent"
                           step="0.01"
                           value="<%= product.getDiscountPercent() %>"
                           required>

                </div>





                <!-- IMAGE URL -->

                <div class="form-group">

                    <label>

                        Image Path

                    </label>



                    <input type="text"
                           name="imageUrl"
                           value="<%= product.getImageUrl() %>"
                           required>

                </div>





                <!-- BUTTON -->

                <button type="submit"
                        class="submit-btn">

                    Update Product

                </button>

            </form>

        </div>

    </main>

</div>

</body>
</html>