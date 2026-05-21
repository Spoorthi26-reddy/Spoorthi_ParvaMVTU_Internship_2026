<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.Product" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>

    Admin Products

</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/admin-products.css">



<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<div class="admin-layout">



    <!-- SIDEBAR -->

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





    <!-- MAIN -->

    <main class="admin-main">



        <div class="topbar">

            <h1>

                Manage Products

            </h1>



          <a href="${pageContext.request.contextPath}/admin/add-product"
   class="add-btn">

    + Add Product

</a>

        </div>





        <!-- TABLE -->

        <table class="products-table">

            <thead>

                <tr>

                    <th>ID</th>

                    <th>Image</th>

                    <th>Name</th>

                    <th>Brand</th>

                    <th>Price</th>

                    <th>Actions</th>

                </tr>

            </thead>





            <tbody>

            <%
            List<Product> products =
            (List<Product>)
            request.getAttribute("products");



            for(Product p : products){
            %>

                <tr>

                    <td>

                        <%= p.getProductId() %>

                    </td>



                    <td>

                        <img
                        src="${pageContext.request.contextPath}/<%= p.getImageUrl() %>"
                        class="product-img">

                    </td>



                    <td>

                        <%= p.getProductName() %>

                    </td>



                    <td>

                        <%= p.getBrand() %>

                    </td>



                    <td>

                        ₹<%= (int)p.getPrice() %>

                    </td>



                    <td>

                       <a href="${pageContext.request.contextPath}/admin/edit-product?id=<%= p.getProductId() %>"
   class="edit-btn">

    Edit

</a>


                        <a href="${pageContext.request.contextPath}/admin/delete-product?id=<%= p.getProductId() %>"
   class="delete-btn"

   onclick="return confirm(
   'Are you sure you want to delete this product?')">

    Delete

</a>

                    </td>

                </tr>

            <%
            }
            %>

            </tbody>

        </table>

    </main>

</div>

</body>
</html>