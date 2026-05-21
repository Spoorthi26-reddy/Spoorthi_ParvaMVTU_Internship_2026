package com.hidrip.controller;

import java.io.IOException;

import com.hidrip.dao.ProductDAO;

import com.hidrip.dao.impl.ProductDAOImpl;

import com.hidrip.model.Product;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/admin/edit-product")
public class EditProductServlet
extends HttpServlet {

    private static final long
    serialVersionUID = 1L;





    // =========================================
    // LOAD PRODUCT
    // =========================================

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {

        int productId =
                Integer.parseInt(
                request.getParameter(
                        "id"));



        ProductDAO productDAO =
                new ProductDAOImpl();



        Product product =
                productDAO.getProductById(
                        productId);



        request.setAttribute(
                "product",
                product);



        request.getRequestDispatcher(
        "/WEB-INF/admin/edit-product.jsp")
        .forward(request,
                 response);
    }





    // =========================================
    // UPDATE PRODUCT
    // =========================================

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {

        int productId =
                Integer.parseInt(
                request.getParameter(
                        "productId"));



        int categoryId =
                Integer.parseInt(
                request.getParameter(
                        "categoryId"));



        String productName =
                request.getParameter(
                        "productName");



        String brand =
                request.getParameter(
                        "brand");



        String description =
                request.getParameter(
                        "description");



        double price =
                Double.parseDouble(
                request.getParameter(
                        "price"));



        double discountPercent =
                Double.parseDouble(
                request.getParameter(
                        "discountPercent"));



        String imageUrl =
                request.getParameter(
                        "imageUrl");



        Product product =
                new Product();



        product.setProductId(
                productId);

        product.setCategoryId(
                categoryId);

        product.setProductName(
                productName);

        product.setBrand(
                brand);

        product.setDescription(
                description);

        product.setPrice(
                price);

        product.setDiscountPercent(
                discountPercent);

        product.setImageUrl(
                imageUrl);




        ProductDAO productDAO =
                new ProductDAOImpl();



        productDAO.updateProduct(
                product);




        response.sendRedirect(
                request.getContextPath()
                + "/admin/products");
    }

}