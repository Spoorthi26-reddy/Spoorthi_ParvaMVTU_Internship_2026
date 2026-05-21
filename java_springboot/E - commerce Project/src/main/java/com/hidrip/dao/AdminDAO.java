package com.hidrip.dao;
import java.util.List;

import com.hidrip.model.Order;

public interface AdminDAO {

    int getTotalUsers();

    int getTotalProducts();

    int getTotalOrders();

    double getTotalRevenue();
    List<Order> getRecentOrders();
}