package com.hidrip.controller;
import java.util.List;

import com.hidrip.model.Order;

import java.io.IOException;

import com.hidrip.dao.AdminDAO;

import com.hidrip.dao.impl.AdminDAOImpl;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/admin/dashboard")
public class AdminDashboardServlet
extends HttpServlet {

    private static final long
    serialVersionUID = 1L;





    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {




        AdminDAO adminDAO =
                new AdminDAOImpl();




        int totalUsers =
                adminDAO.getTotalUsers();




        int totalProducts =
                adminDAO.getTotalProducts();




        int totalOrders =
                adminDAO.getTotalOrders();




        double totalRevenue =
                adminDAO.getTotalRevenue();




        request.setAttribute(
                "totalUsers",
                totalUsers);




        request.setAttribute(
                "totalProducts",
                totalProducts);




        request.setAttribute(
                "totalOrders",
                totalOrders);




        request.setAttribute(
                "totalRevenue",
                totalRevenue);

        List<Order> recentOrders =
                adminDAO.getRecentOrders();



        request.setAttribute(
                "recentOrders",
                recentOrders);



        request.getRequestDispatcher(
        "/WEB-INF/admin/dashboard.jsp")
        .forward(request,
                 response);
    }

}