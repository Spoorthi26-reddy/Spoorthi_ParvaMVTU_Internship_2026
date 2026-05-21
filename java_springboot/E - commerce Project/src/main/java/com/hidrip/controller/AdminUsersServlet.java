package com.hidrip.controller;

import java.io.IOException;

import java.util.List;

import com.hidrip.dao.UserDAO;

import com.hidrip.dao.impl.UserDAOImpl;

import com.hidrip.model.User;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/admin/users")
public class AdminUsersServlet
extends HttpServlet {

    private static final long
    serialVersionUID = 1L;





    // =========================================
    // LOAD USERS
    // =========================================

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {

        UserDAO userDAO =
                new UserDAOImpl();



        List<User> users =
                userDAO.getAllUsers();



        request.setAttribute(
                "users",
                users);



        request.getRequestDispatcher(
        "/WEB-INF/admin/users.jsp")
        .forward(request,
                 response);
    }





    // =========================================
    // UPDATE ROLE
    // =========================================

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
                   IOException {

        int userId =
                Integer.parseInt(
                request.getParameter(
                        "userId"));



        String role =
                request.getParameter(
                        "role");



        UserDAO userDAO =
                new UserDAOImpl();



        userDAO.updateUserRole(
                userId,
                role);




        response.sendRedirect(
                request.getContextPath()
                + "/admin/users");
    }

}