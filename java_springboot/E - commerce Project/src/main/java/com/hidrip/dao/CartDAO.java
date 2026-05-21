package com.hidrip.dao;

import java.util.List;

import com.hidrip.model.CartItem;

public interface CartDAO {

    // =========================
    // CREATE CART
    // =========================

    int createCart(int userId);



    // =========================
    // GET CART ID BY USER
    // =========================

    int getCartIdByUserId(int userId);



    // =========================
    // ADD TO CART
    // =========================

    boolean addToCart(int cartId,
                      int productId,
                      int quantity,
                      double unitPrice);



    // =========================
    // GET CART ITEMS
    // =========================

    List<CartItem> getCartItems(int cartId);



    // =========================
    // UPDATE QUANTITY
    // =========================

    boolean updateQuantity(int cartItemId,
                           int quantity);



    // =========================
    // REMOVE CART ITEM
    // =========================

    boolean removeCartItem(int cartItemId);



    // =========================
    // CART TOTAL
    // =========================

    double getCartTotal(int cartId);
    // =========================
    // CLEAR CART
    // =========================

    boolean clearCart(int cartId);
    

}