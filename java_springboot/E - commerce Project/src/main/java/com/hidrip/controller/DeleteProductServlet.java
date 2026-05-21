package com.hidrip.controller;

import java.io.IOException;

import com.hidrip.dao.ProductDAO;

import com.hidrip.dao.impl.ProductDAOImpl;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/admin/delete-product")
public class DeleteProductServlet
extends HttpServlet {

    private static final long
    serialVersionUID = 1L;





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



        productDAO.deleteProduct(
                productId);




        response.sendRedirect(
                request.getContextPath()
                + "/admin/products");
    }

}