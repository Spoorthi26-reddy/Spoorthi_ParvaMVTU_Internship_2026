<%@ page contentType="text/html;charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ page import="com.hidrip.model.User" %>

<%
User loggedInUser =
(User) session.getAttribute(
        "loggedInUser");
%>


<!-- ========================= -->
<!-- NAVBAR -->
<!-- ========================= -->

<header class="navbar">

    <div class="container navbar-container">


        <!-- ========================= -->
        <!-- LOGO -->
        <!-- ========================= -->

        <div class="logo">

            <a href="${pageContext.request.contextPath}/home">

                HiDrip

            </a>

        </div>



        <!-- ========================= -->
        <!-- SEARCH BAR -->
        <!-- ========================= -->

        <form class="search-bar"
              action="${pageContext.request.contextPath}/products"
              method="get">

            <input type="text"
                   name="keyword"
                   placeholder="Search fashion products...">

            <button type="submit">

                Search

            </button>

        </form>



        <!-- ========================= -->
        <!-- NAV LINKS -->
        <!-- ========================= -->

        <nav class="nav-links">


            <!-- HOME -->

            <a href="${pageContext.request.contextPath}/home">

                Home

            </a>



            <!-- PRODUCTS -->

            <a href="${pageContext.request.contextPath}/products">

                Products

            </a>


				
				<a href="${pageContext.request.contextPath}/orders">

    			 Orders

				</a>
					
				<a href="${pageContext.request.contextPath}/profile">

    				 Profile

					</a>	
					
					<a href="${pageContext.request.contextPath}/wishlist">

    Wishlist

</a>
				
            <!-- CART -->

            <a href="${pageContext.request.contextPath}/cart">

                Cart

            </a>



            <!-- ========================= -->
            <!-- IF USER LOGGED IN -->
            <!-- ========================= -->

            <%
            if(loggedInUser != null){
            %>


                <!-- USER NAME -->

                <span class="user-name">

                    Hi,
                    <%= loggedInUser.getFullName() %>

                </span>



                <!-- LOGOUT -->

                <a class="logout-btn"
                   href="${pageContext.request.contextPath}/logout">

                    Logout

                </a>

            <%
            }
            %>



            <!-- ========================= -->
            <!-- IF USER NOT LOGGED IN -->
            <!-- ========================= -->

            <%
            if(loggedInUser == null){
            %>

                <a href="${pageContext.request.contextPath}/login">

                    Login

                </a>

                <a class="primary-btn"
                   href="${pageContext.request.contextPath}/register">

                    Register

                </a>

            <%
            }
            %>

        </nav>

    </div>

</header>