package com.hidrip.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;

import java.util.List;

import com.hidrip.model.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hidrip.dao.AdminDAO;
import com.hidrip.util.DBConnection;

public class AdminDAOImpl
implements AdminDAO {





    // =========================================
    // TOTAL USERS
    // =========================================

    @Override
    public int getTotalUsers() {

        int count = 0;

        String sql =
        "SELECT COUNT(*) FROM users";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery()) {

            if(rs.next()) {

                count =
                rs.getInt(1);
            }
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }





    // =========================================
    // TOTAL PRODUCTS
    // =========================================

    @Override
    public int getTotalProducts() {

        int count = 0;

        String sql =
        "SELECT COUNT(*) FROM products";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery()) {

            if(rs.next()) {

                count =
                rs.getInt(1);
            }
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }





    // =========================================
    // TOTAL ORDERS
    // =========================================

    @Override
    public int getTotalOrders() {

        int count = 0;

        String sql =
        "SELECT COUNT(*) FROM orders";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery()) {

            if(rs.next()) {

                count =
                rs.getInt(1);
            }
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return count;
    }


    /* =========================================
    RECENT ORDERS
 ========================================= */

 @Override
 public List<Order> getRecentOrders() {

     List<Order> orders =
             new ArrayList<>();



     String sql =
     "SELECT * FROM orders "
     + "ORDER BY order_date DESC "
     + "LIMIT 5";



     try(Connection con =
             DBConnection.getConnection();

         PreparedStatement ps =
         con.prepareStatement(sql);

         ResultSet rs =
         ps.executeQuery()) {

         while(rs.next()) {

             Order order =
                     new Order();



             order.setOrderId(
                     rs.getInt("order_id"));

             order.setUserId(
                     rs.getInt("user_id"));

             order.setTotalAmount(
                     rs.getDouble("total_amount"));

             order.setOrderStatus(
                     rs.getString("order_status"));

             order.setOrderDate(
                     rs.getTimestamp("order_date"));



             orders.add(order);
         }
     }

     catch(Exception e) {

         e.printStackTrace();
     }

     return orders;
 }


    // =========================================
    // TOTAL REVENUE
    // =========================================

    @Override
    public double getTotalRevenue() {

        double revenue = 0;

        String sql =
        "SELECT SUM(total_amount) "
        + "FROM orders";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql);

            ResultSet rs =
            ps.executeQuery()) {

            if(rs.next()) {

                revenue =
                rs.getDouble(1);
            }
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return revenue;
    }

}