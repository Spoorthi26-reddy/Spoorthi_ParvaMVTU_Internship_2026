
<%@ page import="java.util.List" %>

<%@ page import="com.hidrip.model.Order" %>
<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
List<Order> recentOrders =
(List<Order>)
request.getAttribute(
        "recentOrders");
%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>

    HiDrip Admin Dashboard

</title>





<!-- CSS -->

<link rel="stylesheet"
href="${pageContext.request.contextPath}/assets/css/admin-dashboard.css">



<!-- FONT AWESOME -->

<link rel="stylesheet"
href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

</head>

<body>





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

                <i class="fa-solid fa-chart-line"></i>

                Dashboard

            </a>





            <a href="${pageContext.request.contextPath}/admin/products">

                <i class="fa-solid fa-box"></i>

                Products

            </a>





            <a href="${pageContext.request.contextPath}/admin/orders">

                <i class="fa-solid fa-cart-shopping"></i>

                Orders

            </a>





            <a href="${pageContext.request.contextPath}/admin/users">

                <i class="fa-solid fa-users"></i>

                Users

            </a>





            <a href="${pageContext.request.contextPath}/home">

                <i class="fa-solid fa-store"></i>

                Back To Store

            </a>

        </nav>

    </aside>





    <!-- ========================================= -->
    <!-- MAIN CONTENT -->
    <!-- ========================================= -->

    <main class="admin-main">



        <!-- TOPBAR -->

        <div class="admin-topbar">

            <h1>

                Dashboard

            </h1>

        </div>





        <!-- DASHBOARD CARDS -->

        <div class="dashboard-cards">



            <div class="dashboard-card">

                <div>

                    <h3>

                        Total Products

                    </h3>

                    <h2>

                      ${totalProducts}

                    </h2>

                </div>

                <i class="fa-solid fa-box"></i>

            </div>





            <div class="dashboard-card">

                <div>

                    <h3>

                        Total Orders

                    </h3>

                    <h2>

                  ${totalOrders}

                    </h2>

                </div>

                <i class="fa-solid fa-cart-shopping"></i>

            </div>





            <div class="dashboard-card">

                <div>

                    <h3>

                        Users

                    </h3>

                    <h2>

                        ${totalUsers}

                    </h2>

                </div>

                <i class="fa-solid fa-users"></i>

            </div>





            <div class="dashboard-card">

                <div>

                    <h3>

                        Revenue

                    </h3>

                    <h2>

                        ₹${totalRevenue}

                    </h2>

                </div>

                <i class="fa-solid fa-indian-rupee-sign"></i>

            </div>

        </div>
<!-- ========================================= -->
<!-- RECENT ORDERS -->
<!-- ========================================= -->

<div class="recent-orders-section">




    <div class="recent-header">

        <div>

            <h2>

                Recent Orders

            </h2>

            <p>

                Latest customer purchases

            </p>

        </div>




        <a href="${pageContext.request.contextPath}/admin/orders"
           class="view-all-btn">

            View All

        </a>

    </div>





    <div class="recent-orders-table">




        <!-- TABLE HEADER -->

        <div class="table-header">

            <span>Order</span>

            <span>User</span>

            <span>Amount</span>

            <span>Status</span>

            <span>Date</span>

        </div>





        <!-- TABLE BODY -->

        <%
        if(recentOrders != null){

            for(Order order : recentOrders){
        %>

        <div class="table-row">




            <div class="order-id">

                #<%= order.getOrderId() %>

            </div>




            <div class="user-id">

                User_<%= order.getUserId() %>

            </div>




            <div class="amount">

                ₹<%= order.getTotalAmount() %>

            </div>




            <div>

                <span class="order-status
                <%= order.getOrderStatus().toLowerCase() %>">

                    <%= order.getOrderStatus() %>

                </span>

            </div>




            <div class="order-date">

                <%= order.getOrderDate() %>

            </div>

        </div>

        <%
            }
        }
        %>

    </div>

</div>


        <!-- WELCOME -->

        <div class="welcome-box">

            <h2>

                Welcome Admin 👋

            </h2>

            <p>

                Manage products,
                orders,
                users,
                and analytics
                from one place.

            </p>

        </div>

   
<!-- ========================================= -->
<!-- SALES CHART -->
<!-- ========================================= -->

<div class="chart-section">




    <div class="chart-card">

        <div class="chart-header">

            <h2>

                Revenue Analytics

            </h2>

            <p>

                Monthly sales overview

            </p>

        </div>




        <canvas id="salesChart"></canvas>

    </div>

</div>
</body>
</html>


 </main>

</div>
<script>

const ctx =
document.getElementById(
'salesChart');



new Chart(ctx, {

    type:'line',



    data:{

        labels:[
            'Jan',
            'Feb',
            'Mar',
            'Apr',
            'May',
            'Jun',
            'Jul',
            'Aug',
            'Sep',
            'Oct',
            'Nov',
            'Dec'
        ],



        datasets:[{

            label:'Revenue',

            data:[
                12000,
                19000,
                15000,
                22000,
                28000,
                35000,
                42000,
                39000,
                48000,
                53000,
                61000,
                72000
            ],



            borderColor:'#6C4DF6',

            backgroundColor:
            'rgba(108,77,246,0.15)',

            fill:true,

            tension:0.4,

            borderWidth:4,

            pointRadius:5,

            pointBackgroundColor:'#6C4DF6'
        }]
    },



    options:{

        responsive:true,

        plugins:{

            legend:{

                display:true
            }
        },



        scales:{

            y:{

                beginAtZero:true
            }
        }
    }
});
</script>
