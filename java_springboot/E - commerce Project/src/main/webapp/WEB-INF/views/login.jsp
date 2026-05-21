<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - Login</title>



<!-- GLOBAL CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- PAGE CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/login.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>



<body>


<!-- ========================= -->
<!-- NAVBAR -->
<!-- ========================= -->

<jsp:include page="partials/navbar.jsp" />



<!-- ========================= -->
<!-- LOGIN SECTION -->
<!-- ========================= -->

<section class="login-section">


    <div class="login-container">


        <!-- LEFT SIDE -->

        <div class="login-banner">

            <h1>

                Welcome Back

            </h1>

            <p>

                Login to continue shopping
                premium fashion collections.

            </p>

        </div>



        <!-- RIGHT SIDE -->

        <div class="login-form-container">


            <h2>

                Login Account

            </h2>



            <!-- ERROR MESSAGE -->

            <%
            String errorMessage =
            (String) request.getAttribute(
                    "errorMessage");

            if(errorMessage != null){
            %>

            <div class="error-message">

                <%= errorMessage %>

            </div>

            <%
            }
            %>



            <!-- LOGIN FORM -->

            <form action="${pageContext.request.contextPath}/login"
                  method="post">


                <!-- EMAIL -->

                <div class="form-group">

                    <label>

                        Email Address

                    </label>

                    <input type="email"
                           name="email"
                           placeholder="Enter email"
                           required>

                </div>



                <!-- PASSWORD -->

                <div class="form-group">

                    <label>

                        Password

                    </label>

                   <div class="password-wrapper">

    <input type="password"
           id="password"
           name="password"
           placeholder="Enter Password"
           required>





    <span class="toggle-password"
          onclick="togglePassword()">

        <i class="fa-solid fa-eye"
           id="eyeIcon"></i>

    </span>

</div>
                </div>



                <!-- LOGIN BUTTON -->

                <button type="submit"
                        class="login-btn">

                    Login

                </button>



                <!-- REGISTER LINK -->

                <p class="register-link">

                    Don't have an account?

                    <a href="${pageContext.request.contextPath}/register">

                        Create Account

                    </a>

                </p>

            </form>

        </div>

    </div>

</section>



<!-- ========================= -->
<!-- FOOTER -->
<!-- ========================= -->

<jsp:include page="partials/footer.jsp" />


<script>

function togglePassword(){

    const passwordInput =
    document.getElementById(
    "password");



    const eyeIcon =
    document.getElementById(
    "eyeIcon");





    if(passwordInput.type === "password"){

        passwordInput.type = "text";



        eyeIcon.classList.remove(
        "fa-eye");



        eyeIcon.classList.add(
        "fa-eye-slash");
    }

    else{

        passwordInput.type =
        "password";



        eyeIcon.classList.remove(
        "fa-eye-slash");



        eyeIcon.classList.add(
        "fa-eye");
    }
}

</script>
</body>
</html>