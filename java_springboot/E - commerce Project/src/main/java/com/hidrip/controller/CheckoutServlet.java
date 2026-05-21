package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.CartDAO;
import com.hidrip.dao.OrderDAO;

import com.hidrip.dao.impl.CartDAOImpl;
import com.hidrip.dao.impl.OrderDAOImpl;

import com.hidrip.model.CartItem;
import com.hidrip.model.Order;
import com.hidrip.model.OrderItem;
import com.hidrip.model.User;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;



@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    // =========================================
    // LOAD CHECKOUT PAGE
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



        CartDAO cartDAO =
                new CartDAOImpl();



        // =========================================
        // GET CART
        // =========================================

        int cartId =
                cartDAO.getCartIdByUserId(
                        user.getUserId());



        List<CartItem> cartItems =
                cartDAO.getCartItems(
                        cartId);



        double total =
                cartDAO.getCartTotal(
                        cartId);



        // =========================================
        // SEND TO JSP
        // =========================================

        request.setAttribute(
                "cartItems",
                cartItems);

        request.setAttribute(
                "cartTotal",
                total);



        request.getRequestDispatcher(
                "/WEB-INF/views/checkout.jsp")
                .forward(request, response);
    }



    // =========================================
    // PLACE ORDER
    // =========================================

    @Override
    protected void doPost(HttpServletRequest request,
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



        // =========================================
        // FORM DATA
        // =========================================

        String address =
                request.getParameter(
                        "address");



        String paymentMethod =
                request.getParameter(
                        "paymentMethod");



        CartDAO cartDAO =
                new CartDAOImpl();

        OrderDAO orderDAO =
                new OrderDAOImpl();



        // =========================================
        // GET CART
        // =========================================

        int cartId =
                cartDAO.getCartIdByUserId(
                        user.getUserId());



        List<CartItem> cartItems =
                cartDAO.getCartItems(
                        cartId);



        double total =
                cartDAO.getCartTotal(
                        cartId);



        // =========================================
        // CREATE ORDER
        // =========================================

        Order order =
                new Order();

        order.setUserId(
                user.getUserId());

        order.setTotalAmount(
                total);

        order.setPaymentMethod(
                paymentMethod);

        order.setOrderStatus(
                "PLACED");

        order.setDeliveryAddress(
                address);



        int orderId =
                orderDAO.createOrder(
                        order);



        // =========================================
        // SAVE ORDER ITEMS
        // =========================================

        for(CartItem cartItem : cartItems){

            OrderItem item =
                    new OrderItem();

            item.setOrderId(
                    orderId);

            item.setProductId(
                    cartItem.getProductId());

            item.setQuantity(
                    cartItem.getQuantity());

            item.setUnitPrice(
                    cartItem.getUnitPrice());



            orderDAO.addOrderItem(
                    item);
        }



        // =========================================
        // CLEAR CART
        // =========================================

        cartDAO.clearCart(
                cartId);



        // =========================================
        // REDIRECT
        // =========================================

        response.sendRedirect(
                request.getContextPath()
                + "/orders");
    }

}