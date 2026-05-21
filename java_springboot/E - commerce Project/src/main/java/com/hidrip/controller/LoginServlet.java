package com.hidrip.controller;

import java.io.IOException;

import com.hidrip.dao.UserDAO;
import com.hidrip.dao.impl.UserDAOImpl;

import com.hidrip.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    // =========================
    // LOAD LOGIN PAGE
    // =========================

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/login.jsp")
                .forward(request, response);
    }



    // =========================
    // HANDLE LOGIN
    // =========================

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // =========================
        // GET FORM DATA
        // =========================

        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");



        // =========================
        // DAO OBJECT
        // =========================

        UserDAO userDAO =
                new UserDAOImpl();



        // =========================
        // LOGIN VALIDATION
        // =========================

        User user =
                userDAO.loginUser(
                        email,
                        password);



        // =========================
        // LOGIN SUCCESS
        // =========================

        if(user != null) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "loggedInUser",
                    user);

            response.sendRedirect(
                    request.getContextPath()
                    + "/home");
        }



        // =========================
        // LOGIN FAILED
        // =========================

        else {

            request.setAttribute(
                    "errorMessage",
                    "Invalid email or password");

            request.getRequestDispatcher(
                    "/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }
    }

}