package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.CartDAO;
import com.hidrip.dao.ProductDAO;

import com.hidrip.dao.impl.CartDAOImpl;
import com.hidrip.dao.impl.ProductDAOImpl;

import com.hidrip.model.CartItem;
import com.hidrip.model.Product;
import com.hidrip.model.User;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;



@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long
    serialVersionUID = 1L;



    // =========================================
    // LOAD CART PAGE
    // =========================================

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);



        User user =
                (User) session.getAttribute(
                        "loggedInUser");



        CartDAO cartDAO =
                new CartDAOImpl();



        // =========================================
        // GET CART ID
        // =========================================

        int cartId =
                cartDAO.getCartIdByUserId(
                        user.getUserId());



        // =========================================
        // CREATE CART IF NOT EXISTS
        // =========================================

        if(cartId == 0){

            cartId =
            cartDAO.createCart(
                    user.getUserId());
        }



        // =========================================
        // HANDLE ACTIONS
        // =========================================

        String action =
                request.getParameter(
                        "action");



        if(action != null){

            int cartItemId =
                    Integer.parseInt(
                    request.getParameter(
                            "cartItemId"));



            if(action.equals("remove")){

                cartDAO.removeCartItem(
                        cartItemId);
            }



            else if(action.equals(
                    "increase")){

                List<CartItem> items =
                        cartDAO.getCartItems(
                                cartId);

                for(CartItem item : items){

                    if(item.getProduct()
                           .getProductId()
                           == cartItemId){

                        cartDAO.updateQuantity(
                                cartItemId,
                                item.getQuantity() + 1);

                        break;
                    }
                }
            }



            else if(action.equals(
                    "decrease")){

                List<CartItem> items =
                        cartDAO.getCartItems(
                                cartId);

                for(CartItem item : items){

                    if(item.getProduct()
                           .getProductId()
                           == cartItemId){

                        if(item.getQuantity() > 1){

                            cartDAO.updateQuantity(
                                    cartItemId,
                                    item.getQuantity() - 1);
                        }

                        break;
                    }
                }
            }



            response.sendRedirect(
                    request.getContextPath()
                    + "/cart");

            return;
        }



        // =========================================
        // GET CART ITEMS
        // =========================================

        List<CartItem> cartItems =
                cartDAO.getCartItems(
                        cartId);



        // =========================================
        // TOTAL
        // =========================================

        double total =
                cartDAO.getCartTotal(
                        cartId);



        request.setAttribute(
                "cartItems",
                cartItems);

        request.setAttribute(
                "cartTotal",
                total);



        request.getRequestDispatcher(
                "/WEB-INF/views/cart.jsp")
                .forward(request, response);
    }



    // =========================================
    // ADD TO CART
    // =========================================

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);



        User user =
                (User) session.getAttribute(
                        "loggedInUser");



        // =========================================
        // PRODUCT ID
        // =========================================

        int productId =
                Integer.parseInt(
                request.getParameter(
                        "productId"));



        // =========================================
        // QUANTITY
        // =========================================

        int quantity = 1;

        String qty =
                request.getParameter(
                        "quantity");



        if(qty != null &&
           !qty.isEmpty()){

            quantity =
            Integer.parseInt(qty);
        }



        CartDAO cartDAO =
                new CartDAOImpl();



        ProductDAO productDAO =
                new ProductDAOImpl();



        // =========================================
        // GET PRODUCT
        // =========================================

        Product product =
                productDAO.getProductById(
                        productId);



        // =========================================
        // GET CART ID
        // =========================================

        int cartId =
                cartDAO.getCartIdByUserId(
                        user.getUserId());



        // =========================================
        // CREATE CART IF NOT EXISTS
        // =========================================

        if(cartId == 0){

            cartId =
                    cartDAO.createCart(
                            user.getUserId());
                }



                // =========================================
                // ADD PRODUCT TO DB CART
                // =========================================

                cartDAO.addToCart(
                        cartId,
                        productId,
                        quantity,
                        product.getPrice());



                // =========================================
                // REDIRECT
                // =========================================

                response.sendRedirect(
                        request.getContextPath()
                        + "/cart");
            }

        }