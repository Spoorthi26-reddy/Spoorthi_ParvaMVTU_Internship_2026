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



@WebServlet("/admin/products")
public class AdminProductsServlet
extends HttpServlet {

    private static final long
    serialVersionUID = 1L;





    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {

        ProductDAO productDAO =
                new ProductDAOImpl();



        List<Product> products =
                productDAO.getAllProducts();



        request.setAttribute(
                "products",
                products);



        request.getRequestDispatcher(
        "/WEB-INF/admin/products.jsp")
        .forward(request,
                 response);
    }

}