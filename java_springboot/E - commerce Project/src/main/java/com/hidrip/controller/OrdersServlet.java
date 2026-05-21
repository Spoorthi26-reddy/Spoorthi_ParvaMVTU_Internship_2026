package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.OrderDAO;

import com.hidrip.dao.impl.OrderDAOImpl;

import com.hidrip.model.Order;

import com.hidrip.model.User;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;



@WebServlet("/orders")
public class OrdersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    // =========================================
    // LOAD ORDERS PAGE
    // =========================================

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);



        // =========================================
        // CHECK LOGIN
        // =========================================

        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect(
                    request.getContextPath()
                    + "/login");

            return;
        }



        User user =
                (User) session.getAttribute(
                        "loggedInUser");



        OrderDAO orderDAO =
                new OrderDAOImpl();



        // =========================================
        // GET ORDERS
        // =========================================

        List<Order> orders =
                orderDAO.getOrdersByUserId(
                        user.getUserId());



        request.setAttribute(
                "orders",
                orders);



        request.getRequestDispatcher(
                "/WEB-INF/views/orders.jsp")
                .forward(request, response);
    }

}