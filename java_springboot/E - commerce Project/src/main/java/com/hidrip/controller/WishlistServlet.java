package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.WishlistDAO;

import com.hidrip.dao.impl.WishlistDAOImpl;

import com.hidrip.model.Product;

import com.hidrip.model.User;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;



@WebServlet("/wishlist")
public class WishlistServlet
extends HttpServlet {

    private static final long serialVersionUID = 1L;




    // =========================================
    // LOAD WISHLIST PAGE
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
           session.getAttribute(
                   "loggedInUser") == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login");

            return;
        }



        User user =
                (User) session.getAttribute(
                        "loggedInUser");



        WishlistDAO wishlistDAO =
                new WishlistDAOImpl();



        // =========================================
        // REMOVE ITEM
        // =========================================

        String action =
                request.getParameter(
                        "action");



        if(action != null &&
           action.equals("remove")) {

            int productId =
                    Integer.parseInt(
                    request.getParameter(
                            "productId"));



            wishlistDAO.removeFromWishlist(
                    user.getUserId(),
                    productId);
        }



        // =========================================
        // LOAD WISHLIST
        // =========================================

        List<Product> wishlistProducts =
                wishlistDAO.getWishlistByUser(
                        user.getUserId());



        request.setAttribute(
                "wishlistProducts",
                wishlistProducts);



        request.getRequestDispatcher(
                "/WEB-INF/views/wishlist.jsp")
                .forward(request, response);
    }




    // =========================================
    // ADD TO WISHLIST
    // =========================================

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);



        if(session == null ||
           session.getAttribute(
                   "loggedInUser") == null) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login");

            return;
        }



        User user =
                (User) session.getAttribute(
                        "loggedInUser");



        int productId =
                Integer.parseInt(
                request.getParameter(
                        "productId"));



        WishlistDAO wishlistDAO =
                new WishlistDAOImpl();



        // =========================================
        // CHECK EXISTS
        // =========================================

        boolean exists =
                wishlistDAO.isInWishlist(
                        user.getUserId(),
                        productId);



        if(!exists) {

            wishlistDAO.addToWishlist(
                    user.getUserId(),
                    productId);
        }



        response.sendRedirect(
                request.getContextPath()
                + "/wishlist");
    }

}