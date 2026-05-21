package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.ProductDAO;

import com.hidrip.dao.impl.ProductDAOImpl;

import com.hidrip.model.Product;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/products")
public class ProductsServlet
extends HttpServlet {

    private static final long serialVersionUID = 1L;



    // =========================================
    // LOAD PRODUCTS
    // =========================================

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        ProductDAO productDAO =
                new ProductDAOImpl();



        List<Product> products;



        // =========================================
        // GET PARAMETERS
        // =========================================

        String keyword =
                request.getParameter(
                        "keyword");



        String brand =
                request.getParameter(
                        "brand");



        // =========================================
        // SEARCH
        // =========================================

        if(keyword != null &&
           !keyword.trim().isEmpty()) {

            products =
            productDAO.searchProducts(
                    keyword);
        }



        // =========================================
        // FILTER
        // =========================================

        else if(brand != null &&
                !brand.trim().isEmpty()) {

            products =
            productDAO.filterProducts(
                    "",
                    brand);
        }



        // =========================================
        // LOAD ALL
        // =========================================

        else {

            products =
            productDAO.getAllProducts();
        }



        // =========================================
        // SEND TO JSP
        // =========================================

        request.setAttribute(
                "products",
                products);



        request.getRequestDispatcher(
                "/WEB-INF/views/products.jsp")
                .forward(request, response);
    }

}