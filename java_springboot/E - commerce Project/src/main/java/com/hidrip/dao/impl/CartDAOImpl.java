package com.hidrip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.hidrip.dao.CartDAO;

import com.hidrip.model.CartItem;
import com.hidrip.model.Product;

import com.hidrip.util.DBConnection;

public class CartDAOImpl implements CartDAO {

    private Connection con;

    public CartDAOImpl() {

        con = DBConnection.getConnection();
    }



    // =========================
    // CREATE CART
    // =========================

    @Override
    public int createCart(int userId) {

        int cartId = 0;

        try {

            String query =
            "INSERT INTO cart(user_id) VALUES(?)";

            PreparedStatement ps =
                    con.prepareStatement(
                    query,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, userId);

            int rows = ps.executeUpdate();

            if(rows > 0) {

                ResultSet rs =
                        ps.getGeneratedKeys();

                if(rs.next()) {

                    cartId =
                    rs.getInt(1);
                }
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return cartId;
    }



    // =========================
    // GET CART ID BY USER
    // =========================

    @Override
    public int getCartIdByUserId(int userId) {

        int cartId = 0;

        try {

            String query =
            "SELECT cart_id FROM cart "
            + "WHERE user_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                cartId =
                rs.getInt("cart_id");
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return cartId;
    }



    // =========================
    // ADD TO CART
    // =========================

    @Override
    public boolean addToCart(int cartId,
                             int productId,
                             int quantity,
                             double unitPrice) {

        try {

            // =========================
            // CHECK EXISTING PRODUCT
            // =========================

            String checkQuery =
            "SELECT quantity "
            + "FROM cart_items "
            + "WHERE cart_id=? "
            + "AND product_id=?";

            PreparedStatement ps1 =
                    con.prepareStatement(
                            checkQuery);

            ps1.setInt(1, cartId);
            ps1.setInt(2, productId);

            ResultSet rs =
                    ps1.executeQuery();



            // =========================
            // UPDATE QUANTITY
            // =========================

            if(rs.next()) {

                int oldQty =
                        rs.getInt(
                                "quantity");

                String updateQuery =
                "UPDATE cart_items "
                + "SET quantity=? "
                + "WHERE cart_id=? "
                + "AND product_id=?";

                PreparedStatement ps2 =
                        con.prepareStatement(
                                updateQuery);

                ps2.setInt(1,
                        oldQty + quantity);

                ps2.setInt(2,
                        cartId);

                ps2.setInt(3,
                        productId);

                return ps2.executeUpdate() > 0;
            }



            // =========================
            // INSERT NEW PRODUCT
            // =========================

            String insertQuery =
            "INSERT INTO cart_items("
            + "cart_id,"
            + "product_id,"
            + "quantity,"
            + "unit_price"
            + ") VALUES(?,?,?,?)";

            PreparedStatement ps3 =
                    con.prepareStatement(
                            insertQuery);

            ps3.setInt(1, cartId);
            ps3.setInt(2, productId);
            ps3.setInt(3, quantity);
            ps3.setDouble(4, unitPrice);

            return ps3.executeUpdate() > 0;

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }



    // =========================
    // GET CART ITEMS
    // =========================

    @Override
    public List<CartItem> getCartItems(int cartId) {

        List<CartItem> cartItems =
                new ArrayList<>();

        try {

            String query =
            "SELECT ci.cart_item_id, "
            + "ci.quantity, "
            + "ci.unit_price, "
            + "p.* "
            + "FROM cart_items ci "
            + "JOIN products p "
            + "ON ci.product_id = p.product_id "
            + "WHERE ci.cart_id=?";



            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(1, cartId);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()) {

                // =========================
                // PRODUCT
                // =========================

                Product product =
                        new Product();

                product.setProductId(
                        rs.getInt(
                                "product_id"));

                product.setProductName(
                        rs.getString(
                                "product_name"));

                product.setBrand(
                        rs.getString(
                                "brand"));

                product.setPrice(
                        rs.getDouble(
                                "price"));

                product.setDiscountPercent(
                        rs.getDouble(
                                "discount_percent"));

                product.setImageUrl(
                        rs.getString(
                                "image_url"));



                // =========================
                // CART ITEM
                // =========================

                CartItem item =
                        new CartItem();

                item.setCartItemId(
                        rs.getInt(
                                "cart_item_id"));

                item.setCartId(cartId);

                item.setProductId(
                        rs.getInt(
                                "product_id"));

                item.setQuantity(
                        rs.getInt(
                                "quantity"));

                item.setUnitPrice(
                        rs.getDouble(
                                "unit_price"));

                item.setProduct(product);



                cartItems.add(item);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return cartItems;
    }
    // =========================
    // UPDATE QUANTITY
    // =========================

    @Override
    public boolean updateQuantity(int cartItemId,
                                  int quantity) {

        try {

            String query =
            "UPDATE cart_items "
            + "SET quantity=? "
            + "WHERE cart_item_id=?";

            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(1, quantity);
            ps.setInt(2, cartItemId);

            return ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }



    // =========================
    // REMOVE CART ITEM
    // =========================

    @Override
    public boolean removeCartItem(
            int cartItemId) {

        try {

            String query =
            "DELETE FROM cart_items "
            + "WHERE cart_item_id=?";

            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(1, cartItemId);

            return ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }



    // =========================
    // CART TOTAL
    // =========================

    @Override
    public double getCartTotal(int cartId) {

        double total = 0;

        try {

            String query =
            "SELECT SUM(quantity * unit_price)"
            + " AS total "
            + "FROM cart_items "
            + "WHERE cart_id=?";

            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(1, cartId);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()) {

                total =
                rs.getDouble("total");
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return total;
    }
    // =========================
    // CLEAR CART
    // =========================

    @Override
    public boolean clearCart(int cartId) {

        try {

            String query =
            "DELETE FROM cart_items "
            + "WHERE cart_id=?";

            PreparedStatement ps =
                    con.prepareStatement(
                            query);

            ps.setInt(1, cartId);

            return ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return false;
    }

}