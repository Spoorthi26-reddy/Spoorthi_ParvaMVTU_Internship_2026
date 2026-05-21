<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.hidrip.model.User" %>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>

    Admin Users

</title>



<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/admin-users.css">



<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

</head>

<body>

<%
List<User> users =
(List<User>)
request.getAttribute(
        "users");
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

                Manage Users

            </h1>

        </div>





        <!-- USERS TABLE -->

        <table class="users-table">

            <thead>

                <tr>

                    <th>User ID</th>

                    <th>Username</th>

                    <th>Email</th>

                    <th>Role</th>

                    <th>Update Role</th>

                    <th>Delete</th>

                </tr>

            </thead>





            <tbody>

            <%
            for(User user : users){
            %>

                <tr>

                    <td>

                        <%= user.getUserId() %>

                    </td>



                    <td>

                       <%= user.getFullName() %>

                    </td>



                    <td>

                        <%= user.getEmail() %>

                    </td>



                    <td>

                        <span class="role-badge">

                            <%= user.getRole() %>

                        </span>

                    </td>



                    <!-- UPDATE ROLE -->

                    <td>

                        <form action="${pageContext.request.contextPath}/admin/users"
                              method="post"
                              class="role-form">



                            <input type="hidden"
                                   name="userId"
                                   value="<%= user.getUserId() %>">



                            <select name="role">



                                <option value="USER"
                                <%= user.getRole().equals("USER")
                                ? "selected" : "" %>>

                                    USER

                                </option>



                                <option value="ADMIN"
                                <%= user.getRole().equals("ADMIN")
                                ? "selected" : "" %>>

                                    ADMIN

                                </option>

                            </select>



                            <button type="submit"
                                    class="update-btn">

                                Update

                            </button>

                        </form>

                    </td>





                    <!-- DELETE -->

                    <td>

                        <a href="${pageContext.request.contextPath}/admin/delete-user?id=<%= user.getUserId() %>"
                           class="delete-btn"

                           onclick="return confirm(
                           'Delete this user?')">

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