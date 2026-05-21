package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.OrderDAO;

import com.hidrip.dao.impl.OrderDAOImpl;

import com.hidrip.model.Order;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/admin/orders")
public class AdminOrdersServlet
extends HttpServlet {

    private static final long
    serialVersionUID = 1L;





    // =========================================
    // LOAD ORDERS
    // =========================================

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {

        OrderDAO orderDAO =
                new OrderDAOImpl();



        List<Order> orders =
                orderDAO.getAllOrders();



        request.setAttribute(
                "orders",
                orders);



        request.getRequestDispatcher(
        "/WEB-INF/admin/orders.jsp")
        .forward(request,
                 response);
    }





    // =========================================
    // UPDATE STATUS
    // =========================================

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {

        int orderId =
                Integer.parseInt(
                request.getParameter(
                        "orderId"));



        String status =
                request.getParameter(
                        "status");



        OrderDAO orderDAO =
                new OrderDAOImpl();



        orderDAO.updateOrderStatus(
                orderId,
                status);




        response.sendRedirect(
                request.getContextPath()
                + "/admin/orders");
    }

}