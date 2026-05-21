package com.hidrip.dao;

import java.util.List;
import com.hidrip.model.CartItem;

public interface CartItemDAO {

    // Add item to cart
    boolean addToCart(CartItem cartItem);

    // Get all items in a cart
    List<CartItem> getCartItems(int cartId);

    // Get specific item (product + size)
    CartItem getCartItem(int cartId, int productId, String sizeLabel);

    // Update quantity
    boolean updateQuantity(int cartItemId, int quantity);

    // Remove item from cart
    boolean removeCartItem(int cartItemId);

    // Clear entire cart
    boolean clearCart(int cartId);

    // Get total cart value
    double getCartTotal(int cartId);
}
