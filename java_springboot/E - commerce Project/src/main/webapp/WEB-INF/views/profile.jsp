<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="com.hidrip.model.User" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - My Profile</title>



<!-- GLOBAL CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- PAGE CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/profile.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>



<!-- NAVBAR -->

<jsp:include page="partials/navbar.jsp" />





<!-- PROFILE SECTION -->

<section class="profile-section">

<div class="container">



<%
User user =
(User)
request.getAttribute("user");
%>





<!-- TITLE -->

<h1 class="profile-title">

    My Profile

</h1>





<!-- PROFILE CARD -->

<div class="profile-card">



    <!-- LEFT -->

    <div class="profile-left">

        <div class="profile-avatar">

            <i class="fa-solid fa-user"></i>

        </div>



        <h2>

            <%= user.getFullName() %>

        </h2>





        <p>

            <%= user.getEmail() %>

        </p>

    </div>





    <!-- RIGHT -->

    <div class="profile-right">



<%
String success =
(String)
request.getAttribute(
        "successMessage");

String error =
(String)
request.getAttribute(
        "errorMessage");
%>





<%
if(success != null){
%>

<div class="success-message">

    <%= success %>

</div>

<%
}
%>





<%
if(error != null){
%>

<div class="error-message">

    <%= error %>

</div>

<%
}
%>





<form action="${pageContext.request.contextPath}/profile"
      method="post">



    <!-- NAME -->

    <div class="form-group">

        <label>

            Full Name

        </label>

        <input type="text"
               name="fullName"
               value="<%= user.getFullName() %>"
               required>

    </div>





    <!-- EMAIL -->

    <div class="form-group">

        <label>

            Email

        </label>

        <input type="email"
               value="<%= user.getEmail() %>"
               readonly>

    </div>





    <!-- PHONE -->

    <div class="form-group">

        <label>

            Phone

        </label>

        <input type="text"
               name="phone"
               value="<%= user.getPhone() %>">

    </div>





    <!-- ADDRESS -->

    <div class="form-group">

        <label>

            Address

        </label>

        <textarea name="address"><%= user.getAddress() %></textarea>

    </div>





    <!-- BUTTON -->

    <button type="submit"
            class="update-btn">

        Update Profile

    </button>

</form>

    </div>

</div>

</div>

</section>





<!-- FOOTER -->

<jsp:include page="partials/footer.jsp" />



</body>
</html>