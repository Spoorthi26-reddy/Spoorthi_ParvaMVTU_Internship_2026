<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.Order" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>

    Admin Orders

</title>



<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/admin-orders.css">



<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<%
List<Order> orders =
(List<Order>)
request.getAttribute(
        "orders");
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

                Manage Orders

            </h1>

        </div>





        <!-- TABLE -->

        <table class="orders-table">

            <thead>

                <tr>

                    <th>Order ID</th>

                    <th>User ID</th>

                    <th>Total</th>

                    <th>Payment</th>

                    <th>Status</th>

                    <th>Date</th>

                    <th>Action</th>

                </tr>

            </thead>





            <tbody>

            <%
            for(Order order : orders){
            %>

                <tr>

                    <td>

                        #<%= order.getOrderId() %>

                    </td>



                    <td>

                        <%= order.getUserId() %>

                    </td>



                    <td>

                        ₹<%= (int)order.getTotalAmount() %>

                    </td>



                    <td>

                        <%= order.getPaymentMethod() %>

                    </td>



                    <td>

                        <span class="status">

                            <%= order.getOrderStatus() %>

                        </span>

                    </td>



                    <td>

                        <%= order.getOrderDate() %>

                    </td>



                    <td>

                        <form action="${pageContext.request.contextPath}/admin/orders"
                              method="post"
                              class="status-form">



                            <input type="hidden"
                                   name="orderId"
                                   value="<%= order.getOrderId() %>">



                            <select name="status">

<option value="PLACED"
<%= order.getOrderStatus().equals("PLACED")
? "selected" : "" %>>

    PLACED

</option>



<option value="SHIPPED"
<%= order.getOrderStatus().equals("SHIPPED")
? "selected" : "" %>>

    SHIPPED

</option>



<option value="OUT FOR DELIVERY"
<%= order.getOrderStatus().equals("OUT FOR DELIVERY")
? "selected" : "" %>>

    OUT FOR DELIVERY

</option>



<option value="DELIVERED"
<%= order.getOrderStatus().equals("DELIVERED")
? "selected" : "" %>>

    DELIVERED

</option>



<option value="CANCELLED"
<%= order.getOrderStatus().equals("CANCELLED")
? "selected" : "" %>>

    CANCELLED

</option>
                            </select>



                            <button type="submit"
                                    class="update-btn">

                                Update

                            </button>

                        </form>

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