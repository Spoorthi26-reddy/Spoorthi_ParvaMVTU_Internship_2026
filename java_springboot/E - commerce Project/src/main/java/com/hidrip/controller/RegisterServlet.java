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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    // =========================
    // LOAD REGISTER PAGE
    // =========================

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(
                "/WEB-INF/views/register.jsp")
                .forward(request, response);
    }



    // =========================
    // HANDLE REGISTER
    // =========================

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        // =========================
        // GET FORM DATA
        // =========================

        String fullName =
                request.getParameter("fullName");

        String email =
                request.getParameter("email");

        String phone =
                request.getParameter("phone");

        String password =
                request.getParameter("password");

        String gender =
                request.getParameter("gender");

        String address =
                request.getParameter("address");



        // =========================
        // DAO OBJECT
        // =========================

        UserDAO userDAO =
                new UserDAOImpl();



        // =========================
        // EMAIL VALIDATION
        // =========================

        if(userDAO.emailExists(email)) {

            request.setAttribute(
                    "errorMessage",
                    "Email already registered");

            request.getRequestDispatcher(
                    "/WEB-INF/views/register.jsp")
                    .forward(request, response);

            return;
        }



        // =========================
        // PHONE VALIDATION
        // =========================

        if(userDAO.phoneExists(phone)) {

            request.setAttribute(
                    "errorMessage",
                    "Phone number already exists");

            request.getRequestDispatcher(
                    "/WEB-INF/views/register.jsp")
                    .forward(request, response);

            return;
        }



        // =========================
        // CREATE USER OBJECT
        // =========================

        User user = new User();

        user.setFullName(fullName);

        user.setEmail(email);

        user.setPhone(phone);

        user.setPassword(password);

        user.setGender(gender);

        user.setAddress(address);



        // =========================
        // REGISTER USER
        // =========================

        boolean status =
                userDAO.registerUser(user);



        // =========================
        // SUCCESS
        // =========================

        if(status) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/login");
        }



        // =========================
        // FAILURE
        // =========================

        else {

            request.setAttribute(
                    "errorMessage",
                    "Registration failed");

            request.getRequestDispatcher(
                    "/WEB-INF/views/register.jsp")
                    .forward(request, response);
        }
    }

}