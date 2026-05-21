<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.CartItem" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - Checkout</title>



<!-- ========================================= -->
<!-- GLOBAL CSS -->
<!-- ========================================= -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- ========================================= -->
<!-- PAGE CSS -->
<!-- ========================================= -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/checkout.css">



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
<!-- CHECKOUT SECTION -->
<!-- ========================================= -->

<section class="checkout-section">

<div class="container">



<h1 class="checkout-title">

    Checkout

</h1>





<%
List<CartItem> cartItems =
(List<CartItem>)
request.getAttribute("cartItems");



Double cartTotal =
(Double)
request.getAttribute("cartTotal");



if(cartTotal == null){

    cartTotal = 0.0;
}
%>





<div class="checkout-container">





<!-- ========================================= -->
<!-- SHIPPING FORM -->
<!-- ========================================= -->

<div class="checkout-form">



    <h2>

        Delivery Information

    </h2>





    <form action="${pageContext.request.contextPath}/checkout"
          method="post">



        <!-- ADDRESS -->

        <div class="form-group">

            <label>

                Delivery Address

            </label>

            <textarea name="address"
                      required
                      placeholder="Enter full delivery address"></textarea>

        </div>





        <!-- PAYMENT METHOD -->

        <div class="form-group">

            <label>

                Payment Method

            </label>





            <select name="paymentMethod"
                    required>

                <option value="COD">

                    Cash On Delivery

                </option>

                <option value="UPI">

                    UPI

                </option>

                <option value="CARD">

                    Credit / Debit Card

                </option>

            </select>

        </div>





        <!-- PLACE ORDER -->

        <button type="submit"
                class="place-order-btn">

            Place Order

        </button>

    </form>

</div>





<!-- ========================================= -->
<!-- ORDER SUMMARY -->
<!-- ========================================= -->

<div class="checkout-summary">



    <h2>

        Order Summary

    </h2>





<%
if(cartItems != null){

    for(CartItem item : cartItems){
%>





    <!-- PRODUCT -->

    <div class="summary-item">



        <div>

            <p class="summary-product-name">

                <%= item.getProduct()
                        .getProductName() %>

            </p>





            <small>

                Qty:
                <%= item.getQuantity() %>

            </small>

        </div>





        <span>

            ₹<%= (int)item.getTotalPrice() %>

        </span>

    </div>





<%
    }
}
%>





    <hr>





    <!-- TOTAL -->

    <div class="summary-total">

        <span>Total</span>

        <span>

            ₹<%= cartTotal.intValue() %>

        </span>

    </div>

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