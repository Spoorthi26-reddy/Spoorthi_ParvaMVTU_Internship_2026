package com.hidrip.filter;

import java.io.IOException;

import com.hidrip.model.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebFilter;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import jakarta.servlet.http.HttpFilter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;



@WebFilter({

    "/cart",

    "/checkout",

    "/orders"

})

public class AuthFilter extends HttpFilter
implements Filter {

    private static final long serialVersionUID = 1L;



    @Override
    public void init(FilterConfig fConfig)
            throws ServletException {

    }



    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req =
                (HttpServletRequest) request;

        HttpServletResponse res =
                (HttpServletResponse) response;



        // =========================
        // SESSION
        // =========================

        HttpSession session =
                req.getSession(false);



        // =========================
        // CHECK USER LOGIN
        // =========================

        User user = null;

        if(session != null){

            user =
            (User) session.getAttribute(
                    "loggedInUser");
        }



        // =========================
        // NOT LOGGED IN
        // =========================

        if(user == null){

            res.sendRedirect(
                    req.getContextPath()
                    + "/login");

            return;
        }



        // =========================
        // CONTINUE REQUEST
        // =========================

        chain.doFilter(request,
                       response);
    }



    @Override
    public void destroy() {

    }

}