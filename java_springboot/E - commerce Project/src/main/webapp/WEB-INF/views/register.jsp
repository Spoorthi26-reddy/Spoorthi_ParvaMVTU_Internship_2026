<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>HiDrip - Register</title>



<!-- GLOBAL CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/style.css">



<!-- PAGE CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/register.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>



<body>


<!-- ========================= -->
<!-- NAVBAR -->
<!-- ========================= -->

<jsp:include page="partials/navbar.jsp" />



<!-- ========================= -->
<!-- REGISTER SECTION -->
<!-- ========================= -->

<section class="register-section">


    <div class="register-container">


        <!-- LEFT SIDE -->

        <div class="register-banner">

            <h1>

                Join HiDrip

            </h1>

            <p>

                Create your account and explore
                premium fashion collections.

            </p>

        </div>



        <!-- RIGHT SIDE -->

        <div class="register-form-container">


            <h2>

                Create Account

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



            <!-- REGISTER FORM -->

            <form action="${pageContext.request.contextPath}/register"
                  method="post">


                <!-- FULL NAME -->

                <div class="form-group">

                    <label>

                        Full Name

                    </label>

                    <input type="text"
                           name="fullName"
                           placeholder="Enter full name"
                           required>

                </div>



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



                <!-- PHONE -->

                <div class="form-group">

                    <label>

                        Phone Number

                    </label>

                    <input type="text"
                           name="phone"
                           placeholder="Enter phone number"
                           required>

                </div>



                <!-- PASSWORD -->

                <div class="form-group">

                    <label>

                        Password

                    </label>

                    <input type="password"
                           name="password"
                           placeholder="Enter password"
                           required>

                </div>



                <!-- GENDER -->

                <div class="form-group">

                    <label>

                        Gender

                    </label>

                    <select name="gender"
                            required>

                        <option value="">

                            Select Gender

                        </option>

                        <option value="Male">

                            Male

                        </option>

                        <option value="Female">

                            Female

                        </option>

                    </select>

                </div>



                <!-- ADDRESS -->

                <div class="form-group">

                    <label>

                        Address

                    </label>

                    <textarea name="address"
                              rows="4"
                              placeholder="Enter address"
                              required></textarea>

                </div>



                <!-- SUBMIT -->

                <button type="submit"
                        class="register-btn">

                    Create Account

                </button>



                <!-- LOGIN LINK -->

                <p class="login-link">

                    Already have an account?

                    <a href="${pageContext.request.contextPath}/login">

                        Login

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



</body>
</html>