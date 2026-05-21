package com.hidrip.dao;

import java.util.List;

import com.hidrip.model.Product;

public interface WishlistDAO {

    // =========================================
    // ADD TO WISHLIST
    // =========================================

    boolean addToWishlist(int userId,
                          int productId);



    // =========================================
    // REMOVE FROM WISHLIST
    // =========================================

    boolean removeFromWishlist(int userId,
                               int productId);



    // =========================================
    // CHECK EXISTS
    // =========================================

    boolean isInWishlist(int userId,
                         int productId);



    // =========================================
    // GET USER WISHLIST
    // =========================================

    List<Product> getWishlistByUser(int userId);

}