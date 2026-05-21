<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>

    Add Product

</title>



<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/admin-add-product.css">



<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>





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

                Add Product

            </h1>

        </div>





        <!-- FORM -->

        <div class="form-container">



            <form action="${pageContext.request.contextPath}/admin/add-product"
                  method="post"
                  class="product-form">





                <!-- CATEGORY -->

                <div class="form-group">

                    <label>

                        Category

                    </label>



                    <select name="categoryId"
                            required>

                        <option value="1">

                            Men

                        </option>



                        <option value="2">

                            Women

                        </option>



                        <option value="3">

                            Kids

                        </option>



                        <option value="4">

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
                           required>

                </div>





                <!-- BRAND -->

                <div class="form-group">

                    <label>

                        Brand

                    </label>



                    <input type="text"
                           name="brand"
                           required>

                </div>





                <!-- DESCRIPTION -->

                <div class="form-group">

                    <label>

                        Description

                    </label>



                    <textarea name="description"
                              rows="5"
                              required></textarea>

                </div>





                <!-- PRICE -->

                <div class="form-group">

                    <label>

                        Price

                    </label>



                    <input type="number"
                           name="price"
                           step="0.01"
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
                           required>

                </div>





                <!-- IMAGE URL -->

                <div class="form-group">

                    <label>

                        Image Path

                    </label>



                    <input type="text"
                           name="imageUrl"
                           placeholder="assets/images/product.jpg"
                           required>

                </div>





                <!-- BUTTON -->

                <button type="submit"
                        class="submit-btn">

                    Add Product

                </button>

            </form>

        </div>

    </main>

</div>

</body>
</html>