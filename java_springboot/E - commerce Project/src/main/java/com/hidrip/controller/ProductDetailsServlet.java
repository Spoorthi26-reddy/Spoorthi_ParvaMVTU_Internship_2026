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



@WebServlet("/product-details")
public class ProductDetailsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // GET PRODUCT ID FROM URL

        int productId =
                Integer.parseInt(
                request.getParameter("id"));



        // DAO OBJECT

        ProductDAO productDAO =
                new ProductDAOImpl();



        // FETCH PRODUCT

        Product product =
                productDAO.getProductById(productId);



        // SEND PRODUCT TO JSP

        request.setAttribute("product",
                             product);



        // FORWARD TO JSP

        request.getRequestDispatcher(
                "/WEB-INF/views/product-details.jsp")
                .forward(request, response);
    }

}