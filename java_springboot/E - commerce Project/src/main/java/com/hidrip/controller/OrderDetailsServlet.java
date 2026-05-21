package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.OrderDAO;

import com.hidrip.dao.impl.OrderDAOImpl;

import com.hidrip.model.Order;
import com.hidrip.model.OrderItem;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/order-details")
public class OrderDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    // =========================================
    // LOAD ORDER DETAILS
    // =========================================

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int orderId =
                Integer.parseInt(
                        request.getParameter(
                                "id"));



        OrderDAO orderDAO =
                new OrderDAOImpl();



        // =========================================
        // GET ORDER
        // =========================================

        Order order =
                orderDAO.getOrderById(
                        orderId);



        // =========================================
        // GET ORDER ITEMS
        // =========================================

        List<OrderItem> items =
                orderDAO.getOrderItems(
                        orderId);



        request.setAttribute(
                "order",
                order);

        request.setAttribute(
                "orderItems",
                items);



        request.getRequestDispatcher(
                "/WEB-INF/views/order-details.jsp")
                .forward(request, response);
    }

}