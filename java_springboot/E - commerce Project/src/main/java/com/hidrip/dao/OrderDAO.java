package com.hidrip.dao;

import java.util.List;

import com.hidrip.model.Order;
import com.hidrip.model.OrderItem;

public interface OrderDAO {

    // =========================================
    // CREATE ORDER
    // =========================================

    int createOrder(Order order);



    // =========================================
    // ADD ORDER ITEM
    // =========================================

    boolean addOrderItem(OrderItem item);



    // =========================================
    // GET USER ORDERS
    // =========================================

    List<Order> getOrdersByUserId(int userId);



    // =========================================
    // GET ORDER ITEMS
    // =========================================

    List<OrderItem> getOrderItems(int orderId);



    // =========================================
    // GET SINGLE ORDER
    // =========================================

    Order getOrderById(int orderId);
    
    
    // =========================================
    // CANCEL ORDER
    // =========================================

    boolean cancelOrder(int orderId);
    
    
    
    
    
    
    
    
    
    List<Order> getAllOrders();

    boolean updateOrderStatus(
            int orderId,
            String status);

}