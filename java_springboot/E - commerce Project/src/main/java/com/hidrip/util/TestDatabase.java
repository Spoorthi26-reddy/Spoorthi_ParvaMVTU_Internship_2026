package com.hidrip.util;

import java.util.List;

import com.hidrip.dao.ProductDAO;
import com.hidrip.dao.impl.ProductDAOImpl;
import com.hidrip.model.Product;

public class TestDatabase {

    public static void main(String[] args) {

        ProductDAO productDAO = new ProductDAOImpl();

        // 1️⃣ Get all products
        List<Product> products = productDAO.getAllProducts();

        System.out.println("Total Products: " + products.size());

        // 2️⃣ Print some products
        for (Product p : products) {
            System.out.println("ID: " + p.getProductId());
            System.out.println("Name: " + p.getProductName());
            System.out.println("Image: " + p.getImageUrl());
            System.out.println("----------------------");
        }

        // 3️⃣ Get product by ID
        Product product = productDAO.getProductById(1);

        if (product != null) {
            System.out.println("Single Product:");
            System.out.println(product.getProductName());
        } else {
            System.out.println("Product not found");
        }
    }
}