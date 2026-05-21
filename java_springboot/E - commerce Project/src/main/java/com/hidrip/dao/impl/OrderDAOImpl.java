package com.hidrip.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.hidrip.dao.OrderDAO;

import com.hidrip.model.Order;
import com.hidrip.model.OrderItem;
import com.hidrip.model.Product;

import com.hidrip.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

    // =========================================
    // CREATE ORDER
    // =========================================

    @Override
    public int createOrder(Order order) {

        int orderId = 0;

        String sql =
        "INSERT INTO orders "
        + "(user_id, total_amount, "
        + "payment_method, order_status, "
        + "delivery_address) "
        + "VALUES (?, ?, ?, ?, ?)";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(
                    sql,
                    PreparedStatement
                    .RETURN_GENERATED_KEYS)) {

            ps.setInt(
                    1,
                    order.getUserId());

            ps.setDouble(
                    2,
                    order.getTotalAmount());

            ps.setString(
                    3,
                    order.getPaymentMethod());

            ps.setString(
                    4,
                    order.getOrderStatus());

            ps.setString(
                    5,
                    order.getDeliveryAddress());



            int rows =
                    ps.executeUpdate();



            if(rows > 0) {

                ResultSet rs =
                        ps.getGeneratedKeys();

                if(rs.next()) {

                    orderId =
                    rs.getInt(1);
                }
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return orderId;
    }



    // =========================================
    // ADD ORDER ITEM
    // =========================================

    @Override
    public boolean addOrderItem(OrderItem item) {

        boolean status = false;

        String sql =
        "INSERT INTO order_items "
        + "(order_id, product_id, "
        + "quantity, unit_price) "
        + "VALUES (?, ?, ?, ?)";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(
                    1,
                    item.getOrderId());

            ps.setInt(
                    2,
                    item.getProductId());

            ps.setInt(
                    3,
                    item.getQuantity());

            ps.setDouble(
                    4,
                    item.getUnitPrice());



            status =
            ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }



    // =========================================
    // GET USER ORDERS
    // =========================================

    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> orders =
                new ArrayList<>();

        String sql =
        "SELECT * FROM orders "
        + "WHERE user_id=? "
        + "ORDER BY order_id DESC";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()) {

                Order order =
                        new Order();

                order.setOrderId(
                        rs.getInt(
                                "order_id"));

                order.setUserId(
                        rs.getInt(
                                "user_id"));

                order.setTotalAmount(
                        rs.getDouble(
                                "total_amount"));

                order.setPaymentMethod(
                        rs.getString(
                                "payment_method"));

                order.setOrderStatus(
                        rs.getString(
                                "order_status"));

                order.setDeliveryAddress(
                        rs.getString(
                                "delivery_address"));

                order.setOrderDate(
                        rs.getTimestamp(
                                "order_date"));



                orders.add(order);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return orders;
    }



    // =========================================
    // GET ORDER ITEMS
    // =========================================

    @Override
    public List<OrderItem> getOrderItems(int orderId) {

        List<OrderItem> items =
                new ArrayList<>();



        String sql =
        "SELECT oi.*, p.* "
        + "FROM order_items oi "
        + "JOIN products p "
        + "ON oi.product_id = p.product_id "
        + "WHERE oi.order_id=?";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()) {

                // PRODUCT

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

                product.setImageUrl(
                        rs.getString(
                                "image_url"));



                // ORDER ITEM

                OrderItem item =
                        new OrderItem();

                item.setOrderItemId(
                        rs.getInt(
                                "order_item_id"));

                item.setOrderId(
                        rs.getInt(
                                "order_id"));

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



                items.add(item);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return items;
    }



    // =========================================
    // GET SINGLE ORDER
    // =========================================

    @Override
    public Order getOrderById(int orderId) {

        Order order = null;

        String sql =
        "SELECT * FROM orders "
        + "WHERE order_id=?";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            ResultSet rs =
                    ps.executeQuery();



            if(rs.next()) {

                order =
                new Order();

                order.setOrderId(
                        rs.getInt(
                                "order_id"));

                order.setUserId(
                        rs.getInt(
                                "user_id"));

                order.setTotalAmount(
                        rs.getDouble(
                                "total_amount"));

                order.setPaymentMethod(
                        rs.getString(
                                "payment_method"));

                order.setOrderStatus(
                        rs.getString(
                                "order_status"));

                order.setDeliveryAddress(
                        rs.getString(
                                "delivery_address"));

                order.setOrderDate(
                        rs.getTimestamp(
                                "order_date"));
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return order;
    }
    /* =========================================
    GET ALL ORDERS
 ========================================= */

 @Override
 public List<Order> getAllOrders() {

     List<Order> orders =
             new ArrayList<>();



     String sql =
     "SELECT * FROM orders "
     + "ORDER BY order_date DESC";



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

             order.setOrderDate(
                     rs.getTimestamp("order_date"));

             order.setTotalAmount(
                     rs.getDouble("total_amount"));

             order.setPaymentMethod(
                     rs.getString("payment_method"));

             order.setOrderStatus(
                     rs.getString("order_status"));

             order.setDeliveryAddress(
                     rs.getString("delivery_address"));



             orders.add(order);
         }
     }

     catch(Exception e) {

         e.printStackTrace();
     }

     return orders;
 }





 /* =========================================
    UPDATE ORDER STATUS
 ========================================= */
 @Override
 public boolean updateOrderStatus(
         int orderId,
         String status) {

     boolean updated = false;



     String sql =
     "UPDATE orders "
     + "SET order_status=? "
     + "WHERE order_id=?";



     try(Connection con =
             DBConnection.getConnection();

         PreparedStatement ps =
         con.prepareStatement(sql)) {

         System.out.println(
         "Updating Order ID: "
         + orderId);

         System.out.println(
         "New Status: "
         + status);



         ps.setString(1,
                 status);

         ps.setInt(2,
                 orderId);



         int rows =
         ps.executeUpdate();



         System.out.println(
         "Rows Updated: "
         + rows);



         updated = rows > 0;
     }

     catch(Exception e) {

         e.printStackTrace();
     }

     return updated;
 }
    // =========================================
    // CANCEL ORDER
    // =========================================

    @Override
    public boolean cancelOrder(int orderId) {

        boolean status = false;

        String sql =
        "UPDATE orders "
        + "SET order_status='CANCELLED' "
        + "WHERE order_id=?";



        try(Connection con =
                DBConnection.getConnection();

            PreparedStatement ps =
            con.prepareStatement(sql)) {

            ps.setInt(1, orderId);

            status =
            ps.executeUpdate() > 0;
        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return status;
    }

}