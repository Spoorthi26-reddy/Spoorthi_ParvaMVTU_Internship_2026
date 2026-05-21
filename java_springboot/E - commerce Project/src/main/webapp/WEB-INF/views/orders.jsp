<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.Order" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - My Orders</title>

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/orders.css">

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>



<!-- NAVBAR -->

<jsp:include page="partials/navbar.jsp" />





<!-- ORDERS SECTION -->

<section class="orders-section">

<div class="container">

<h1 class="orders-title">

    My Orders

</h1>





<%
List<Order> orders =
(List<Order>)
request.getAttribute("orders");
%>





<%
if(orders == null || orders.isEmpty()){
%>



<div class="empty-orders">

    <i class="fa-solid fa-box-open"></i>

    <h2>No Orders Yet</h2>

    <p>

        Start shopping and place your first order.

    </p>

    <a href="${pageContext.request.contextPath}/products"
       class="primary-btn">

        Shop Now

    </a>

</div>



<%
}
else{
%>





<div class="orders-container">


<%
for(Order order : orders){
%>



<div class="order-card">



    <!-- ORDER HEADER -->

    <div class="order-header">



        <div>

            <h2>

                Order #<%= order.getOrderId() %>

            </h2>

            <p>

                <%= order.getOrderDate() %>

            </p>

        </div>





        <!-- RIGHT SIDE -->

        <div class="order-right">

            <span class="order-status">

                <%= order.getOrderStatus() %>

            </span>



            <a href="${pageContext.request.contextPath}/order-details?id=<%= order.getOrderId() %>"
               class="view-order-btn">

                View Details
                <%
if(!order.getOrderStatus()
         .equals("CANCELLED")){
%>

<a href="${pageContext.request.contextPath}/cancel-order?id=<%= order.getOrderId() %>"
   class="cancel-order-btn">

    Cancel Order

</a>

<%
}
%>

            </a>

        </div>

    </div>





    <!-- ORDER DETAILS -->

    <div class="order-details">

        <div class="order-detail-item">

            <span>Payment</span>

            <strong>

                <%= order.getPaymentMethod() %>

            </strong>

        </div>



        <div class="order-detail-item">

            <span>Total</span>

            <strong>

                ₹<%= (int)order.getTotalAmount() %>

            </strong>

        </div>

    </div>





    <!-- ADDRESS -->

    <div class="order-address">

        <span>Delivery Address</span>

        <p>

            <%= order.getDeliveryAddress() %>

        </p>

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