<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.Order" %>
<%@ page import="com.hidrip.model.OrderItem" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - Order Details</title>



<!-- GLOBAL CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- PAGE CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/order-details.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>



<!-- NAVBAR -->

<jsp:include page="partials/navbar.jsp" />





<!-- ORDER DETAILS SECTION -->

<section class="order-details-section">

<div class="container">



<%
Order order =
(Order)
request.getAttribute("order");



List<OrderItem> items =
(List<OrderItem>)
request.getAttribute("orderItems");
%>





<!-- TITLE -->

<h1 class="page-title">

    Order Details

</h1>





<!-- ORDER SUMMARY -->

<div class="order-summary-card">



    <div class="summary-row">

        <span>Order ID</span>

        <strong>

            #<%= order.getOrderId() %>

        </strong>

    </div>





    <div class="summary-row">

        <span>Order Date</span>

        <strong>

            <%= order.getOrderDate() %>

        </strong>

    </div>





    <div class="summary-row">

        <span>Payment Method</span>

        <strong>

            <%= order.getPaymentMethod() %>

        </strong>

    </div>





    <div class="summary-row">

        <span>Status</span>

        <strong class="status">

            <%= order.getOrderStatus() %>

        </strong>

    </div>





    <div class="summary-row">

        <span>Total Amount</span>

        <strong>

            ₹<%= (int)order.getTotalAmount() %>

        </strong>

    </div>

</div>





<!-- ADDRESS -->

<div class="address-card">

    <h2>

        Delivery Address

    </h2>

    <p>

        <%= order.getDeliveryAddress() %>

    </p>

</div>





<!-- ORDER ITEMS -->

<div class="items-container">


<%
for(OrderItem item : items){
%>



<div class="item-card">



    <!-- IMAGE -->

    <div class="item-image">

        <img src="${pageContext.request.contextPath}/<%= item.getProduct().getImageUrl() %>"
             alt="Product">

    </div>





    <!-- INFO -->

    <div class="item-info">

        <p class="brand">

            <%= item.getProduct().getBrand() %>

        </p>



        <h2>

            <%= item.getProduct().getProductName() %>

        </h2>



        <p>

            Quantity:
            <%= item.getQuantity() %>

        </p>

    </div>





    <!-- PRICE -->

    <div class="item-price">

        ₹<%= (int)item.getTotalPrice() %>

    </div>

</div>


<%
}
%>

</div>

</div>

</section>





<!-- FOOTER -->

<jsp:include page="partials/footer.jsp" />



</body>
</html>