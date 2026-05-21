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



@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;



    // =========================================
    // LOAD PROFILE PAGE
    // =========================================

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);



        // =========================================
        // CHECK LOGIN
        // =========================================

        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect(
                    request.getContextPath()
                    + "/login");

            return;
        }



        User user =
                (User) session.getAttribute(
                        "loggedInUser");



        request.setAttribute(
                "user",
                user);



        request.getRequestDispatcher(
                "/WEB-INF/views/profile.jsp")
                .forward(request, response);
    }



    // =========================================
    // UPDATE PROFILE
    // =========================================

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);



        if(session == null ||
           session.getAttribute("loggedInUser") == null){

            response.sendRedirect(
                    request.getContextPath()
                    + "/login");

            return;
        }



        User currentUser =
                (User) session.getAttribute(
                        "loggedInUser");



        // =========================================
        // FORM DATA
        // =========================================

        String fullName =
                request.getParameter(
                        "fullName");

        String phone =
                request.getParameter(
                        "phone");

        String address =
                request.getParameter(
                        "address");



        // =========================================
        // UPDATE USER OBJECT
        // =========================================

        currentUser.setFullName(
                fullName);

        currentUser.setPhone(
                phone);

        currentUser.setAddress(
                address);



        // =========================================
        // UPDATE DB
        // =========================================

        UserDAO userDAO =
                new UserDAOImpl();



        boolean status =
                userDAO.updateUser(
                        currentUser);



        // =========================================
        // SUCCESS
        // =========================================

        if(status){

            session.setAttribute(
                    "loggedInUser",
                    currentUser);

            request.setAttribute(
                    "successMessage",
                    "Profile Updated Successfully");
        }



        else{

            request.setAttribute(
                    "errorMessage",
                    "Profile Update Failed");
        }



        request.setAttribute(
                "user",
                currentUser);



        request.getRequestDispatcher(
                "/WEB-INF/views/profile.jsp")
                .forward(request, response);
    }

}