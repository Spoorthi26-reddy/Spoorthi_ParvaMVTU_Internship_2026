package com.hidrip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.hidrip.dao.WishlistDAO;

import com.hidrip.model.Product;

import com.hidrip.util.DBConnection;

public class WishlistDAOImpl
implements WishlistDAO {




    // =========================================
    // ADD TO WISHLIST
    // =========================================

    @Override
    public boolean addToWishlist(
            int userId,
            int productId) {

        boolean status = false;



        String sql =
        "INSERT INTO wishlist "
        + "(user_id, product_id) "
        + "VALUES (?, ?)";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    userId);

            ps.setInt(2,
                    productId);



            status =
            ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }




    // =========================================
    // REMOVE FROM WISHLIST
    // =========================================

    @Override
    public boolean removeFromWishlist(
            int userId,
            int productId) {

        boolean status = false;



        String sql =
        "DELETE FROM wishlist "
        + "WHERE user_id=? "
        + "AND product_id=?";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    userId);

            ps.setInt(2,
                    productId);



            status =
            ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }




    // =========================================
    // CHECK EXISTS
    // =========================================

    @Override
    public boolean isInWishlist(
            int userId,
            int productId) {

        boolean exists = false;



        String sql =
        "SELECT * FROM wishlist "
        + "WHERE user_id=? "
        + "AND product_id=?";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    userId);

            ps.setInt(2,
                    productId);



            ResultSet rs =
                    ps.executeQuery();



            exists = rs.next();
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return exists;
    }




    // =========================================
    // GET USER WISHLIST
    // =========================================

    @Override
    public List<Product> getWishlistByUser(
            int userId) {

        List<Product> products =
                new ArrayList<>();



        String sql =
        "SELECT p.* "
        + "FROM wishlist w "
        + "JOIN products p "
        + "ON w.product_id = p.product_id "
        + "WHERE w.user_id=?";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1,
                    userId);



            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()) {

                Product product =
                        new Product();

                product.setProductId(
                        rs.getInt(
                                "product_id"));

                product.setCategoryId(
                        rs.getInt(
                                "category_id"));

                product.setProductName(
                        rs.getString(
                                "product_name"));

                product.setBrand(
                        rs.getString(
                                "brand"));

                product.setDescription(
                        rs.getString(
                                "description"));

                product.setPrice(
                        rs.getDouble(
                                "price"));

                product.setDiscountPercent(
                        rs.getDouble(
                                "discount_percent"));

                product.setImageUrl(
                        rs.getString(
                                "image_url"));



                products.add(product);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return products;
    }

}