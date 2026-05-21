package com.hidrip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hidrip.dao.CartItemDAO;
import com.hidrip.model.CartItem;
import com.hidrip.util.DBConnection;

public class CartItemDAOImpl implements CartItemDAO {

    @Override
    public boolean addToCart(CartItem item) {

        boolean status = false;

        String checkSql = "SELECT * FROM cart_items WHERE cart_id=? AND product_id=? AND size_label=?";
        String insertSql = "INSERT INTO cart_items(cart_id, product_id, size_label, quantity, unit_price) VALUES (?,?,?,?,?)";
        String updateSql = "UPDATE cart_items SET quantity=quantity+? WHERE cart_item_id=?";

        try (Connection con = DBConnection.getConnection()) {

            // Check if item already exists
            PreparedStatement checkPs = con.prepareStatement(checkSql);
            checkPs.setInt(1, item.getCartId());
            checkPs.setInt(2, item.getProductId());
            checkPs.setString(3, item.getSizeLabel());

            ResultSet rs = checkPs.executeQuery();

            if (rs.next()) {
                // Update quantity
                PreparedStatement updatePs = con.prepareStatement(updateSql);
                updatePs.setInt(1, item.getQuantity());
                updatePs.setInt(2, rs.getInt("cart_item_id"));

                status = updatePs.executeUpdate() > 0;

            } else {
                // Insert new item
                PreparedStatement insertPs = con.prepareStatement(insertSql);
                insertPs.setInt(1, item.getCartId());
                insertPs.setInt(2, item.getProductId());
                insertPs.setString(3, item.getSizeLabel());
                insertPs.setInt(4, item.getQuantity());
                insertPs.setDouble(5, item.getUnitPrice());

                status = insertPs.executeUpdate() > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public List<CartItem> getCartItems(int cartId) {

        List<CartItem> list = new ArrayList<>();

        String sql = "SELECT * FROM cart_items WHERE cart_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem item = new CartItem();
                item.setCartItemId(rs.getInt("cart_item_id"));
                item.setCartId(rs.getInt("cart_id"));
                item.setProductId(rs.getInt("product_id"));
                item.setSizeLabel(rs.getString("size_label"));
                item.setQuantity(rs.getInt("quantity"));
                item.setUnitPrice(rs.getDouble("unit_price"));

                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public CartItem getCartItem(int cartId, int productId, String sizeLabel) {

        CartItem item = null;

        String sql = "SELECT * FROM cart_items WHERE cart_id=? AND product_id=? AND size_label=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.setString(3, sizeLabel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                item = new CartItem();
                item.setCartItemId(rs.getInt("cart_item_id"));
                item.setCartId(rs.getInt("cart_id"));
                item.setProductId(rs.getInt("product_id"));
                item.setSizeLabel(rs.getString("size_label"));
                item.setQuantity(rs.getInt("quantity"));
                item.setUnitPrice(rs.getDouble("unit_price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public boolean updateQuantity(int cartItemId, int quantity) {

        boolean status = false;

        String sql = "UPDATE cart_items SET quantity=? WHERE cart_item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, quantity);
            ps.setInt(2, cartItemId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean removeCartItem(int cartItemId) {

        boolean status = false;

        String sql = "DELETE FROM cart_items WHERE cart_item_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartItemId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public boolean clearCart(int cartId) {

        boolean status = false;

        String sql = "DELETE FROM cart_items WHERE cart_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);

            status = ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public double getCartTotal(int cartId) {

        double total = 0;

        String sql = "SELECT SUM(quantity * unit_price) AS total FROM cart_items WHERE cart_id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                total = rs.getDouble("total");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return total;
    }
}