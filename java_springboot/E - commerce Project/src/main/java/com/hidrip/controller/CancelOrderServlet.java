package com.hidrip.controller;

import java.io.IOException;

import com.hidrip.dao.OrderDAO;
import com.hidrip.dao.impl.OrderDAOImpl;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/cancel-order")
public class CancelOrderServlet
extends HttpServlet {

    private static final long serialVersionUID = 1L;



    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int orderId =
                Integer.parseInt(
                request.getParameter("id"));



        OrderDAO orderDAO =
                new OrderDAOImpl();



        orderDAO.cancelOrder(orderId);



        response.sendRedirect(
                request.getContextPath()
                + "/orders");
    }

}